package libraryfunctions

fun main() {

    /**
     *  run function:
     *
     *      Runs the block of code (Lambda) and
     *          returns the last expression as the result
     *
      */
    val foo = run {
        println("Calculating foo...")
        "foo"
    }

    println("Foo: $foo")

}