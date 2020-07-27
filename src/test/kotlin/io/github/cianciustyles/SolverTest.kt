package io.github.cianciustyles
import io.github.cianciustyles.model.Action
import io.github.cianciustyles.model.Color
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@ExperimentalStdlibApi
class SolverTest {
    @Test
    fun testLevel1() {
        // given
        val stacks = listOf(
            ArrayDeque(listOf(Color.ORANGE)),
            ArrayDeque(listOf(Color.ORANGE, Color.ORANGE, Color.ORANGE))
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
            ArrayDeque(listOf(Color.BLUE, Color.ORANGE, Color.BLUE, Color.ORANGE)),
            ArrayDeque(listOf(Color.ORANGE, Color.BLUE, Color.ORANGE, Color.BLUE)),
            ArrayDeque()
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
            ArrayDeque(listOf(Color.BLUE, Color.ORANGE, Color.RED, Color.BLUE)),
            ArrayDeque(listOf(Color.ORANGE, Color.ORANGE, Color.RED, Color.BLUE)),
            ArrayDeque(listOf(Color.RED, Color.BLUE, Color.ORANGE, Color.RED)),
            ArrayDeque(),
            ArrayDeque()
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
            ArrayDeque(listOf(Color.BLUE, Color.RED, Color.ORANGE, Color.ORANGE)),
            ArrayDeque(listOf(Color.BLUE, Color.RED, Color.BLUE, Color.RED)),
            ArrayDeque(listOf(Color.ORANGE, Color.BLUE, Color.RED, Color.ORANGE)),
            ArrayDeque(),
            ArrayDeque()
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
            ArrayDeque(listOf(Color.LIGHT_GREEN, Color.ORANGE, Color.BLUE, Color.PINK)),
            ArrayDeque(listOf(Color.ORANGE, Color.LIGHT_GREEN, Color.BLUE, Color.PINK)),
            ArrayDeque(listOf(Color.PINK, Color.RED, Color.ORANGE, Color.RED)),
            ArrayDeque(listOf(Color.ORANGE, Color.PINK, Color.RED, Color.BLUE)),
            ArrayDeque(listOf(Color.LIGHT_GREEN, Color.LIGHT_GREEN, Color.RED, Color.BLUE)),
            ArrayDeque(),
            ArrayDeque()
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
            ArrayDeque(listOf(Color.PINK, Color.BLUE, Color.LIGHT_GREEN, Color.BLUE)),
            ArrayDeque(listOf(Color.ORANGE, Color.GRAY, Color.PINK, Color.RED)),
            ArrayDeque(listOf(Color.BLUE, Color.CYAN, Color.CYAN, Color.LIGHT_GREEN)),
            ArrayDeque(listOf(Color.PINK, Color.ORANGE, Color.ORANGE, Color.LIGHT_GREEN)),
            ArrayDeque(listOf(Color.GRAY, Color.GRAY, Color.LIGHT_GREEN, Color.RED)),
            ArrayDeque(listOf(Color.BLUE, Color.RED, Color.CYAN, Color.CYAN)),
            ArrayDeque(listOf(Color.RED, Color.PINK, Color.ORANGE, Color.GRAY)),
            ArrayDeque(),
            ArrayDeque()
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
            ArrayDeque(listOf(Color.BLUE, Color.LIGHT_GREEN, Color.LIGHT_GREEN, Color.ORANGE)),
            ArrayDeque(listOf(Color.PINK, Color.BLUE, Color.RED, Color.PINK)),
            ArrayDeque(listOf(Color.PINK, Color.BLUE, Color.PINK, Color.ORANGE)),
            ArrayDeque(listOf(Color.RED, Color.RED, Color.ORANGE, Color.BLUE)),
            ArrayDeque(listOf(Color.ORANGE, Color.LIGHT_GREEN, Color.RED, Color.LIGHT_GREEN)),
            ArrayDeque(),
            ArrayDeque()
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
            ArrayDeque(listOf(Color.BLUE, Color.BLUE, Color.ORANGE, Color.PINK)),
            ArrayDeque(listOf(Color.ORANGE, Color.PINK, Color.CYAN, Color.PINK)),
            ArrayDeque(listOf(Color.GRAY, Color.RED, Color.GRAY, Color.LIGHT_GREEN)),
            ArrayDeque(listOf(Color.RED, Color.LIGHT_GREEN, Color.CYAN, Color.GRAY)),
            ArrayDeque(listOf(Color.BLUE, Color.BLUE, Color.CYAN, Color.LIGHT_GREEN)),
            ArrayDeque(listOf(Color.GRAY, Color.ORANGE, Color.RED, Color.CYAN)),
            ArrayDeque(listOf(Color.LIGHT_GREEN, Color.RED, Color.ORANGE, Color.PINK)),
            ArrayDeque(),
            ArrayDeque()
        )

        // when
        val solver = Solver(stacks)
        val steps = solver.solve()

        // then
        assertThat(steps).hasSize(24)
    }
}
