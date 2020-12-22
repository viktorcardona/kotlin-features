Kotlin for Java Developers is a Coursera course by Svetlana Isakova and Andrey Breslav

EduTools Plugin:
    https://www.jetbrains.com/help/education/install-edutools-plugin.html?section=IntelliJ%20IDEA#72d7

Assignments:
    https://www.jetbrains.com/help/education/coursera-programming-assignments.html#submitting_to_coursera_kotlin_for_java_devs



     ___________________
    |   No Kotlin SDK   |   ------ it is -----> just JDK + extensions 
     -------------------
      |
      |-->  small runtime jar
      |-->  easy Java interoperability


    
    Extensions are static Java functions under the hood
                            ||
                            ||
                            ||
                            \/
        No override for extension functions in Kotlin


OOP

Modifier        Visible in:         Notes
--------        
public          Everywhere
internal        The module
protected       Subclasses        In Java also visible in the same package
private         The Class

