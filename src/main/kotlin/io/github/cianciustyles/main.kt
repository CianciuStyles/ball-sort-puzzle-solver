package io.github.cianciustyles

import io.github.cianciustyles.model.Board

@ExperimentalStdlibApi
fun main() {
    val board = Board.of(
        """
            RGLP
            VPDY
            BVbb
            LMLC
            YVBG
            OCbR
            CYBD
            MOOV
            bRML
            YDGD
            PRBP
            MCOG
            
            
    """
    )

    val solver = Solver(board)
    val steps = solver.solve()

    println("Solution with ${steps.size} steps found")
    steps.forEach { println(it) }
}
