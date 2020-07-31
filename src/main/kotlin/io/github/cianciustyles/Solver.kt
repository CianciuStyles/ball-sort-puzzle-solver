package io.github.cianciustyles
import io.github.cianciustyles.model.Action
import io.github.cianciustyles.model.Board
import io.github.cianciustyles.model.Color
import io.github.cianciustyles.model.State
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
            if (currentState.h == 0) {
                return rebuildPath(currentState)
            }

            val nextStates = generateActions(currentState)
            for (nextState in nextStates) {
                if (seen.contains(nextState.board)) continue

                heap.add(nextState)
                seen.add(nextState.board)
            }
        }

        return listOf()
    }

    private fun heuristic(board: Board): Int {
        var total = 0

        for (stack in board.stacks) {
            val iterator = stack.iterator()
            var index = 0
            var firstColor: Color? = null

            while (iterator.hasNext()) {
                val ball = iterator.next()
                if (index == 0)
                    firstColor = ball
                else if (ball != firstColor)
                    total += 1

                index++
            }

            if (index > 0)
                total += stackMaxSize - index
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
