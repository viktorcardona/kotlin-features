package ranges

fun main() {

    val intRange: IntRange = 1..9

    val intRange2: IntRange = 1 until 10

    val charRange: CharRange = 'a'..'b'

    val stringRange: ClosedRange<String> = "ab".."az"


    println("contains(ax) ${stringRange.contains("ax")}")

    // Comparing Strings: Strings are compare lexicographically
    // "ball"                    in        "a".."k"
    // "a" <= "ball"             &&   "ball" <= "k"
    //"a".compareTo("ball") <= 0 &&   "ball".compareTo("k")  <= 0

    println(("al" in "a".."k"))
}