package libraryfunctions

/**
 * Also check the package: DSL_lambdawithreceiver
 *
 *
 *                              {   this    }    {   it  }
 *
 *  Return Result of Lambda     with / run          let
 *
 *  Return Receiver             apply               also
 */
fun main() {
    countInsteadOfFilterAndSize()
    sortedByDescendingInsteadOfSortedAndReversed()
    mapNotNullInsteadOfMapAndFilterNotNull()
    mapNotNullInsteadOfFilterNotNullAndMap()
    getOrPutInMap()
    groupingByAndCountByAge()
}

fun countInsteadOfFilterAndSize() {
    getPeople().filter { it.age > 6 }.size
    /**better:*/
    getPeople().count { it.age > 6 }
}


fun sortedByDescendingInsteadOfSortedAndReversed() {
    val result1 = getPeople().sortedBy { it.age }.reversed()
    println("Result1: $result1")

    /**better:*/
    val result2 = getPeople().sortedByDescending { it.age }
    println("Result2: $result2")
}

fun mapNotNullInsteadOfMapAndFilterNotNull() {
    val result1 = getPeople()
            .map { person ->
                person.takeIf { it.isPublicProfile }?.name
            }
            .filterNotNull()

    /**better:*/
    val result2 = getPeople()
            .mapNotNull { person ->
                person.takeIf { it.isPublicProfile }?.name
            }
}

fun mapNotNullInsteadOfFilterNotNullAndMap() {
    getPeople().filterNotNull().map { it.name }
    /**better:*/
    getPeople().map { it?.name }
}

fun getOrPutInMap(){
    val map = mutableMapOf<Int, MutableList<Person>>()

    for (person in getPeople()) {
        if (person.age !in map) {
            map[person.age] = mutableListOf()
        }
        val group = map.getValue(person.age)
        group += person
    }

    /**better:*/
    for (person in getPeople()) {
        val group = map.getOrPut(person.age) { mutableListOf() }
        group += person
    }

    /**Even Better:*/
    val map2 = getPeople().groupBy { it.age }

}

fun groupingByAndCountByAge() {
    val map1 = getPeople().groupBy { it.age }
    //in order to merge in the map the number of people by age just do the following:
    /**better:*/
    val map2 = getPeople()
        .groupingBy { it.age }
            .eachCount()
}

data class Person(val name: String, val age: Int, val isPublicProfile: Boolean)

fun getPeople() = listOf(
        Person("Jhon", 20, true),
        Person("Albert", 76, true)
)

