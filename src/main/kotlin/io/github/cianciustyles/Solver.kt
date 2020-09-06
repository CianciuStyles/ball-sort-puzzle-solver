package io.github.cianciustyles
import io.github.cianciustyles.model.Action
import io.github.cianciustyles.model.Board
import io.github.cianciustyles.model.Color
import io.github.cianciustyles.model.Stack
import io.github.cianciustyles.model.StackSummary
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
        val stackSummariesByColor = mutableMapOf<Color, PriorityQueue<StackSummary>>()
        for (stack in board.stacks) {
            if (stack.isEmpty()) continue

            val (baseColor, stackSummary) = examineStack(stack)
            stackSummariesByColor
                .getOrPut(baseColor, { PriorityQueue() })
                .add(stackSummary)
        }

        return countMisplacedColors(stackSummariesByColor)
    }

    private fun examineStack(stack: Stack): Pair<Color, StackSummary> {
        val baseColor = stack[0]
        var baseColorPrefix = 1
        var otherColors = 0

        for (i in 1 until stack.size) {
            if (stack[i] == baseColor) {
                baseColorPrefix += 1
            } else {
                otherColors = stack.size - i
                break
            }
        }

        return baseColor to StackSummary(baseColorPrefix, otherColors)
    }

    private fun countMisplacedColors(stacksByColor: MutableMap<Color, PriorityQueue<StackSummary>>): Int {
        var total = 0

        for (summaries in stacksByColor.values) {
            val stackWithLongestPrefix = summaries.poll()
            total += stackWithLongestPrefix.otherColors

            while (summaries.isNotEmpty()) {
                val otherStack = summaries.poll()
                total += otherStack.baseColorPrefix + otherStack.otherColors
            }
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
