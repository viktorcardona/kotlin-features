package objectorientedprogramming

/**
 *  Inner Modifier
 *
 *      Adds a Reference to the Outer Class!
 *
 */

class AAA {

    val name = "A Name for Class AAA"

    class BBB

    inner class CCC {
        fun m() {
            /** Here the Reference to the Outer Class!! */
            this@AAA.name
        }
    }

}