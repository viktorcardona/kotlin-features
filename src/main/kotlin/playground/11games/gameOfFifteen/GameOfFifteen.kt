package playground.`11games`.gameOfFifteen

import playground.`6boardgame`.*
import playground.`11games`.game.Game

import playground.`6boardgame`.Cell
import playground.`6boardgame`.Direction
import playground.`6boardgame`.Direction.*

/*
 * Implement the Game of Fifteen (https://en.wikipedia.org/wiki/15_puzzle).
 * When you finish, you can play the game by executing 'PlayGameOfFifteen'.
 */
fun newGameOfFifteen(initializer: GameOfFifteenInitializer = RandomGameInitializer()): Game =
        GameOfFifteen(initializer)

class GameOfFifteen(private val initializer: GameOfFifteenInitializer) : Game {

    private val board = createGameBoard<Int?>(4)

    override fun initialize() {
        val values = initializer.initialPermutation
        for ((index, cell) in board.getAllCells().withIndex()) {
            if (index < values.size)
                board[cell] = values[index]
        }
    }

    override fun canMove() = board.any { it == null }

    override fun hasWon() = board.getAllCells().stream().map { board[it] }.filter { it != null }.toList() == (1..15).toList()


    private fun <T> GameBoard<T>.theEmptyCell(): Cell = getAllCells().stream().filter { board[it] == null}.findFirst().get()
    private fun Cell.getNeighbour(direction: Direction): Cell? = when(direction) {
        DOWN -> board.getCellOrNull(i - 1, j)
        UP -> board.getCellOrNull(i + 1, j)
        RIGHT -> board.getCellOrNull(i, j - 1)
        LEFT -> board.getCellOrNull(i, j + 1)
    }
    override fun processMove(direction: Direction) {

        val theEmptyCell = board.theEmptyCell()
        val neighborCell = theEmptyCell.getNeighbour(direction)

        neighborCell?.let {
            board[theEmptyCell] = board[neighborCell]
            board[neighborCell] = null
        }

    }

    override fun get(i: Int, j: Int): Int? = board.run { get(getCell(i, j)) }
}

