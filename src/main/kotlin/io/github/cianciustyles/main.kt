package io.github.cianciustyles

import io.github.cianciustyles.model.Board

@ExperimentalStdlibApi
fun main() {
    val board = Board.of(
        """
            PPLR
            OVLM
            bRYR
            DGCG
            OROC
            LBDB
            bGLV
            DCYM
            MCBb
            MBGP
            PDOY
            VYVb
            
            
    """
    )

    val solver = Solver(board)
    val steps = solver.solve()

    println("Solution with ${steps.size} steps found")
    steps.forEach { println(it) }
}
