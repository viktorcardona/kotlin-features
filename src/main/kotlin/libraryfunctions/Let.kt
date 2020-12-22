package libraryfunctions

fun main() {
    val email = getEmail()

    //email can be null so we MUST first check is not null
    if (email != null) {
        sendToEmailTo(email)
    }

    /** However, we can also use let function:
     *      The sendToEmailTo function is call ONLY if email is not null!
     *
     *  */
    email?.let { e -> sendToEmailTo(e)}
    email?.let { sendToEmailTo(it)}



}

fun getEmail(): String? = null

fun sendToEmailTo(email: String) {
    println("Send an email to: $email")
}