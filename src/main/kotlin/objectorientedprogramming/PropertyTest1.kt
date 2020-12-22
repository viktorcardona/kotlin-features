package objectorientedprogramming

import java.lang.StringBuilder

/**
 *  Kotlin
 *
 *  We do not call getter and setters
 *  We access properties like they were public variables
 *  The getter and the setter are called under the hood
 *
 */

fun main() {
    StateLogger().state = true

    // compilation error since setCounter is private
    // LengthCounter().counter = 7

    // The values should be different:
    println(foo)
    println(foo)
    println(foo)

    /**
     *  Extension Properties
     */
    val abc = "abc"
    println("abc.lastIndex: ${abc.lastIndex}")
    println("abc.indices: ${abc.indices}")

    /**
     *  Mutable Extension Properties
     */
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}

/**
 * name: only getName
 * address: getAddress and setAddress
 */
class Contact1(val name: String, var address: String)

/**
 *  field refers to state variable!
 *          only possible inside accessors
 */
class StateLogger {
    var state = false
    set(value) {
        println("state. has changed: $field to $value")
        field = value
    }
}

/**
 *  Changing the visibility of a Setter
 */
class LengthCounter {
    var counter: Int = 0
        private set
}

var factor = 0

/**
 * you can do whatever you want inside the corresponding getter for 'val’.
 */
val foo: Int
    get() =  factor++

/**
 *  Extension Properties
 *  val: Immutable
 */

val String.lastIndex: Int
        get() = this.length - 1

val String.indices: IntRange
    get() = 0..lastIndex

/**
 *  Mutable Extension Property
 *  var
 */

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        setCharAt(length - 1, value)
    }

