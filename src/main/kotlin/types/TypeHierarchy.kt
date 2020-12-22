package types

/**
 *               (super type)
 *                  -----
 *                   Any
 *                  -----
 *
 *              ---         ----
 *              Int         User
 *              ---         ----
 *
 *                  -------
 *                  Nothing
 *                  -------
 *              (super button Type)
 *
 */


/**
 *
 *      Kotlin                      Java
 *      Unit vs Nothing             void
 *
 *
 *      -   In Kotlin Unit is used instead of void
 *          -   This methods are equivalent:
 *
 *              fun() {...}
 *              fun(): Unit {...}
 *
 *
 *
 *
 *      -   Unit vs Nothing
 *
 *          -   Unit:
 *                  -   the function completes successfully: one value
 *                  -   func ask() {
 *                          println("Alles goed?")
 *                      }
 *                  -   Unit is replaced by void at ByteCode level
 *
 *          -   Nothing:
 *                  -   the function never completes: no values
 *                  -   func answer() {
 *                          throw Exception("Not really")
 *                      }
 *                  -   Nothing is replaced by void at ByteCode level
 *                  -   Expressions with Nothing Type:
 *                      -   throw IllegalStateException()
 *                      -   return
 *                      -   TODO("Needs to be done")
 *                      -   null // this is the simplest Nothing - make sense - null is super sub type of hierarchy
 *
 */
fun main() {

}