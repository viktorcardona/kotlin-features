package playground.`11games`.gameOfFifteen

/*
 * This function should return the parity of the permutation.
 * true - the permutation is even
 * false - the permutation is odd
 * https://en.wikipedia.org/wiki/Parity_of_a_permutation

 * If the game of fifteen is started with the wrong parity, you can't get the correct result
 *   (numbers sorted in the right order, empty cell at last).
 * Thus the initial permutation should be correct.
 *
 */
fun isEven(permutation: List<Int>): Boolean {
    // TODO Implemented with the algorithm:
    // TODO: https://math.stackexchange.com/questions/1170611/parity-of-permutation-example
    val numberOfInversions = { element: Int, subList: List<Int> -> subList.count { element > it } }
    var counter = 0
    for ((index, element) in permutation.withIndex()) {
        val subList = permutation.subList(index + 1, permutation.size)
        counter += numberOfInversions(element, subList)
    }
    return counter % 2 == 0
}

