package io.github.cianciustyles.model

@ExperimentalStdlibApi
data class Stack(private val balls: ArrayDeque<Color>) {
    fun addLast(color: Color) = balls.addLast(color)

    fun copy() = Stack(ArrayDeque(balls))

    override fun equals(other: Any?) =
        when (other) {
            is Stack -> balls == other.balls
            else -> false
        }

    operator fun get(i: Int) = balls[i]

    override fun hashCode() = balls.hashCode()

    fun isEmpty() = balls.isEmpty()

    fun iterator() = balls.iterator()

    fun last() = balls.last()

    fun removeLast() = balls.removeLast()

    val size get() = balls.size

    companion object {
        fun of(): Stack {
            return Stack(ArrayDeque())
        }

        fun of(balls: String): Stack {
            return Stack(ArrayDeque(balls.map { Color.fromCode(it) }))
        }
    }
}
