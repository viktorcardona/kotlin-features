package functionalprogramming.collections

import functionalprogramming.collections.GENRE.*

fun main() {
    listToMapByAssociation()
    printGroupWithMaxAgeAfterGroupingByAge()
}

fun listToMapByAssociation() {
    val mapByName = heroes().associateBy { it.name }

    val unknownHero = Hero("Unknown", 0, null)

    val age1 = mapByName.getOrElse("unknown") { unknownHero }.age
    val age2 = mapByName.getOrElse("Lady Lauren") { unknownHero }.age

    println("unknown hero age: $age1")
    println("Lady Lauren hero age: $age2")
}

fun printGroupWithMaxAgeAfterGroupingByAge() {

    // a map where key is age and value is a list of heroes with that age
    val mapByAge: Map<Int, List<Hero>> = heroes().groupBy { it.age }

    // it returns the entry in the map that match the predicate
    // remember that this operator: !!
    //      means that throws NPE if the returned value is null
    //      check the name of the function maxByOrNULL
    //  This is unsafe nullable type (T?) conversion to a non-nullable type (T)
    val (age, group) = mapByAge.maxByOrNull { (_, group) -> group.size }!!

    println("Max Age Group: $age")
}

fun heroes() = listOf(
        Hero("The Captain", 60, MALE),
        Hero("Frenchy", 42, MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, FEMALE),
        Hero("First Mate", 29, MALE),
        Hero("Sir Stephen", 37, MALE))

enum class GENRE {
    MALE, FEMALE
}

data class Hero(val name: String, val age: Int, val genre: GENRE?)