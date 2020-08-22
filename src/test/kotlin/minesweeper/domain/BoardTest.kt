package minesweeper.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class BoardTest {
    @Test
    fun find_point() {
        val board = Board(10, 10)

        val point = board.findPoint(2, 3)

        assertThat(point.coordinate).isEqualTo(Coordinate(2, 3))
    }

    @Test
    fun find_error() {
        val board = Board(10, 10)

        assertThatThrownBy {
            board.findPoint(10, 10)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("10, 10 좌표는 없습니다.")
    }

    @Test
    fun count_mines() {
        val board = Board(10, 10, 10)

        val mineCount = board.countMine()

        assertThat(mineCount).isEqualTo(10)
    }
}