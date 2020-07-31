package io.github.cianciustyles

import io.github.cianciustyles.model.Stack

@ExperimentalStdlibApi
fun main() {
    val stacks = listOf(
        Stack.of("MMMC"),
        Stack.of("RVOG"),
        Stack.of("CBVL"),
        Stack.of("RVVL"),
        Stack.of("LBPR"),
        Stack.of("BPCP"),
        Stack.of("MOGL"),
        Stack.of("GRBO"),
        Stack.of("OCPG"),
        Stack.of(), Stack.of()
    )

    val solver = Solver(stacks)
    val steps = solver.solve()

    steps.forEach { println(it) }
}
