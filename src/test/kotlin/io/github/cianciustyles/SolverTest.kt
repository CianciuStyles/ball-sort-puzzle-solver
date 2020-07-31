package io.github.cianciustyles
import io.github.cianciustyles.model.Action
import io.github.cianciustyles.model.Color
import io.github.cianciustyles.model.Stack
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@ExperimentalStdlibApi
class SolverTest {
    @Test
    fun testLevel1() {
        // given
        val stacks = listOf(
            Stack.of("O"),
            Stack.of("OOO")
        )

        // when
        val solver = Solver(stacks)
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
        val stacks = listOf(
            Stack.of("BOBO"),
            Stack.of("OBOB"),
            Stack.of()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps)
            .hasSize(10)
            .isEqualTo(
                listOf(
                    Action(0, 2, Color.ORANGE),
                    Action(1, 0, Color.BLUE),
                    Action(1, 2, Color.ORANGE),
                    Action(0, 1, Color.BLUE),
                    Action(0, 1, Color.BLUE),
                    Action(0, 2, Color.ORANGE),
                    Action(1, 0, Color.BLUE),
                    Action(1, 0, Color.BLUE),
                    Action(1, 0, Color.BLUE),
                    Action(1, 2, Color.ORANGE)
                )
            )
    }

    @Test
    fun testLevel3() {
        // given
        val stacks = listOf(
            Stack.of("BORB"),
            Stack.of("OORB"),
            Stack.of("RBOR"),
            Stack.of(),
            Stack.of()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(10)
    }

    @Test
    fun testLevel4() {
        // given
        val stacks = listOf(
            Stack.of("BROO"),
            Stack.of("BRBR"),
            Stack.of("OBRO"),
            Stack.of(),
            Stack.of()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(11)
    }

    @Test
    fun testLevel5() {
        // given
        val stacks = listOf(
            Stack.of("LOBP"),
            Stack.of("OLBP"),
            Stack.of("PROR"),
            Stack.of("OPRB"),
            Stack.of("LLRB"),
            Stack.of(),
            Stack.of()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(17)
    }

    @Test
    fun testLevel10() {
        // given
        val stacks = listOf(
            Stack.of("PBLB"),
            Stack.of("OGPR"),
            Stack.of("BCCL"),
            Stack.of("POOL"),
            Stack.of("GGLR"),
            Stack.of("BRCC"),
            Stack.of("RPOG"),
            Stack.of(),
            Stack.of()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(24)
    }

    @Test
    fun testLevel15() {
        // given
        val stacks = listOf(
            Stack.of("BLLO"),
            Stack.of("PBRP"),
            Stack.of("PBPO"),
            Stack.of("RROB"),
            Stack.of("OLRL"),
            Stack.of(),
            Stack.of()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(17)
    }

    @Test
    fun testLevel20() {
        // given
        val stacks = listOf(
            Stack.of("BBOP"),
            Stack.of("OPCP"),
            Stack.of("GRGL"),
            Stack.of("RLCG"),
            Stack.of("BBCL"),
            Stack.of("GORC"),
            Stack.of("LROP"),
            Stack.of(),
            Stack.of()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(24)
    }

    @Test
    fun testLevel30() {
        // given
        val stacks = listOf(
            Stack.of("OPPP"),
            Stack.of("BBCL"),
            Stack.of("ORBP"),
            Stack.of("RGOL"),
            Stack.of("RGCG"),
            Stack.of("BCLC"),
            Stack.of("GROL"),
            Stack.of(),
            Stack.of()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(26)
    }

    @Test
    fun testLevel40() {
        // given
        val stacks = listOf(
            Stack.of("MPGO"),
            Stack.of("OLCV"),
            Stack.of("PMBL"),
            Stack.of("PCCG"),
            Stack.of("BMPB"),
            Stack.of("RVBR"),
            Stack.of("CLVG"),
            Stack.of("GLRM"),
            Stack.of("OROV"),
            Stack.of(),
            Stack.of()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(36)
    }

    @Test
    fun testLevel50() {
        // given
        val stacks = listOf(
            Stack.of("GVLO"),
            Stack.of("RPPP"),
            Stack.of("CLVL"),
            Stack.of("BCOG"),
            Stack.of("GCVB"),
            Stack.of("BCMP"),
            Stack.of("ORVL"),
            Stack.of("RMGM"),
            Stack.of("RBOM"),
            Stack.of(),
            Stack.of()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(38)
    }

    @Test
    fun testLevel60() {
        // given
        val stacks = listOf(
            Stack.of("RBRL"),
            Stack.of("LLPL"),
            Stack.of("CBPO"),
            Stack.of("GCGR"),
            Stack.of("BCPR"),
            Stack.of("COBG"),
            Stack.of("POOG"),
            Stack.of(),
            Stack.of()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(27)
    }

    @Test
    fun testLevel70() {
        // given
        val stacks = listOf(
            Stack.of("LRPC"),
            Stack.of("BBCL"),
            Stack.of("BPCG"),
            Stack.of("PVVC"),
            Stack.of("LMMO"),
            Stack.of("VVBM"),
            Stack.of("PLOR"),
            Stack.of("RGGO"),
            Stack.of("GOMR"),
            Stack.of(),
            Stack.of()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(32)
    }

    @Test
    fun testLevel80() {
        // given
        val stacks = listOf(
            Stack.of("OVGV"),
            Stack.of("VCCL"),
            Stack.of("LLGR"),
            Stack.of("BGBR"),
            Stack.of("OVPP"),
            Stack.of("CMBB"),
            Stack.of("CRPO"),
            Stack.of("GLRO"),
            Stack.of("MMMP"),
            Stack.of(),
            Stack.of()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(31)
    }
}
