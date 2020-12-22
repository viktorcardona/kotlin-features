package operatoroverloading

/**
 *  Kotlin allows overloading a fixed set of known operators!
 */

/**
 *      Arithmetic Operations
 *
 *      Expression      Function Name
 *
 *      a + b           plus
 *      a - b           minus
 *      a * b           times
 *      a / b           div
 *      a % b           mod
 */

/**
 *      Unary Operators
 *
 *      Expression      Function Name
 *
 *      +a              unaryPlus
 *      -a              unaryMinus
 *      !a              not
 *      ++a, a++        inc
 *      --a, a--        dec
 *
 */

fun main() {
    val point1 = Point(2, 5)
    val point2 = Point(7, 9)
    val point3 = point1 + point2/** Operator!!! */
    println("$point1 + $point2 = $point3")

    println("${point3.unaryMinus()}")

    val list = listOf(1, 2, 3)
    val newList = list + 4/** Operator!!! */
    println("newList: $newList")

    val mutableList = mutableListOf(7, 8, 9)
    mutableList += 0/** Operator!!! */
    println("mutableList: $mutableList")
}

class Point(val x: Int, val y: Int) {

    operator fun plus(other: Point) = Point(x + other.x, y + other.y)

    operator fun unaryMinus() = Point(-x, -y)

    override fun toString() = "($x, $y)"
}


