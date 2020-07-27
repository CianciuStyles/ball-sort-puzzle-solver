package io.github.cianciustyles

import io.github.cianciustyles.model.Color

@ExperimentalStdlibApi
fun main() {
    val stacks = listOf(
        ArrayDeque(listOf(Color.RED, Color.LIGHT_GREEN, Color.LIGHT_GREEN, Color.LIGHT_GREEN)),
        ArrayDeque(listOf(Color.ORANGE, Color.RED, Color.PINK, Color.LIGHT_GREEN)),
        ArrayDeque(listOf(Color.PINK, Color.ORANGE, Color.RED, Color.ORANGE)),
        ArrayDeque(listOf(Color.BLUE, Color.PINK, Color.ORANGE, Color.PINK)),
        ArrayDeque(listOf(Color.BLUE, Color.BLUE, Color.BLUE, Color.RED)),
        ArrayDeque(),
        ArrayDeque()
    )

    val solver = Solver(stacks)
    val steps = solver.solve()

    steps.forEach { step ->
        println("Move the ${step.color} ball from stack ${step.sourceStack} to stack ${step.destinationStack}")
    }
}
