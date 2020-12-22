#Kotlin for Java Developers is a Coursera course by Svetlana Isakova and Andrey Breslav

Find here the basics of Kotlin


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

| Modifier | Visible in  | Notes  |
| ------- | --- | --- |
| public | Everywhere |  |
| internal | The module |  |
| protected | Subclasses | In Java also visible in the same package |
| private | The Class |  |
