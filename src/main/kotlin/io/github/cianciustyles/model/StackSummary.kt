package io.github.cianciustyles.model

data class StackSummary(
    val baseColorPrefix: Int,
    val otherColors: Int
) : Comparable<StackSummary> {
    override fun compareTo(other: StackSummary): Int {
        return if (this.baseColorPrefix == other.baseColorPrefix) {
            this.otherColors - other.otherColors
        } else {
            other.baseColorPrefix - this.baseColorPrefix
        }
    }
}
