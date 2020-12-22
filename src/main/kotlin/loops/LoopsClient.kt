package loops

fun main() {
    iteratingList()
    iteratingListWithIndex()
    iteratingMap()
    iteratingString()
}

fun iteratingList() {
    println("iterating List")
    val list = listOf("x", "y", "z")
    for (s in list)
        println("value: $s")
}

fun iteratingListWithIndex() {
    println("iterating List With Index")
    val list = listOf("x", "y", "z")
    for ((index, element) in list.withIndex())
        println("$index -> $element")
}


fun iteratingMap() {
    println("iterating Map")

    val map = mapOf(1 to "een",
                    2 to "twee",
                    3 to "dri")

    for ((k,v) in map) {
        println("$k = $v")
    }
}

fun iteratingString() {
    println("Iterating String")
    for (ch in "abc")
        print(ch + 1)
}
