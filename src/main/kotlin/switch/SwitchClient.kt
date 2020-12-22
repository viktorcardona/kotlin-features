package switch

import switch.Color.*

fun main() {
    println("Color description: ${getDescription(RED)}")
    println("yes: ${reply("y")}")
    println("Color mixing: ${mix(BLUE, YELLOW)}")
    // println("Color mixing: ${mix(YELLOW, ORANGE)}")
    println("Check Pet Type: ${checkPetType(Cat())}")
    println("Check Favorite Pet Type: ${checkFavoritePetType()}")
    updateWeather(4)
    updateWeather(20)
}

fun getDescription(color: Color) = when (color) {
    BLUE -> "cold" // break is not needed like in Java
    ORANGE -> "mild"
    //Color.RED -> "hot"
    else -> "hot"
}

fun mix(color1: Color, color2: Color) = when (setOf(color1, color2)) {
    setOf(RED, YELLOW) -> ORANGE
    setOf(YELLOW, BLUE) -> GREEN
    setOf(BLUE, VIOLET) -> INDIGO
    else -> throw Exception("Dirty Color $color1 mix with $color2")
}

enum class Color {
    ORANGE, BLUE, RED, YELLOW, GREEN, VIOLET, INDIGO
}

fun reply(input: String) = when (input) {
    "y", "yes" -> "I am glad you agree"
    "n", "no" -> "Sorry to hear that"
    else -> "I do not understand you"
}


open class Pet

class Cat : Pet() {
    fun meow() = "meow"
}

class Dog : Pet() {
    fun woof() = "woof"
}

fun checkPetType(pet: Pet) = when(pet) {
    is Cat -> pet.meow()  // is => instanceOf in Java and yay Smart Cast -> it is not needed to cast!!!
    is Dog -> pet.woof()
    else -> throw Exception("Unknown Pet")
}

fun checkFavoritePetType() = when(val pet = favoritePet()) {
    is Cat -> pet.meow()
    is Dog -> pet.woof()
    else -> "uhm"
}

fun favoritePet(): Pet = Dog()


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
        degrees < 5 -> "cold" to BLUE // uses boolean expression degrees < 5
        degrees < 23 -> "mild" to ORANGE
        else -> "hot" to RED
    }
    println("weather: $description amd $color !!!!!")
}
