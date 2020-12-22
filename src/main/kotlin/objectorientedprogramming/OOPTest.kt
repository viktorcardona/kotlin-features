package objectorientedprogramming

open class A( val value: String) {
    init {
        value.length
        println("A().value.... $value ")
        println("A().this.value.... ${this.value} ")
    }
}

class B(value: String) : A(value)

fun main(args: Array<String>) {
    val b = B("a")
    println("b.value..... ${b.value} ")
}

