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
        fun fromCode(code: Char): Color {
            return values().first { it.code == code }
        }
    }
}
