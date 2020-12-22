package ranges

fun main() {
    iteratingRange()
}

fun iteratingRange() {
    println("Ranges Inclusive")

    for (index in -3..3)
        print(index)

    println()
    println("Ranges Exclusive")

    for (index in -3 until 3)
        print(index)

    println()
    println("Ranges with Step")

    for (index in 7 downTo 1 step 2)
        print(index)

}
