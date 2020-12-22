package playground.`1function`

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}

// Implement the function that checks whether a string is a valid identifier.
// A valid identifier is a non-empty string that
// starts with a letter or underscore and
// consists of only letters, digits and underscores
fun isValidIdentifier(s: String) =
        s.isNotEmpty() &&
        (isUnderscore(s[0]) || isLetter(s[0])) &&
        isValid(s)

fun isValid(s: String): Boolean  {
    var isValid = true
    for (c in s) {
        if (!isLetter(c) && !isDigit(c) && !isUnderscore(c))
            isValid = false
    }
    return isValid
}

fun isUnderscore(c: Char) = c == '_'

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isDigit(c: Char) = c in '0'..'9'
