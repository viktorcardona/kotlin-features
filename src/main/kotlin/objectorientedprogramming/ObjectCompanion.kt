package objectorientedprogramming

/**
 *      Companion Object:
 *
 *          Special object inside a class
 *
 *          In Kotlin there are not static methods like in Java!
 *
 *          A companion object might be a replacement for that
 *
 *          A companion Object can implement an interface
 *
 *          A companion object can be a receiver of extension function
 *
 *          There is not static keyword in Kotlin
 *
 *
 */

class CompanionObject {

    companion object {
        fun name() = "Name of Companion Object"
    }
}

fun main() {
    println("It is like a static method in Java: ${CompanionObject.name()} ")
    println(CompanionObject.name2())
}

fun CompanionObject.Companion.name2() = "This is an Extension Function from Companion Object"