package objectorientedprogramming

import kotlin.collections.ArrayList as ArrayList

fun main() {

}

interface MyList<E> {
    fun get(index: Int): E
}

fun method(list: MyList<Int>) {

}

/**
 *      Generic Function
 *
 *      -   Type Parameter: <T>
 */
fun <T> List<T>.filter(predicate: (T) -> Boolean): List<T> {
    val destination = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) {
            destination.add(element)
        }
    }
    return destination
}

fun use1(ints: List<Int>) {
    ints.filter { it > 0 }
}

fun use2(strings: List<String>) {
    strings.filter { it != null }
}

/**
 *      Non-Nullable Upper Bound
 *
 *          -   <T : Any>
 *          -   Then compile error:
 *
 *              foo(listOf(1, null, 3))
 */

fun <T : Any> foo(list: List<T>) {

}
