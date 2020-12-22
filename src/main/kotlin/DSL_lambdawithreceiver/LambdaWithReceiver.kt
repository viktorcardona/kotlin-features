package DSL_lambdawithreceiver

/**
 *  Lambda with Receiver:
 *
 *      -   Extension Function & Lambda
 *
 *      -   Lambda with receiver is simply a
 *              lambda with an implicit 'this' inside.
 *              In this sense, it`s similar to an extension function
 *
 *
 *      The with function declaration:
 *
 *          inline fun <T, R> with(receiver: T, block: T.() -> R): R
 *
 *
 *      It is used for building DSL (Domain Specific Languages):
 *      Example:
 *          1. In this example all is kotlin code
 *          html, table, tr and td are all Lambdas with the Receiver
 *          HTML Builder
 *
 *          html {
 *              table {
 *                  for (product in products) {
 *                      tr {
 *                          td { text(product.description) }
 *                          td { text(product.price) }
 *                      }
 *                  }
 *              }
 *          }
 *
 *          2.  Gradle Build Script in Kotlin
 *          plugins and application are lambdas with the Receiver
 *
 *          plugins {
 *              application
 *              kotlin("jvm") version "1.3.10"
 *          }
 *
 *          application {
 *              mainClassName = "com.HelloWorldKt"
 *          }
 */
fun main() {
    println(alphabet())
    println(alphabetImproved())
    println(alphabetImproved2())
    lambdaVsLambdaWithReceiver()
}

fun alphabet(): String {
    val sBuilder = StringBuilder()
    sBuilder.append("Alphabet: ")
    for (c in 'a'..'z') {
        sBuilder.append(c)
    }
    return sBuilder.toString()
}

fun alphabetImproved(): String {
    val sBuilder = StringBuilder()
    with (sBuilder) {
        append("Alphabet: ")
        for (c in 'a'..'z') {
            append(c)
        }
        toString()
    }
    /**
     * This code is the same as above
     * Just to remember:
     *      as a rule if the last parameter of the function is a Lambda
     *          then the lambda can be defined outside the parameters of the method
     *              as it was done in the above code
     */
    with (sBuilder, {
        clear()//clean the builder
        append("Alphabet: ")
        /**
         * This is the Lambda with the Receiver
         * A lambda with  an implicit this
         * In this case this is omitted and it refers to the string builder
         * Therefore, this is the type of the first argument in the library function with
         * Most of the library functions in kotlin seems to be a language construct but yes they are not!
         *
         */
        for (c in 'a'..'z') {
            append(c)
        }
        toString()
    })

    return sBuilder.toString()
}

fun alphabetImproved2(): String = buildString {
    append("Alphabet: ")
    for (c in 'a'..'z') {
        append(c)
    }
}

fun lambdaVsLambdaWithReceiver() {

    fun callingAsRegularFunction() {
        val isEven: (Int) -> Boolean = { it % 2 == 0 }
        isEven(2)
    }

    fun callingAsExtensionFunction() {
        /**this is lambda with the receiver*/
        val isOdd: Int.() -> Boolean = { this % 2 == 1 }
        1.isOdd()
    }


}