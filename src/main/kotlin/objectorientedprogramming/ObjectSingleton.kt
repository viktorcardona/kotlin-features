package objectorientedprogramming

object Singleton {
    fun name() = "I am a singleton in Kotlin"
}

/**
 * The Java Generated Code is:
 *
 * class Singleton {
 *
 *      public static final Singleton INSTANCE = new Singleton();
 *
 *      private Singleton(){}
 * }
 *
 */


fun main() {
    val singleton = Singleton
    println("Name: ${singleton.name()}")
}