package objectorientedprogramming

import objectorientedprogramming.Color.*

/**
 *  enum is a modifier of the class
 */
enum class Color {
    BLUE, ORANGE, RED
}
fun getDescription(color: Color) =
        when (color) {
            BLUE -> "cold"
            ORANGE -> "mild"
            RED -> "hot"
        }

/**
 *  enum class with properties
 */
enum class Color2(val r: Int, val g: Int, val b: Int) {
    BLUE(0, 0, 255),
    ORANGE(255, 165, 0),
    RED(255, 0, 0);

    fun rgb() = (r * 256 + g) * 256 + b

}


