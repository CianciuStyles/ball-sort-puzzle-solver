package io.github.cianciustyles.model

enum class Color(val code: Char) {
    BLUE('B'),
    CYAN('C'),
    GRAY('G'),
    LIGHT_GREEN('L'),
    MILITARY_GREEN('M'),
    ORANGE('O'),
    PINK('P'),
    RED('R'),
    VIOLET('V');

    companion object {
        private val colorMap = values()
            .map { Pair(it.code, it) }
            .toMap()

        fun fromCode(code: Char) = colorMap.getValue(code)
    }
}
