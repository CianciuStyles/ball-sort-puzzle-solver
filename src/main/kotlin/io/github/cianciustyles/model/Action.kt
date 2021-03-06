package io.github.cianciustyles.model

data class Action(
    val sourceStack: Int,
    val destinationStack: Int,
    val color: Color
) {
    override fun toString(): String {
        return "Move the $color ball from $sourceStack to $destinationStack"
    }
}
