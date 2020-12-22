package functions

fun main() {
    val a = A()
    println("Result: ${a.method()}")
}

class A() {
    fun method() = 2
}