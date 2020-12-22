package exceptions

import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

// No Difference Between Checked and UnChecked Exceptions
fun main() {

}

fun throwIsAnExpression(number: Number) {
    val percentaje =
            if (number in 0..100) number
            else throw IllegalArgumentException("A percentaje value must be between 0 and 100: $number")
}

fun tryIsAnExpression(numberText: String) {
    val number = try {
        Integer.parseInt(numberText)
    } catch (e: NumberFormatException) {
        null
    }
}

//from Java Client is not required to catch Exception.
fun isNotNeededToThrowsExceptionAtMethodLevel() {
    var flag = true
    if (flag) throw Exception("An Exception")
}

//from Java Client is Mandatory to catch Exception.
@Throws(Exception::class)
fun makeJavaClientMandatoryToCatchException() {
    var flag = true
    if (flag) throw Exception("An Exception")
}
