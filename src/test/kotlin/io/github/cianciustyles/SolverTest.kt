package io.github.cianciustyles
import io.github.cianciustyles.Solver
import io.github.cianciustyles.model.Action
import io.github.cianciustyles.model.Color
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.ArrayDeque
import java.util.Deque

class SolverTest {
    @Test
    fun testLevel1() {
        // given
        val stacks = listOf<Deque<Color>>(
            ArrayDeque<Color>(listOf(Color.ORANGE)),
            ArrayDeque<Color>(listOf(Color.ORANGE, Color.ORANGE, Color.ORANGE))
        )

        // when
        val solver = Solver(stacks, 4)
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
        val stacks = listOf<Deque<Color>>(
            ArrayDeque(listOf(Color.BLUE, Color.ORANGE, Color.BLUE, Color.ORANGE)),
            ArrayDeque(listOf(Color.ORANGE, Color.BLUE, Color.ORANGE, Color.BLUE)),
            ArrayDeque()
        )

        // when
        val solver = Solver(stacks, 4)
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
        val stacks = listOf<Deque<Color>>(
            ArrayDeque(listOf(Color.BLUE, Color.ORANGE, Color.RED, Color.BLUE)),
            ArrayDeque(listOf(Color.ORANGE, Color.ORANGE, Color.RED, Color.BLUE)),
            ArrayDeque(listOf(Color.RED, Color.BLUE, Color.ORANGE, Color.RED)),
            ArrayDeque(),
            ArrayDeque()
        )

        // when
        val solver = Solver(stacks, 4)
        val steps = solver.solve()

        // then
        assertThat(steps)
            .hasSize(10)
            .isEqualTo(
                listOf(
                    Action(0, 4, Color.BLUE),
                    Action(1, 4, Color.BLUE),
                    Action(0, 3, Color.RED),
                    Action(1, 3, Color.RED),
                    Action(0, 1, Color.ORANGE),
                    Action(0, 4, Color.BLUE),
                    Action(2, 3, Color.RED),
                    Action(2, 1, Color.ORANGE),
                    Action(2, 4, Color.BLUE),
                    Action(2, 3, Color.RED)
                )
            )
    }

    @Test
    fun testLevel4() {
        // given
        val stacks = listOf<Deque<Color>>(
            ArrayDeque(listOf(Color.BLUE, Color.RED, Color.ORANGE, Color.ORANGE)),
            ArrayDeque(listOf(Color.BLUE, Color.RED, Color.BLUE, Color.RED)),
            ArrayDeque(listOf(Color.ORANGE, Color.BLUE, Color.RED, Color.ORANGE)),
            ArrayDeque(),
            ArrayDeque()
        )

        // when
        val solver = Solver(stacks, 4)
        val steps = solver.solve()

        // then
        assertThat(steps)
            .hasSize(11)
            .isEqualTo(
                listOf(
                    Action(0, 3, Color.ORANGE),
                    Action(2, 3, Color.ORANGE),
                    Action(2, 4, Color.RED),
                    Action(0, 3, Color.ORANGE),
                    Action(0, 4, Color.RED),
                    Action(2, 0, Color.BLUE),
                    Action(2, 3, Color.ORANGE),
                    Action(1, 4, Color.RED),
                    Action(1, 0, Color.BLUE),
                    Action(1, 4, Color.RED),
                    Action(1, 0, Color.BLUE)
                )
            )
    }

    @Test
    fun testLevel5() {
        // given
        val stacks = listOf<Deque<Color>>(
            ArrayDeque(listOf(Color.LIGHT_GREEN, Color.ORANGE, Color.BLUE, Color.PINK)),
            ArrayDeque(listOf(Color.ORANGE, Color.LIGHT_GREEN, Color.BLUE, Color.PINK)),
            ArrayDeque(listOf(Color.PINK, Color.RED, Color.ORANGE, Color.RED)),
            ArrayDeque(listOf(Color.ORANGE, Color.PINK, Color.RED, Color.BLUE)),
            ArrayDeque(listOf(Color.LIGHT_GREEN, Color.LIGHT_GREEN, Color.RED, Color.BLUE)),
            ArrayDeque(),
            ArrayDeque()
        )

        // when
        val solver = Solver(stacks, 4)
        val steps = solver.solve()

        // then
        assertThat(steps)
            .hasSize(17)
            .isEqualTo(
                listOf(
                    Action(4, 6, Color.BLUE),
                    Action(4, 5, Color.RED),
                    Action(3, 6, Color.BLUE),
                    Action(3, 5, Color.RED),
                    Action(1, 3, Color.PINK),
                    Action(1, 6, Color.BLUE),
                    Action(1, 4, Color.LIGHT_GREEN),
                    Action(2, 5, Color.RED),
                    Action(2, 1, Color.ORANGE),
                    Action(2, 5, Color.RED),
                    Action(3, 2, Color.PINK),
                    Action(3, 2, Color.PINK),
                    Action(3, 1, Color.ORANGE),
                    Action(0, 2, Color.PINK),
                    Action(0, 6, Color.BLUE),
                    Action(0, 1, Color.ORANGE),
                    Action(0, 4, Color.LIGHT_GREEN)
                )
            )
    }
}
