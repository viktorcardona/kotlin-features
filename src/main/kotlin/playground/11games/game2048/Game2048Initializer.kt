package playground.`11games`.game2048

import java.util.stream.Collectors
import kotlin.random.Random
import playground.`6boardgame`.Cell
import playground.`6boardgame`.GameBoard

interface Game2048Initializer<T> {
    /*
     * Specifies the cell and the value that should be added to this cell.
     */
    fun nextValue(board: GameBoard<T?>): Pair<Cell, T>?
}

object RandomGame2048Initializer: Game2048Initializer<Int> {
    private fun generateRandomStartValue(): Int =
            if (Random.nextInt(10) == 9) 4 else 2

    /*
     * Generate a random value and a random cell among free cells
     * that given value should be added to.
     * The value should be 2 for 90% cases, and 4 for the rest of the cases.
     * Use the 'generateRandomStartValue' function above.
     * If the board is full return null.
     */
    override fun nextValue(board: GameBoard<Int?>): Pair<Cell, Int>? {
        // TODO Implemented
        if (board.isFull())
            return null
        return Pair(board.getRandomCellWithNullValue(), generateRandomStartValue())
    }
}

fun <T> GameBoard<T>.isFull(): Boolean = all { it != null }

fun <T> GameBoard<T>.nullCells(): List<Cell> = this.getAllCells().stream().filter { get(it) == null }.collect(Collectors.toList())

fun <T> GameBoard<T>.getRandomCellWithNullValue(): Cell {
    val cellsWithNullValues = nullCells()
    return cellsWithNullValues[Random.nextInt(cellsWithNullValues.size)]
}