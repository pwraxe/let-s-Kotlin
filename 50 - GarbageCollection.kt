/*
Garbage Creates in 4 way
	1 : By assigning null value
	2 : By Crating object in other method
	3 : By Assigning Other object to same reference  (! work in kotlin)
	4 : By island of isolation
*/

class Main
{
    var i : Int? = 10
}
class Sub
{
    var i : Int? = 11
}
class Other
{
    var i : Int? = 12
}

fun main() {
    var m1 : Main?= Main()
    m1 = null               // 1. creates garbage
    show()
    println("x")
    println("y")
    println("z")

    //var m3 = Main()             // not Works becoz, Type mismatch here  but in java it 3. creates Garbage
    //m3 = Sub()

    var m : Main? = Main()
    var s :Sub? = Sub()
    var o : Other? = Other()

    m?.i = s?.i
    s?.i = o?.i
    o?.i = m?.i

    m = null; s = null ; o = null   // 4. Creates Garbage by island of isolation

}
fun show()
{
    var m2 : Main? = Main()
    println("show")
}                   // 2. Creates Garbage
_____________________________________________________________________________________________

class Main
{
    var i = 1000    
}

fun main() {
    var m : Main? = Main()
    // System.gc()
    // var r = Runtime.getRuntime().gc()
}
