package extensionfunctions

import java.lang.StringBuilder

fun main() {
    val name = "James"
    println(name.lastChar())// we need to import the function if we want to use it in a different class
}
// this refers to a String object
fun String.lastChar() = this.get(this.length - 1)

// 'this' can be omitted
fun String.lastCharV2() = get(length - 1)

// When calling this function from Java Client we need to pass 2 arguments:
// StringUtilKT.repeat("xy", 3) // xyxyxy
fun String.repeat(n: Int) : String {
    val sb = StringBuilder(n * length)
    for (i in 1..n) {
        sb.append(this)
    }
    return sb.toString()
}

fun String.isEmptyOrNull() = this == null || isEmpty()