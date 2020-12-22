package playground.`7inline`

/**
 * Inlining of the 'filter' function
 * Write the code that the Kotlin compiler will generate while
 *  inlining the filter function (instead of calling it).
 *  Note that the compiler generates Java bytecode, but for simplicity,
 *  write the similar code in Kotlin.
 *  The simplified declaration of 'filter' is given below.
 */

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)

    filterNonZero(list).toString() eq "[1, 2, 3]"
    filterNonZeroGenerated(list).toString() eq "[1, 2, 3]"
}

private infix fun String.eq(s: String) = this == s

fun filterNonZero(list: List<Int>) = list.filter { it != 0 }

fun filterNonZeroGenerated(list: List<Int>): List<Int> {
    val destination = ArrayList<Int>()
    for (e in list) {
        if (e != 0) {
            destination.add(e)
        }
    }
    return destination
}

inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
    val destination = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) {
            destination.add(element)
        }
    }
    return destination
}
