fun main()
{
    val name : String = "Akshay Pawar"
    println("name[0] :  ${name[0]}")
    println("name.plus(\" Hi\")  :  ${name.plus(" Hi")}")
    println("name.get(0)  :  ${name.get(0)}")
    println("name.length  :  ${name.length}")
    println("name.chars() : ")
    var ch = name.chars()
    for (c in ch)
        print("$c ")
    println()
    println("name.compareTo(\"Akshay\")  :  ${name.compareTo("Akshay")}")
    println("name.equals(\"Akshay Pawar\")  :  ${name.equals("Akshay Pawar")}")
    println("name.subSequence(0,8) :  ${name.subSequence(0,8)}")
    println("name.capitalize()  :  ${name.capitalize()}")
    println("name.codePointAt(0)  : ${name.codePointAt(0)}")
    println("name.codePointBefore(1)  : ${name.codePointBefore(1)}")
    println("name.codePointCount(0,name.length)  :  ${name.codePointCount(0,name.length)}")
    println("name.decapitalize()  :  ${name.decapitalize()}")
    println("name.drop(0) :  ${name.drop(0)}")
    println("name.dropLast(2)  : ${name.dropLast(2)}")
    println("name.endsWith(\"r\") : ${name.endsWith("r")}")
    println("name.replace(\"Akshay\", \"Mr.\")  : ${name.replace("Akshay", "Mr.")}")
    println("name.reversed()  : ${name.reversed()}")
    println("name.removeRange(0,3)  : ${name.removeRange(0,3)}")
    println("name.slice(1..3)  : ${name.slice(1..3)}")
    println("name.startsWith(\"P\")  : ${name.startsWith("P")}")
    println("name.substring(0,4)  :  ${name.substring(0,4)}")
    println("name.take(2)  :  ${name.take(2)}")
    println("name.trim()  :  ${name.trim()}")
}

----------------------------------------> Output : 

name[0] :  A
name.plus(" Hi")  :  Akshay Pawar Hi
name.get(0)  :  A
name.length  :  12
name.chars() : 
65 107 115 104 97 121 32 80 97 119 97 114 
name.compareTo("Akshay")  :  6
name.equals("Akshay Pawar")  :  true
name.subSequence(0,8) :  Akshay P
name.capitalize()  :  Akshay Pawar
name.codePointAt(0)  : 65
name.codePointBefore(1)  : 65
name.codePointCount(0,name.length)  :  12
name.decapitalize()  :  akshay Pawar
name.drop(0) :  Akshay Pawar
name.dropLast(2)  : Akshay Paw
name.endsWith("r") : true
name.replace("Akshay", "Mr.")  : Mr. Pawar
name.reversed()  : rawaP yahskA
name.removeRange(0,3)  : hay Pawar
name.slice(1..3)  : ksh
name.startsWith("P")  : false
name.substring(0,4)  :  Aksh
name.take(2)  :  Ak
name.trim()  :  Akshay Pawar