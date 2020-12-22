package collections

fun main() {

    val mutableList = mutableListOf("Java", "Kotlin")
    mutableList.add("JS")

    val present = "Java" in mutableList
    println("Is it present $present")

    val readOnlyList = listOf("JVM")
    // readOnlyList.add("JS") // compilation error

    val list = arrayListOf(1, 7, 9)

    println("list: $list")
    println("list.javaClass: ${list.javaClass}")


}