package extensionfunctions

fun main(args: Array<String>) {

    println(listOf('x','y','z').joinToString(separator = ",", prefix = "[", postfix = "]"))
    /*
        Extension Function: joinToString

            fun <T> Iterable<T>.joinToString(
                    separator: CharSequence = ", ",
                    prefix: CharSequence = "",
                    postfix: CharSequence = ""
                    ): String {
                    //.....
            }
    */

    println("Hello, ${args.getOrNull(0)}!")
    /*
        Extension Function: getOrNull

        fun <T> Array<out T>.getOrNull(index: Int) =
            if (index in 0..size) this[index] else null
    */

    // infix fun Int.until(to: Int): IntRange
    // 1.until(10)
    // 1 until 10     // infix
}