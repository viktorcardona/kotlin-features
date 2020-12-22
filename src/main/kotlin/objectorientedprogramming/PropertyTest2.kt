package objectorientedprogramming

fun main2() {
    println(lazyValue)
    println(lazyValue)
    println(lazyValue)
}

/**
 *  Lazy Property
 *
 *          by lazy
 *          -------
 *
 */
val lazyValue: String by lazy {
    println("Computed only once!!!")
    "Hello"
}

/**
 *  Lately Initialization
 *
 *          lateinit
 *          --------
 *
 *  class MyClass {
 *      var myData: String? = null
 *
 *      fun aFunction() {
 *          ....
 *          myData = ""//initialization
 *      }
 *
 *      // Now we need to use myData? all time which is not great
 *      // solution is by using lateinit
 *      myData?.length
 *  }
 */
class MyClass {
    lateinit var myData: String
    fun aFunction() {
        this::myData.isInitialized // FALSE
        myData = ""//initialization
        this::myData.isInitialized // TRUE
        myData.length
    }
}


class AA {
    private lateinit var prop: String

    fun setUp() {
        prop = "value"
    }

    fun display() {
        println(prop)
    }
}

fun main(args: Array<String>) {
    val a = AA()
    a.setUp()
    a.display()

}