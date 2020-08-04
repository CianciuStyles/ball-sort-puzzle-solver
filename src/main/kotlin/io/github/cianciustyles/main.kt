package io.github.cianciustyles

import io.github.cianciustyles.model.Board

@ExperimentalStdlibApi
fun main() {
    val board = Board.of(
        """
        CCDB
        GMPV
        bRVO
        ORPO
        BYRD
        DbDY
        LRVb
        LPVL
        BCGM
        MGYb
        BLYG
        OPCM
        
        
    """
    )

    val solver = Solver(board)
    val steps = solver.solve()

    steps.forEach { println(it) }
}
