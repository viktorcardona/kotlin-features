package ifelse

import switch.Color

fun main() {

    val a = 7
    val b = 3
    val max = if (a > b) a else b // if is an expression // There is not ternary operator like in Java
    print("max: $max")

    updateWeather(4)
    updateWeather(38)
}



fun updateWeather(degrees: Int) {
    /*
    Java:

    String description
    Color color
    if (degrees < 5) {
        description = "cold"
        color = BLUE
    }
    */
    val(description, color) = when { // no argument in the when
        degrees < 5 -> "cold" to Color.BLUE // uses boolean expression degrees < 5
        degrees < 23 -> "mild" to Color.ORANGE
        else -> "hot" to Color.RED
    }
    println("weather: $description amd $color !!!!!")
}

