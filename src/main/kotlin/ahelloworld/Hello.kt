package ahelloworld

fun main(args: Array<String>) {
    val name = if (args.isNotEmpty()) args[0] else "World"
    println("Hello, $name!")
    println("fruit.1: ${fruit()}, fruit.2: ${fruit()} ")
}

fun fruit() : String {
    println("In fruit func")
    return "Orange"
}
