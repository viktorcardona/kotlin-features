package ranges

fun main() {
    println("x is letter ${isLetter('x')}")
    println("* is letter ${isLetter('+')}")
    println("q is isNotDigit ${isNotDigit('q')}")
    println("5 is isNotDigit ${isNotDigit('5')}")
    println("9 is isDigit ${isDigit(9)}")
    println("10 is isDigit ${isDigit(10)}")
    println("8 ${recognize('8')}")
    println("G ${recognize('G')}")
    println("$ ${recognize('$')}")
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(x: Char) = x !in '0'..'9'

fun isDigit(x: Int) = x in 0..9

fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "It is a digit"
    in 'a'..'z', in 'A'..'Z' -> "It is a letter"
    else -> "We do not know"
}