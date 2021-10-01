fun main() {
    myBio()
    myBio("ASP")
    myBio("AxeSP","anand@pinnacle.in")
    myBio("A S P","anand.codexdroid@gmail.com",8888888888)

}
fun myBio(name : String = "Alex",email : String = "alex@gmail.com", mobile : Long = 9999999999){
    println("Name : $name \nEmail : $email \nMobile : $mobile\n")
}
_____________________________________________________________________________________________________
output : 
Name : Alex 
Email : alex@gmail.com 
Mobile : 9999999999

Name : ASP 
Email : alex@gmail.com 
Mobile : 9999999999

Name : AxeSP 
Email : anand@pinnacle.in 
Mobile : 9999999999

Name : A S P 
Email : anand.codexdroid@gmail.com 
Mobile : 8888888888


_____________________________________________________________________________________________________

// function inside the function

fun main() {
    fun show(){
        println("fun in fun")
    }
    println("fun")
    show()
}
----------------------------------------------------------------------------------------------------

class Main {

    fun show(num: Int) {
        println("HE : $num")
        fun getNum(): Int = 1432
        println("SHE : ${getNum()}")
    }
}

fun main() = Main().show(143)
