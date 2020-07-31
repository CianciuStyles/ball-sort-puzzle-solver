package io.github.cianciustyles

import io.github.cianciustyles.model.Board

@ExperimentalStdlibApi
fun main() {
    val board = Board.of(
        """
        MMMC
        RVOG
        CBVL
        RVVL
        LBPR
        BPCP
        MOGL
        GRBO
        OCPG
        
        
    """
    )

    val solver = Solver(board)
    val steps = solver.solve()

    steps.forEach { println(it) }
}
