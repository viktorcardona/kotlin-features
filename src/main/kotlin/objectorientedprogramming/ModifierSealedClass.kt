package objectorientedprogramming

import java.lang.IllegalArgumentException

/** Class Hierarchy */
interface ExprX
class NumX(val value: Int) : ExprX
class SumX(val left: ExprX, val right: ExprX) : ExprX

fun eval(e: ExprX): Int = when(e) {
    is NumX -> e.value
    is SumX -> eval(e.left) + eval(e.right)
    else -> throw IllegalArgumentException("Unknown Expr: $e") /** Sealed Classes SOLVE this Problem!!!!!!!!!*/
}

fun calculateX() {
    // 1 + (2 + 3)
    val result = eval(SumX(NumX(1), SumX(NumX(2), NumX(3)))) // 6

    println("Result: $result")
}

fun main() {
    /** with interface*/
    calculateX()
    /** with Sealed Class*/
    calculate()
}

/**
 *  Sealed Class
 *
 *      All the class hierarchy must be in the same file
 *
 */
sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()

fun eval(e: Expr): Int = when(e) {
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
}

fun calculate() {
    // 1 + (2 + 3)
    val result = eval(Sum(Num(1), Sum(Num(2), Num(3)))) // 6
    println("Result: $result")
}