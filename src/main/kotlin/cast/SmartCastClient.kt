package cast

fun main(args: Array<String>) {

    val s = if (args == null) null else ""

    val x: Any = getAny()

    // compilation error
    // x.toUpperCase()

    if (x is String) { // smart cast
        x.toUpperCase()
    }

    safeCastAs(x)
}

fun getAny(): Any {
    return "Any()"
}

fun safeCastExample() {
    val s = "abc"
    println( s as? Int)// prints null
    println( s as Int?)// throws exception
}

fun safeCastAs(x: Any) {
    val upper1 = (x as? String)?.toUpperCase()
    println("safeCastAs.Upper1: $upper1")

    val upper2 = x as? String
    println("safeCastAs.Upper2: ${upper2?.toUpperCase()}")
}
