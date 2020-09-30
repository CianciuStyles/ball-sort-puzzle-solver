package io.github.cianciustyles
import io.github.cianciustyles.model.Action
import io.github.cianciustyles.model.Board
import io.github.cianciustyles.model.Color
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@ExperimentalStdlibApi
class SolverTest {
    @Test
    fun testLevel1() {
        // given
        val board = Board.of(
            """
            O
            OOO
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps)
            .hasSize(1)
            .isEqualTo(
                listOf(
                    Action(0, 1, Color.ORANGE)
                )
            )
    }

    @Test
    fun testLevel2() {
        // given
        val board = Board.of(
            """
            BOBO
            OBOB
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps)
            .hasSize(10)
            .isEqualTo(
                listOf(
                    Action(1, 2, Color.BLUE),
                    Action(0, 1, Color.ORANGE),
                    Action(0, 2, Color.BLUE),
                    Action(1, 0, Color.ORANGE),
                    Action(1, 0, Color.ORANGE),
                    Action(1, 2, Color.BLUE),
                    Action(0, 1, Color.ORANGE),
                    Action(0, 1, Color.ORANGE),
                    Action(0, 1, Color.ORANGE),
                    Action(0, 2, Color.BLUE)
                )
            )
    }

    @Test
    fun testLevel3() {
        // given
        val board = Board.of(
            """
            BORB
            OORB
            RBOR
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(10)
    }

    @Test
    fun testLevel4() {
        // given
        val board = Board.of(
            """
            BROO
            BRBR
            OBRO
            
        
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(11)
    }

    @Test
    fun testLevel5() {
        // given
        val board = Board.of(
            """
            LOBP
            OLBP
            PROR
            OPRB
            LLRB
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(17)
    }

    @Test
    fun testLevel10() {
        // given
        val board = Board.of(
            """
            PBLB
            OGPR
            BCCL
            POOL
            GGLR
            BRCC
            RPOG
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(24)
    }

    @Test
    fun testLevel15() {
        // given
        val board = Board.of(
            """
            BLLO
            PBRP
            PBPO
            RROB
            OLRL
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(17)
    }

    @Test
    fun testLevel20() {
        // given
        val board = Board.of(
            """
            BBOP
            OPCP
            GRGL
            RLCG
            BBCL
            GORC
            LROP
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(24)
    }

    @Test
    fun testLevel30() {
        // given
        val board = Board.of(
            """
            OPPP
            BBCL
            ORBP
            RGOL
            RGCG
            BCLC
            GROL
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(24)
    }

    @Test
    fun testLevel40() {
        // given
        val board = Board.of(
            """
            MPGO
            OLCV
            PMBL
            PCCG
            BMPB
            RVBR
            CLVG
            GLRM
            OROV
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(35)
    }

    @Test
    fun testLevel50() {
        // given
        val board = Board.of(
            """
            GVLO
            RPPP
            CLVL
            BCOG
            GCVB
            BCMP
            ORVL
            RMGM
            RBOM
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(38)
    }

    @Test
    fun testLevel60() {
        // given
        val board = Board.of(
            """
            RBRL
            LLPL
            CBPO
            GCGR
            BCPR
            COBG
            POOG
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(27)
    }

    @Test
    fun testLevel70() {
        // given
        val board = Board.of(
            """
            LRPC
            BBCL
            BPCG
            PVVC
            LMMO
            VVBM
            PLOR
            RGGO
            GOMR
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(31)
    }

    @Test
    fun testLevel80() {
        // given
        val board = Board.of(
            """
            OVGV
            VCCL
            LLGR
            BGBR
            OVPP
            CMBB
            CRPO
            GLRO
            MMMP
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(31)
    }

    @Test
    fun testLevel90() {
        // given
        val board = Board.of(
            """
            RORP
            BBCP
            CLOG
            GROC
            LCPL
            RBLO
            BGGP
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(25)
    }

    @Test
    fun testLevel100() {
        // given
        val board = Board.of(
            """
            POVL
            CGCP
            BPOL
            PMRR
            RVGR
            MMGG
            BCBL
            VOBO
            LVMC
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(34)
    }

    @Test
    fun testLevel125() {
        // given
        val board = Board.of(
            """
            BDCM
            CDOC
            GVBO
            OLPP
            MLLV
            YBRb
            DBbV
            MGYY
            VMDP
            PbYR
            RbLG
            GRCO
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(50)
    }

    @Test
    fun testLevel150() {
        // given
        val board = Board.of(
            """
            PPMB
            GRLR
            OGLM
            GCOM
            RBPO
            GCBV
            MVOV
            PCLB
            CLVR
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(35)
    }

    @Test
    fun testLevel175() {
        // given
        val board = Board.of(
            """
            OMRV
            YbPP
            OGCB
            LBYO
            PBBM
            bGVC
            DPRb
            OGDL
            RMDC
            CLYR
            MGbY
            VDLV
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(51)
    }

    @Test
    fun testLevel200() {
        // given
        val board = Board.of(
            """
            GGRV
            PROP
            MBCP
            BLVL
            GMVM
            ROBC
            LLCC
            MPOR
            GBVO
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(30)
    }

    @Test
    fun testLevel225() {
        // given
        val board = Board.of(
            """
            CBLO
            ODLD
            YVMV
            BLbB
            RRCG
            YDDR
            YCVB
            bbYO
            COGV
            GMPb
            PPRM
            MGPL
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(44)
    }

    @Test
    fun testLevel250() {
        // given
        val board = Board.of(
            """
            VGOM
            GMRB
            PLLR
            MPOC
            VBLP
            GOBR
            COLM
            CBPR
            VVGC
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(34)
    }

    @Test
    fun testLevel275() {
        // given
        val board = Board.of(
            """
            GMOC
            CDPL
            CMVC
            GbLR
            MbVY
            YLYR
            BVBL
            YGOR
            bDGB
            MPBP
            DOVb
            DRPO
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(52)
    }

    @Test
    fun testLevel300() {
        // given
        val board = Board.of(
            """
            OCMB
            CVGL
            GRRP
            ROLC
            RBPO
            BOVL
            GPVC
            BMVM
            MLGP
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(35)
    }

    @Test
    fun testLevel350() {
        // given
        val board = Board.of(
                """
            VVGC
            PMCB
            GLRV
            OLVP
            RMOL
            POBC
            BGRC
            MLRP
            OBGM
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(33)
    }

    @Test
    fun testLevel400() {
        // given
        val board = Board.of(
                """
            VOGO
            GOLP
            GMPV
            LLCP
            MVRP
            MOBB
            RRMG
            RBCL
            BVCC
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(31)
    }

    @Test
    fun testLevel450() {
        // given
        val board = Board.of(
                """
                BLLG
                BPCM
                ROVM
                LGMR
                PCGG
                BOBR
                PCVO
                VVOM
                RLCP
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(34)
    }

    @Test
    fun testLevel500() {
        // given
        val board = Board.of(
                """
                MVRO
                LBMG
                LCGR
                VBVC
                PGOR
                LGBP
                VBCO
                PMMC
                PRLO
            
            
        """
        )

        // when
        val solver = Solver(board)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(38)
    }
}
