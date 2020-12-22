package functionalprogramming.lambdas

fun main() {
    //  { parameters     -> body  }
        { x: Int, y: Int -> x + y }

    // if the lambda has only one parameter, it can be reference as "it"
    // When writing code DO NOT use "it" if it has different types in neighbouring lines
    //  Prefer explicit parameter names if it might be confusing otherwise
    // Learn the Library and try to reuse the library functions as much as possible

    lambdaInAVariable()
    callLambdaDirectly()
}

fun lambdaInAVariable() {
   val sum0 = { x:Int, y:Int -> x + y }
   // Function Type
   val sum1: (Int, Int) -> Int = { x:Int, y:Int -> x + y }

   val isEven = {i: Int -> i % 2 == 0}

   println("Is Even(42): ${isEven(44)} ")
}

fun callLambdaDirectly() {
    //such invocation looks a bit strange
    { println("Hello from Lambda called with ()")}()
    //use run instead, since it is more readable
    run{ println("Hello from Lambda called with run")}
}

fun lambdaNullabilityType() {
/**
 *      Return type is nullable:
*       () -> Int?
 *
 *       The variable is nullable:
 *      (() -> Int)?
 *
 *      Examples:
 *
 *      Do not Compile:
 *
 *              val f1: () -> Int? = null
 *              val f2: (() -> Int)? = { null }
 *
 *      Compile:
 *
 *              val f3: () -> Int? = { null }
 *              val f4: (() -> Int)? = null
 *
*/
        val f: (() -> Int)? = null

        // how to call a nullable function?
        // Answer:
        f?.invoke()
}

class Person(val name:String, val age:Int) {
    fun isOlder(ageLimit: Int) = age > ageLimit
}

fun memberReferences() {
    val people = listOf(Person("Bella", 8))
    people.maxByOrNull { it.age }
    people.maxByOrNull(Person::age)
}

fun storeFunctionInAVariableWithFunctionReference() {
    fun isEven(i: Int): Boolean = i % 2 == 0
    val predicate = ::isEven
    // the above line is the same as call a function from a lambda
    val predicate2 = { i:Int -> isEven(i) }
}

fun passingFunctionReferenceAsAnArgument() {
    fun isEven(i: Int): Boolean = i % 2 == 0
    val list = listOf(1,2,3,4,5,6,7,8)
    list.filter(::isEven)
    println(list)
}


fun nonBoundReferenceItIsCallFromAnyInstance() {
    val agePredicate = Person::isOlder //not attached to any specific object
    val agePredicate2: (Person, Int) -> Boolean = Person::isOlder
    val alice = Person("Alice", 29)
    agePredicate(alice, 21) // true
}

fun boundReferenceItIsCallFromSpecificInstance() {
    val alice = Person("Alice", 29)
    val agePredicate = alice::isOlder
    agePredicate(21) // true
}

fun containsZeroReturnsKeywordReturnsFromFunctionNotFromLambda(list: List<Int>): Boolean {
    list.forEach {
        if (it == 0)
        /**
         * remember that the following line returns from the method itself and not from the lambda
         * this is expected but it not as obvious from more complex lambdas
         * Check the following 2 functions to better understand how to deal with return from lambda
         */
        return true
    }
    return false
}

fun duplicateNonZeroReturnFromMethod(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0)
        /**
         * Due to the following return the method will return an empty list if it finds a zero
         *  therefore, the method does not work
         *  to fix this issue take a look to the next function
         */
        return listOf()
        listOf(it, it)
    }
}

fun duplicateNonZeroReturnFromLambda(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0)
        /**
         * This is the way to use return (with labels) in order to make return from the Lambda and not from the function
         * Take a look to the next function which could be better
         */
        return@flatMap listOf<Int>()
        listOf(it, it)
    }
}

fun duplicateNonZeroReturnFromLambdaWithoutUsingLabels(list: List<Int>): List<Int> {
    /**
     * It seems this approach is better than the previous function
     * In this case we do not need to use return with labels
     * Just an inner function
     * Another way to do this is by using an anonymous function, check next function
     */
    fun duplicateNonZeroElement(e: Int): List<Int> {
        if (e == 0) return listOf()
        return listOf(e, e)
    }
    //remember, in Java the method reference is done like:
    //this::methodName
    // in Kotlin is the same but we do not need to use this:
    // ::methodName
    return list.flatMap(::duplicateNonZeroElement)
}

fun duplicateNonZeroReturnFromLambdaByUsingAnonymousFunction(list: List<Int>): List<Int> {
    /**
     * In this case we use an anonymous function in order to be able to use return
     *  from inside the lambda without making this return from the function itself
     */
    return list.flatMap(fun (e): List<Int> {
        if (e == 0) return listOf()
        return listOf(e, e)
    })
}
