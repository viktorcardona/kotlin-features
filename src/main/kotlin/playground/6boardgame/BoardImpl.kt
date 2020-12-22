package playground.`6boardgame`

import java.util.stream.Collectors
import java.util.stream.Stream


fun createSquareBoard(width: Int): SquareBoard = BoardImpl(width)

fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl(width)

//import kotlin.streams.toList
fun <T> Stream<T>.toList(): List<T> = collect(Collectors.toList<T>())

class GameBoardImpl<T>(override val width: Int) : SquareBoard by BoardImpl(width), GameBoard<T> {

    private val board: MutableMap<Cell, T?> = mutableMapOf()

    init {
        getAllCells().forEach { cell -> board[cell] = null }
    }

    override fun get(cell: Cell): T? = board[cell]

    override fun set(cell: Cell, value: T?) {
        board[cell] = value
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> = board.entries.stream().filter { predicate(it.value) }.map { it.key }.toList()

    override fun find(predicate: (T?) -> Boolean): Cell? = board.entries.stream().filter { predicate(it.value) }.findFirst().map { it.key }.orElse(null)

    override fun any(predicate: (T?) -> Boolean): Boolean = board.entries.stream().filter { predicate(it.value) }.findFirst().isPresent

    override fun all(predicate: (T?) -> Boolean): Boolean = board.entries.stream().filter { predicate(it.value) }.count().toInt() == width * width

}

open class BoardImpl(override val width: Int) : SquareBoard {

    private val cells = arrayListOf<MutableList<Cell>>()

    init {
        for ( i in 0 until width) {
            val rowListOfCells = mutableListOf<Cell>()
            for ( j in 0 until width) rowListOfCells.add(Cell(i + 1, j + 1))
            cells.add(rowListOfCells)
        }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? = if (isValid(i, j)) cells[getRow(i)][getColumn(j)] else null

    private fun isValid(i: Int, j: Int): Boolean = i in 1..width && j in 1..width

    override fun getCell(i: Int, j: Int): Cell {
        require( isValid(i, j)) {"Incorrect values for getting a cell ($i, $j)"}
        return cells[getRow(i)][getColumn(j)]
    }

    override fun getAllCells(): Collection<Cell> =  cells.toList().stream().flatMap { it.stream() }.toList()

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        val row = cells[getRow(i)]
        val rowCells  = mutableListOf<Cell>()
        for (j in jRange) {
            if (!isValid(i, j)) return rowCells
            rowCells.add(row[getColumn(j)])
        }
        return rowCells
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        val columnCells  = mutableListOf<Cell>()
        val column = getColumn(j)
        for (i in iRange) {
            if (!isValid(i, j)) return columnCells
            columnCells.add(cells[getRow(i)][column])
        }
        return columnCells
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? = when(direction) {
        Direction.UP -> getCellOrNull(i - 1, j)
        Direction.DOWN -> getCellOrNull(i + 1, j)
        Direction.LEFT -> getCellOrNull(i, j - 1)
        Direction.RIGHT -> getCellOrNull(i, j + 1)
    }

    private fun getRow(row: Int) = row - 1
    private fun getColumn(column: Int) = column - 1

}