package functions

fun main() {
    println("Result: ${maxV3(7, 3)}")
}

fun maxV1(a: Int, b: Int) : Int {
    return if (a > b) a else b
}

fun maxV2(a: Int, b: Int) : Int = if (a > b) a else b

fun maxV3(a: Int, b: Int) = if (a > b) a else b

// Function Returning Unit (like void in Java)
fun displayMaxV1(a: Int, b: Int) : Unit {
    println(maxV3(a, b))
}

fun displayMaxV2(a: Int, b: Int) {
    println(maxV3(a, b))
}