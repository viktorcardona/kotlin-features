package namedarguments

fun main() {
    println(listOf('x','y','z').joinToString(separator = ",", prefix = "[", postfix = "]"))

    println(listOf('x','y','z').joinToString(postfix = "."))// default separator is comma
}