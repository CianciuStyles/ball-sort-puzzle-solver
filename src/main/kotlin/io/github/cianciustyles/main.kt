package io.github.cianciustyles

import io.github.cianciustyles.model.Color
import java.util.ArrayDeque

fun main() {
    val stacks = listOf<ArrayDeque<Color>>(
        ArrayDeque(listOf(Color.RED, Color.LIGHT_GREEN, Color.LIGHT_GREEN, Color.LIGHT_GREEN)),
        ArrayDeque(listOf(Color.ORANGE, Color.RED, Color.PINK, Color.LIGHT_GREEN)),
        ArrayDeque(listOf(Color.PINK, Color.ORANGE, Color.RED, Color.ORANGE)),
        ArrayDeque(listOf(Color.BLUE, Color.PINK, Color.ORANGE, Color.PINK)),
        ArrayDeque(listOf(Color.BLUE, Color.BLUE, Color.BLUE, Color.RED)),
        ArrayDeque(),
        ArrayDeque()
    )

    val solver = Solver(stacks, 4)
    val steps = solver.solve()

    steps.forEach { step ->
        println("Move the ${step.color} ball from stack ${step.sourceStack} to stack ${step.destinationStack}")
    }
}
