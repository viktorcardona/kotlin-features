package objectorientedprogramming


/**
 * Default Constructor
 */

class A1

val a = A1()


/**
 * Concise Primary Constructor
 */

class Person1(val name: String, val age: Int)

val person1 = Person1("Oscar", 16)

/**
 *  name: String without val/var becomes just a constructor parameter
 *  With val or var a property is created automatically
 */
class Person2(name: String) {
    val name: String // property declaration

    /**
     * Constructor body
     */
    init {
        this.name = name
    }
}

/**
 *  Changing the Visibility of a Constructor
 */

class InternalComponent internal constructor(name: String) {
}


/**
 *  Primary Constructor
 */
class Rectangle1(val height: Int, val width: Int) {

    /**
     *  Secondary Constructor
     */
    constructor(side: Int) : this(side, side) {
    }

}