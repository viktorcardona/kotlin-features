package functionalprogramming.collections

/**
 * Common Operations:
 *
 *  first       // first element or throws an NoSuchElementException
 *  last        //
 *  firstOrNull //
 *  lastOrNull  //
 *  filter      // receives a predicate
 *  map         // transforms the element
 *  any | all | none    // this operations receive a predicate
 *  find        // returns the first element which meets the predicate, if there is not element then it returns null
 *  first       // returns the first element otherwise throws an exception
 *  firstOrNull // the same as find operation
 *  count       // returns the number of elements that satisfied the predicate
 *  partition   // divides the collection into 2 collections based on a predicate. val employees = listOf(..) val (youngest, oldest) = employees.partition { it.age < 30 }
 *  groupBy     // divides the collection into n collections based on a key - Map<K, List<T>>
 *  associateBy // returns a Map containing the elements from the given collection indexed by the key - Map<K, T>. If any two elements would have the same key returned by keySelector the last one gets added to the map.
 *  associate   // Returns a Map containing key-value pairs provided by transform function applied to elements of the given collection. If any of two pairs would have the same key the last one gets added to the map.
 *  zip         // receives 2 list and returns a list where each element is a pair with elements of both list
 *  zipWithNext // Returns a list of pairs of each two adjacent elements in this collection.
 *  flatten     // combines all the list into a single list of elements
 *  flatMap     // combines the map (one element becomes a list) and the flatten operations
 */
fun main() {
    printAverageEmployeeAge()
}

data class Employee(val city: String, val age: Int)

fun printAverageEmployeeAge() {
    val employees = retrieveEmployees()
    println("Average Employee Age: ${calculateAvgEmployeeAge(employees)}")
}

fun calculateAvgEmployeeAge(employees: List<Employee>) =
    employees.filter { it.city == "Bogota" }
        .map { it.age }
        .average()

fun retrieveEmployees() = listOf(
        Employee("Bogota", 30),
        Employee("Paris", 87),
        Employee("London", 72),
        Employee("Bogota", 25))