package types

/**
 *      Kotlin          Java
 *
 *      Any             Object
 *      Int             int
 *      Int?            Integer
 *      Double          double
 *      Double?         Double
 *      Boolean         boolean
 *      Boolean?        Boolean
 *      List<Int>       List<Integer>
 *      Array<Int>      Integer[]
 *      IntArray        int[]
 *      kotlin.String   java.lang.String
 */
fun main() {
}

fun kotlinAndJavaTypes() {

    /**
     * There is not Primitive Types in Kotlin
     *  But they are used under the hood --in the byte code
     */


    /**
    fun foo(): Int = 1

    Decompiled Java Code:
    --------------------

    public static final int foo() {
        return 1;
    }
     */


    /**
    fun bar(): Int? = 1

    Decompiled Java Code:
    --------------------

    public static final Integer bar() {
        return 1;
    }
     */
}
