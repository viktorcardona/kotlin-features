package libraryfunctions

fun main() {
    /**
     *  TakeUnless function:
     *
     *      returns the object if it does not satisfy the given predicate
     *          otherwise returns null
     */
    val name: String? = "User"

    val result = name.takeUnless { it.equals("Smith") }

    println("Result: $result")

}