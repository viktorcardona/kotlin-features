package objectorientedprogramming


interface Base1

class Base1Impl: Base1

/**
 * By default classes are final
 * It needs to be marked with open to allow subclasses
 */
open class Parent1(val name: String)

class Child1(name: String): Parent1(name)

/**
 *  Call constructor of the parent class
 */
class Child2: Parent1 {
    constructor(name: String, age: Int): super(name)
}
