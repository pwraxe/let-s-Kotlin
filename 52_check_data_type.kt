fun main() {
    checkMethod1(10)
    checkMethod1("Akshay")
    checkMethod1(true)
    checkMethod1(3.14F)
    checkMethod1(3.145)

    println("----------------------------------------")

    checkMethod2(512)
    checkMethod2("Akshay")
    checkMethod2(true)
    checkMethod2(3.14F)
    checkMethod2(3.145)



}

fun checkMethod2(kuchBhi : Any?){

    when(kuchBhi){
        is Int -> { println("Int : $kuchBhi") }
        is String -> { println("String : $kuchBhi") }
        is Boolean -> { println("Boolean : $kuchBhi") }
        is Float -> { println("Float : $kuchBhi") }
        is Double -> { println("Double : $kuchBhi") }
        else -> { println("else : $kuchBhi") }
    }

}


fun checkMethod1(kuchbhi : Any) {

    if(kuchbhi is Int){ println("Square of $kuchbhi : ${kuchbhi*kuchbhi}") }

    if(kuchbhi is String){ println("This is String : $kuchbhi") }

    if(kuchbhi is Boolean){ println("Boolean : $kuchbhi") }

    if(kuchbhi is Float){ println("Float Val : $kuchbhi") }

    if(kuchbhi is Double){ println("Double : $kuchbhi") }

}

