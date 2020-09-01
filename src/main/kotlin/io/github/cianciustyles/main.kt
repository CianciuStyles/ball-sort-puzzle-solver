package io.github.cianciustyles

import io.github.cianciustyles.model.Board

@ExperimentalStdlibApi
fun main() {
    val board = Board.of(
        """
                VYMb
                PLRR
                OCVP
                PPMM
                BRGb
                DCGY
                ObMB
                OCYV
                DLLC
                LRBO
                GGDV
                BDYb
        
        
    """
    )

    val solver = Solver(board)
    val steps = solver.solve()

    println("Solution with ${steps.size} steps found")
    steps.forEach { println(it) }
}
