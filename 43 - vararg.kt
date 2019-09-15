fun main(vararg args : String)
{
    println("Vararg Hello World")

}
_____________________________________________________

fun main()
{
    var nums = intArrayOf(1,5,8,7,4,3,6,9,2)
    displayArray(*nums)
}
fun displayArray(vararg nums : Int)
{
    for (n in nums)
        println(n)
}
_____________________________________________________

fun main()
{
    show("ping","netstate","mkdir","rmdir","flush")
}
fun show(vararg cmd  : String)
{
    // println(cmd.toList())    //  [ping, netstate, mkdir, rmdir, flush]
    // println(cmd.size)        //  5
    // println(cmd.sorted())    //  [flush, mkdir, netstate, ping, rmdir]
    // println(cmd.indices)     // 0..4
    // println(cmd.filter { it.endsWith("r",true) })   // [mkdir, rmdir]
    
}

_____________________________________________________

fun main() {
    val arr = arrayOf(1,2,3,6,5,4,7,8,9)
    getArray(arr)
}
fun getArray(vararg arr: Array<Int>)
{
    for (a in arr)
        println(a)
}
-------------------------------------------------

fun main() {
    val arr = listOf(1,2,3,6,5,4,7,8,9)
    getArray(arr)
}
fun getArray(vararg arr: List<Int>)
{
    for (a in arr)
        println(a)
}