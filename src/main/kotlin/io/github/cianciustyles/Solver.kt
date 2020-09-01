package io.github.cianciustyles
import io.github.cianciustyles.model.Action
import io.github.cianciustyles.model.Board
import io.github.cianciustyles.model.Color
import io.github.cianciustyles.model.State
import java.lang.IndexOutOfBoundsException
import java.util.PriorityQueue

@ExperimentalStdlibApi
class Solver(
    private val board: Board,
    private val stackMaxSize: Int = 4
) {
    fun solve(): List<Action> {
        val heap = PriorityQueue<State>()
        heap.add(State(board.copy(), 0, heuristic(board)))
        val seen = mutableSetOf<Board>()

        while (!heap.isEmpty()) {
            val currentState = heap.poll()
            if (seen.contains(currentState.board))
                continue
            if (currentState.h == 0)
                return rebuildPath(currentState)

            val nextStates = generateActions(currentState)
            for (nextState in nextStates)
                heap.add(nextState)

            seen.add(currentState.board)
        }

        return listOf()
    }

    private fun heuristic(board: Board): Int {
        var total = 0
        val seen = mutableSetOf<Color>()

        for (stack in board.stacks) {
            if (stack.isEmpty()) continue

            val baseColor = stack[0]
            if (seen.contains(baseColor)) {
                total += stack.size
                continue
            }

            for (i in 1 until stack.size) {
                try {
                    if (stack[i] != baseColor) total += 1
                } catch (e: IndexOutOfBoundsException) {
                    total += 1
                }
            }

            seen.add(baseColor)
        }

        return total
    }

    private fun generateActions(parentState: State): List<State> {
        val nextStates = mutableListOf<State>()

        for (i in board.stacks.indices) {
            for (j in board.stacks.indices) {
                if (i == j) continue

                if (isLegalMove(parentState.board, i, j)) {
                    val newStacks = parentState.board.copy()
                    val ballMoving = newStacks[i].removeLast()
                    newStacks[j].addLast(ballMoving)

                    val action = Action(i, j, ballMoving)
                    val newState = State(newStacks, parentState.g + 1, heuristic(newStacks), parentState, action)
                    nextStates.add(newState)
                }
            }
        }

        return nextStates.toList()
    }

    private fun isLegalMove(board: Board, i: Int, j: Int): Boolean {
        if (board[i].isEmpty())
            return false

        if (board[j].isEmpty())
            return true

        return board[i].last() == board[j].last() && board[j].size < stackMaxSize
    }

    private fun rebuildPath(finalState: State): List<Action> {
        val path = mutableListOf<Action>()

        var currentState: State? = finalState
        while (currentState?.previous != null) {
            path.add(currentState.action!!)
            currentState = currentState.previous
        }

        return path.reversed().toList()
    }
}
