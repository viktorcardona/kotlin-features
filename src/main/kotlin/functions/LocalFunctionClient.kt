package functions

fun main() {
    println("Result: ${method1()}")
}

fun method1() : Int {
    fun nestedMethod() = 7
    return nestedMethod()
}