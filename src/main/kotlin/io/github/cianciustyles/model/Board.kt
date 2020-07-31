package io.github.cianciustyles.model

@ExperimentalStdlibApi
data class Board(val stacks: List<Stack>) {
    fun copy() = Board(stacks.map { it.copy() })

    operator fun get(index: Int) = stacks[index]

    override fun equals(other: Any?) = when (other) {
        is Board -> stacks == other.stacks
        else -> false
    }

    override fun hashCode() = stacks.hashCode()

    companion object {
        fun of(text: String): Board {
            return Board(
                text
                    .trimIndent()
                    .split('\n')
                    .map { Stack.of(it) }
            )
        }
    }
}
