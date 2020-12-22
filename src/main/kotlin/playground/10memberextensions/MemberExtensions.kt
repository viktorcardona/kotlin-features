package playground.`10memberextensions`

import operatoroverloading.Point

/**
 * Member extensions
 *
 * Implement member extension functions 'record' and
 * 'unaryPlus' so that the code below compiled and
 * stored specified words.
 *
 * These functions should be unavailable outside of the 'Words' class
 */
class Words {
    private val list = mutableListOf<String>()

    /**
     * Solution: Start
     */
    fun String.record() = list.add(this)
    operator fun String.unaryPlus() = record()
    /**
     * Solution: End
     */

    override fun toString() = list.toString()
}

fun main(args: Array<String>) {
    val words = Words()
    with(words) {
        // The following two lines should compile:
        "one".record()
        +"two"
    }
    val result = words.toString() eq "[one, two]"
    println("words: $words")
    println("Result: $result")
}

private infix fun String.eq(s: String) = this == s
