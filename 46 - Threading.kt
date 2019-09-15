class Main : Thread ()
{
    override fun run()
    {
        for (x in 1..10)
        {
            println("main run")
            try{
                Thread.sleep(1000)
            }catch (e : InterruptedException)
            {
                println(e.message)
            }
        }
    }
}

fun main()
{
    val m = Main()
    m.start()
    for (x in 1..10)
    {
        try {
            println("main()")
            Thread.sleep(1000)
        }catch (e : InterruptedException)
        {
            println(e.message)
        }

    }
}
___________________________________________________________________________________________

class Main : Thread()
{
    override fun run()
    {
        try{
        repeat(10)
        {
            println("Main Class run method")
            //Thread.sleep(1000)
        }
    }catch (ex : InterruptedException){
        ex.printStackTrace()
    }
    }
}
class Sub : Thread()
{
    override fun run() {
        try {
            repeat(10)
            {
                println("Sub Class run method")
                //Thread.sleep(1000)
            }
        }catch (ex : InterruptedException)
        {
            ex.printStackTrace()
        }
    }
}

fun main()
{
    val m : Main = Main()
    val s : Sub = Sub()

    m.start()
    s.start()

    try {
        repeat(10)
        {
            println("main method------")
            //Thread.sleep(1000)
        }
    }catch (ex : InterruptedException)
    {
        ex.printStackTrace()
    }

}
___________________________________________________________________________________________


open class Main  : Thread() {}
class Sub : Main() {}


fun main() {
    val  m = Main()
    println("Parent Class Priority : ${m.priority}")

    m.setPriority(3)
    //m.priority = 3

    val s = Sub()
    println("Child Class Priority is : ${s.priority}")

}

5 
5