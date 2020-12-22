package objectorientedprogramming

/**
 *      Data modifier generates useful methods:
 *
 *      -   equals
 *      -   hashCode
 *      -   copy
 *      -   toString
 *
 */

data class Contact(val name: String, val address: String)

val contact1 = Contact("Isa", "155")

/**
 * Copy the instance contact1
 */
val contact2 = contact1.copy()

/**
 * Copy the instance contact1 overwritten the address field value
 */
val contact3 = contact1.copy(address = "New Home")

/**
 *  In order to exclude a field from the generated methods
 *      declare the field outside the constructor
 */

data class User(val email: String) {
    var nickname: String? = null
}

fun main() {
    val email = "mail@gmail.com"
    val user1 = User(email)
    user1.nickname = "Nick-01"
    println(user1)

    val user2 = User(email)
    user1.nickname = "Some Nickname"
    println(user1 == user2) // true!
}
