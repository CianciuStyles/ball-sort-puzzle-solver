package io.github.cianciustyles.model

enum class Color(val code: Char) {
    BLUE('B'),
    BROWN('b'),
    CYAN('C'),
    DARK_GREEN('D'),
    GRAY('G'),
    LIGHT_GREEN('L'),
    MILITARY_GREEN('M'),
    ORANGE('O'),
    PINK('P'),
    RED('R'),
    VIOLET('V'),
    YELLOW('Y');

    companion object {
        private val colorMap = values().associateBy { it.code }

        fun fromCode(code: Char) = colorMap.getValue(code)
    }
}
