package io.github.cianciustyles.model

@ExperimentalStdlibApi
data class State(
    val stacks: List<Stack>,
    val g: Int,
    val h: Int,
    val previous: State? = null,
    val action: Action? = null
) : Comparable<State> {
    override fun compareTo(other: State): Int {
        return (g + h) - (other.g + other.h)
    }
}
