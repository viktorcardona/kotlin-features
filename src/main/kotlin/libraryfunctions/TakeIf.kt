package libraryfunctions

fun main() {
    val userName = "smith"

    val number = 42
    /**
     *  Returns the receiver object if satisfies the predicate otherwise returns null
     */
    val result = number.takeIf { it > 50 }
    println("number.takeIf: $result")

}