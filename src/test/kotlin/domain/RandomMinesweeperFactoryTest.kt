package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RandomMinesweeperFactoryTest {
    @Test
    fun `RandomMinesweeperFactory는 MinesweeperInfo를 받아 지뢰가 랜덤으로 배치된 지뢰찾기를 만든다`() {
        val minesweeperInfo = MinesweeperInfo(
            rowCount = 10,
            columnCount = 15,
            mineCount = 5
        )
        val minesweeper = RandomMinesweeperFactory.create(minesweeperInfo)

        assertAll(
            { assertThat(minesweeper.size).isEqualTo(minesweeperInfo.rowCount) },
            {
                assertThat(minesweeper).allMatch { row ->
                    row.size == minesweeperInfo.columnCount
                }
            },
            {
                assertThat(minesweeper.flatten()).filteredOn { cell ->
                    cell == Cell.MINE
                }.hasSize(minesweeperInfo.mineCount)
            }
        )
    }
}
