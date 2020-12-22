package destructuringdeclarations

/**
 * Take a look to loops package in this project for more examples of destructuring declarations
 */
fun main() {

    val contact1 = Contact("Martin", "martin@martin.com", "1234567")
    println("contact: $contact1")

    val (name, _, phone) = contact1
    println("Name: $name and phone: $phone")

    val pair1 = Pair(3,5)
    println("pair1: $pair1")

    val (first, second) = Pair(7,9)
    println("pair2: $first, $second")

    val board = Board("Super Chess!")


    board[1, 2] = "Horse"
    /**
     * The above line is replace under the hood with:
     * board.set(1, 2, "Horse")
     */

}

data class Contact(val name: String, val email: String, val phoneNumber: String)

class Board(val name: String)

operator fun Board.set(x: Int, y: Int, piece: String) {
    println("name: $name x: $x, y: $y, piece: $piece")
}
