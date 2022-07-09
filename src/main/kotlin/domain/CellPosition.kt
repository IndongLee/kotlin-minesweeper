package domain

data class CellPosition(
    val row: Int,
    val column: Int
) {
    fun apply(direction: Direction): CellPosition {
        return CellPosition(
            row = row + direction.diffRow,
            column = column + direction.diffColumn
        )
    }

    fun isInBoundaryOf(minesweeperInfo: MinesweeperInfo): Boolean {
        return row >= FIRST_ROW_INDEX &&
            row < minesweeperInfo.rowCount &&
            column >= FIRST_COLUMN_INDEX &&
            column < minesweeperInfo.columnCount
    }

    companion object {
        private const val FIRST_ROW_INDEX = 0
        private const val FIRST_COLUMN_INDEX = 0

        fun from(index: Int, columnCount: Int): CellPosition {
            val row = index / columnCount
            val column = index % columnCount

            return CellPosition(row, column)
        }
    }
}
