package playground.`1function`

fun main(args: Array<String>) {
    println("name: " + isValidIdentifier2("name"))   // true
    println("_name: " + isValidIdentifier2("_name"))  // true
    println("_12: " + isValidIdentifier2("_12"))    // true
    println("(empty): "+ isValidIdentifier2(""))       // false
    println("012: " + isValidIdentifier2("012"))    // false
    println("no$: " + isValidIdentifier2("no$"))    // false
}

fun isValidIdentifier2(s: String) : Boolean {
    fun isValidCharacter(ch: Char) = ch == '_' || ch.isLetterOrDigit()

    if (s.isEmpty() || s[0].isDigit()) return false

    for (ch in s) {
        if (!isValidCharacter(ch)) return false
    }
    return true
}