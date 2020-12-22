package sequences

import kotlin.random.Random

/**
 *  Sequences:
 *
 *      When we use collections and perform intermediate operations
 *          a complete new list is created for each intermediate operations
 *
 *      In order to avoid that we use Sequences, which are similar to Streams on Java
 *
 *      With Sequences the operations are performed in a Lazy manner
 *
 *
 */

fun main() {
    //thisMethodCreate3List()
    //thisMethodCreateJust1ListByUsingASequence()

    //generateSequenceExample1()
    //generateInfiniteSequence()
    generateSequenceOf15ElementsInRandom()
    //useOfYieldFunction()
}


fun thisMethodCreate3List() {
    val list = listOf(1, 2, -3)// list 1
    val maxOddSquare = list
            .map { it * it }// list 2: map is call for every element
            .filter { it % 2 == 1 }// list 3: filter is call for every element
            .maxOrNull()
    println("Max Odd Square: $maxOddSquare")
}

fun thisMethodCreateJust1ListByUsingASequence() {
    val sequence = listOf(1, 2, -3).asSequence()
    /**
     * The operations are triggered in a lazy manner when the terminal operation is called
     * map and filter is called only for the first element, then
     * map and filter is called only for the second element, and so forth
     */
    val maxOddSquare = sequence
            .map { it * it }
            .filter { it % 2 == 1 }
            .maxOrNull()
    println("Max Odd Square: $maxOddSquare")
}


fun generateSequenceExample1() {
    generateSequence { Random.nextInt() }

    val seq = generateSequence {
        Random.nextInt(5).takeIf { it > 0 }
    }

    println("Seq.2.List: ${seq.toList()}")
}

fun generateInfiniteSequence() {
    val seq = generateSequence(0) { it + 1}
    println("Infinite: ${seq.take(5).toList()}")
}

fun generateSequenceOf15ElementsInRandom() {
    val list = generateSequence(1) { it + 1}.take(15).shuffled().toList()
    //generateSequence(1) { it + 1}.take(15).shuffled()
    println("My 15 Elements: $list")
}

fun useOfYieldFunction() {
    val numbers = sequence {
        var x = 0
        while (true) {
            yield(x++)
        }
    }

    println("yield: ${numbers.take(5).toList()}")

    /**
     *
     *  Yield is also lazy
     *
     *  We can yield:
     *
     *      sequence {
     *          yield(value)
     *          yieldAll(list)
     *          yieldAll(sequence)
     *      }
     */
}
