package objectorientedprogramming

val set1 = setOf(1,2,3)
val set2 = setOf(1,2,3)

/**
 *
 *  ==
 *  Under the hood it is calling equals() method
 */
val areEqualContent = set1 == set2


/**
 *  ===
 *  This compares the references
 */
val areEqualReferences = set1 === set2

