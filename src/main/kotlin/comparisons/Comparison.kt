package comparisons

fun main() {

    val isLess = "abc" < "def"

    println("is abc < def: $isLess ")

    val a = 7
    val b = 9

    val result1 = a >= b
    val result2 = a.compareTo(b) >= 0

    println("result1 is equal to result2")



}

