Case 1 : Higher Order Function, Takes Nothing Return Nothing

fun math(mult : () -> Unit) = mult()

fun gunakar()                      // ------------------> TNRN
{
  println("13 * 13 = ${13*13}")
}

fun main()
{
  math(::gunakar)
}

-----------------------------------------------------------------------------------------
Case 2 : Higher Order Function, Takes Nothing Returns Something

fun math(div : () -> Double) : Double = div()

fun div() =  22.toDouble()/7.toDouble()   // ------------------> TNRS

fun main() 
{
    val div = math(::div)
    println(div)
}

-----------------------------------------------------------------------------------------
Case 3 : Higher Order Function, Takes Something Return Nothing

fun math(num1 : Int, num2 : Int, sub : (Int, Int) -> Unit)
{
    return sub(num1,num2)
}

fun minus(x : Int, y : Int)    //----------------> TSRN
{
    println("Sub : ${x-y}")
}

fun main() 
{
    math(40,60,::minus)
}


-----------------------------------------------------------------------------------------
Case 4 : Higher Order Function, Takes Something Retuen Somethinf

fun math(num1 : Int, num2 : Int, add : (Int, Int) -> Int) : Int
{
    return add(num1,num2)
}
fun plus(a : Int, b : Int) = a+b //----------------------------> TSRS

fun main() 
{
    val add = math(num1 = 12,num2 = 45,::plus)
    println(add)
}
-----------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------
