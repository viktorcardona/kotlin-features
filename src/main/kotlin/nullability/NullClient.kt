package nullability

fun main() {
    /**
     * Under the hood nullability is handle by annotations in kotlin
     *
     * fun foo(): String = "foo"
     * --------------------------
     *
     *  @NotNull
     *  public static final String foo() {
     *      return "foo";
     *  }
     *
     *
     * fun bar(): String? = "bar"
     * --------------------------
     *
     *  @Nullable
     *  public static final String bar() {
     *      return "bar";
     *  }
     *
     */
    basics()
    elvisOperator(null)
    elvisOperator("a string")
    throwsNPE("some text")
    throwsNPE(null)
    badExampleOfUsingNonNullAssertion()
    betterExampleOfUsingNonNullAssertion(null)
}

fun basics() {
    val s1 = "always not null"
    val s2: String? = null
    println("Length of s1 ${s1.length}")
    // it is not safe it is not valid:
    //  println("Length of s2 ${s2.length}")

    // it is safe:
    val length1: Int? = if (s2 == null) null else s2.length
    val length2: Int = if (s2 == null) 0 else s2.length

    println("Length of s2 ${length1}")
    // it is safe. It is the same as above line
    println("Length of s2 ${s2?.length}")
}

fun elvisOperator(text: String?) {
    //Elvis Operator comes from Groovy
    val length: Int = text?.length?: 0
    println("length: $length")
}

fun throwsNPE(text: String?) {
    // it is not safe it is not valid
    //println(text.length)

    text!! //!! throws NPE if text is null

    // it is safe and it is valid since if it is null this will not be executed!
    println(text.length)
}

fun badExampleOfUsingNonNullAssertion() {
    // person.company!!.address!!.country
    // this is because we do not know which causes the NPE
}

fun betterExampleOfUsingNonNullAssertion(text: String?) {
    // Prefer:
    text?.length
    text?.length?:0
    if (text != null) text.length else 0
    // Instead of:
    text!!
}