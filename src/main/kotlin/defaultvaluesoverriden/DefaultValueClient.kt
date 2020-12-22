package defaultvaluesoverriden

fun main() {

    // Default Values in Arguments
    //  Also overloading in Kotlin compare to Java is simpler

    displaySeparator() // if we call this function from Java we need to pass all arguments

    displaySeparator('#', 3)

    //displaySeparator(4) // not compile
    displaySeparator(size = 4)

    //displaySeparator(3, '5')// not compile
    displaySeparator(size = 3, character = '5')
}

fun displaySeparator(character: Char = '*', size: Int = 2) {
    repeat(size) {
        println(character)
    }
}

//how many argument combinations are possible?
// sum()
// sum(a = 1, b = 2)
// sum(c = 3)
// ...
// The answer is 2 ^ 3 = 8
//  where 3 is the number of arguments in the function
//
fun sum(a: Int = 0, b: Int = 0, c: Int = 0) {

}

// we can use the annotation:
// @JvmOverloads
// which allows to generate 4 overloaded functions from above function in order to be used from Java code
//  public static final int sum(int a, int b, int c)
//  public static final int sum(int a, int b)
//  public static final int sum(int a)
//  public static final int sum()

