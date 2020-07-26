package io.github.cianciustyles
import io.github.cianciustyles.model.Action
import io.github.cianciustyles.model.Color
import io.github.cianciustyles.model.State
import java.util.ArrayDeque
import java.util.Deque
import java.util.PriorityQueue

class Solver(
    private val stacks: List<Deque<Color>>,
    private val stackMaxSize: Int
) {
    fun solve(): List<Action> {
        val heap = PriorityQueue<State>()
        heap.add(State(deepCopy(stacks), 0, heuristic(stacks)))

        while (!heap.isEmpty()) {
            val currentState = heap.poll()
            if (currentState.h == 0) {
                return rebuildPath(currentState)
            }

            val nextStates = generateActions(currentState)
            for (nextState in nextStates)
                heap.add(nextState)
        }

        return listOf()
    }

    private fun deepCopy(list: List<Deque<Color>>): List<Deque<Color>> {
        val newList = mutableListOf<Deque<Color>>()
        for (stack in list) {
            val newStack = ArrayDeque<Color>()
            for (color in stack)
                newStack.addLast(color)
            newList.add(newStack)
        }

        return newList.toList()
    }

    private fun heuristic(stacks: List<Deque<Color>>): Int {
        var total = 0

        for (stack in stacks) {
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

        for (i in stacks.indices) {
            for (j in stacks.indices) {
                if (i == j) continue

                if (isLegalMove(parentState.stacks, i, j)) {
                    val newStacks = deepCopy(parentState.stacks).toMutableList()
                    val ballMoving = newStacks[i].pollLast()
                    newStacks[j].addLast(ballMoving)

                    val action = Action(i, j, ballMoving)
                    val newState = State(newStacks, parentState.g + 1, heuristic(newStacks), parentState, action)
                    nextStates.add(newState)
                }
            }
        }

        return nextStates.toList()
    }

    private fun isLegalMove(stacks: List<Deque<Color>>, i: Int, j: Int): Boolean {
        if (stacks[i].isEmpty())
            return false

        if (stacks[j].isEmpty())
            return true

        return stacks[i].peekLast() == stacks[j].peekLast() && stacks[j].size < stackMaxSize
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
