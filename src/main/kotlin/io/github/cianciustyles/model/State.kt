package io.github.cianciustyles.model

data class State(
    val board: Board,
    val g: Int,
    val h: Int,
    val previous: State? = null,
    val action: Action? = null
) : Comparable<State> {
    override fun compareTo(other: State): Int {
        return (g + h) - (other.g + other.h)
    }
}
