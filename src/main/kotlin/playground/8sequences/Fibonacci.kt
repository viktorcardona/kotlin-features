package playground.`8sequences`

/**
 * Fibonacci sequence
 *      Implement the function that builds a sequence of Fibonacci numbers
 *          using 'sequence' function. Use 'yield'.
 *
 */
fun main(args: Array<String>) {
    fibonacci().take(4).toList().toString() eq
            "[0, 1, 1, 2]"

    fibonacci().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}

private infix fun String.eq(s: String): Boolean {
    println("$this :isEqual?: $s")
    return this == s
}


fun fibonacciFirstTry(): Sequence<Int> = sequence {
    fun fibonacci(value: Int): Int {
        if (value == 0)
            return 0
        if (value == 1)
            return 1
        return fibonacci(value - 1) + fibonacci(value - 2)
    }
    var number = 0
    while (true) {
        yield(fibonacci(number++))
    }
}

fun fibonacci(): Sequence<Int> = sequence {
    var elements = Pair(0, 1)
    while (true) {
        yield(elements.first)
        elements = Pair(elements.second, elements.first + elements.second)
    }
}