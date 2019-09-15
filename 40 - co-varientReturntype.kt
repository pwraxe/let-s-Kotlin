open class Main
{
    val name : String = "Akshay"
    companion object {
        fun show(): Main {
            return Main()
        }
    }
}
class Sub : Main()
{
    val age : Int = 25
   companion object{
       fun dis() : Sub
       {
           return Sub()
       }
   }
}
fun main()
{
    val m = Main.show()
    println("Name : ${m.name}")

    val s = Sub.dis()
    println("Age : ${s.age}")
}

------------------------------ OUTPUT 

Name : Akshay
Age : 25
