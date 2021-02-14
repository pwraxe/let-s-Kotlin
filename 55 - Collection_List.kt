fun main() {
    val listInt = listOf<Int>(1,2,3,4,5,6)
    val listString = listOf("A","B","C","D","E","F","G","C")
    val list_notNull = listOfNotNull("a",4,5,null,null,"aa")
    val listEmpty = emptyList<Int>()
    val list_arrayList = arrayListOf<Int>()
    val list_arr_ = arrayListOf("a","b")
    val list_mutable = mutableListOf<Int>()
    val list_mutable_filled = mutableListOf("Aa","Bb")

    println(listInt)             // [1, 2, 3, 4, 5, 6]
    println(listString)          // [A, B, C, D, E, F, G, C]
    println(list_notNull)        // [a, 4, 5, aa]
    println(listEmpty)           // []
    println(list_arrayList)      // []
    println(list_arr_)           // [a, b]
    println(list_mutable)        // []
    println(list_mutable_filled) // [Aa, Bb]
}
________________________________________________________________________________________________________

fun main() {

    val state = arrayOf("MH","MH","GJ","RJ","DL","DL","HP","J&K","DD","SK","AP","TN","TS","KL","KK","MP")

    val al = object : AbstractList<String>(){

        override val size: Int = state.size

        override fun get(index: Int): String{
            return state[index]
        }
    }
    println(al)
}
________________________________________________________________________________________________________

fun main() {

    val state = arrayOf("MH","MH","GJ","RJ","DL","DL","HP",
        "J&K","DD","SK","AP","TN","TS","KL","KK","MP")

    val al = object : AbstractList<String>(){

        override val size: Int = state.size

        override fun get(index: Int): String{
            return state[index]
        }
    }
    al.forEach { println("al : $it") }                  // print every string as it is
    al.stream().forEach { println("al.stream : $it") }  // print every string as it is
    al.parallelStream().forEach { println("al.parallelStream : $it") }  //prints randomly
    println("al.contains : ${al.contains("MH")}")       // true
    println("al.isEmpty : ${al.isEmpty()}")             // false
    println("al.last()  : ${al.last()}")                // MP
    println("al.sorted() : ${al.sorted()}")             // print sorted list
    println("al.any()  :  ${al.any()}")                 // true
}
________________________________________________________________________________________________________

fun main() {

    val mutable = mutableListOf("MH","MH","GJ","RJ","DL","DL","HP","J&K", "DD","SK","AP","TN","TS","KL","KK","MP")

    println("1 : $mutable")     // 1 : [MH, MH, GJ, RJ, DL, DL, HP, J&K, DD, SK, AP, TN, TS, KL, KK, MP]

    mutable.removeIf{ it == "MH" }
    println("2 : $mutable")     // 2 : [GJ, RJ, DL, DL, HP, J&K, DD, SK, AP, TN, TS, KL, KK, MP]

    mutable.removeIf{ it.contains("D")}
    println("3 : $mutable")         // 3 : [GJ, RJ, HP, J&K, SK, AP, TN, TS, KL, KK, MP]

    mutable.add(0,"AAA")

    println("4 : $mutable")         // 4 : [AAA, GJ, RJ, HP, J&K, SK, AP, TN, TS, KL, KK, MP]

    println("5 : mutable.asReversed()  :  ${mutable.asReversed()}")     //5 : mutable.asReversed()  :  [MP, KK, KL, TS, TN, AP, SK, J&K, HP, RJ, GJ, AAA]

    println("6 : mutable.fill(\"LUCK\") :  ${mutable.fill("LUCK")}") // 6 : mutable.fill("LUCK") :  kotlin.Unit

    println("7 : ${mutable}")   //7 : [LUCK, LUCK, LUCK, LUCK, LUCK, LUCK, LUCK, LUCK, LUCK, LUCK, LUCK, LUCK]

    println("8 : mutable.removeAll { it.contains(\"U\") } :  ${mutable.removeAll { it.contains("U") }}")  //8 : mutable.removeAll { it.contains("U") } :  true

    println("9 : ${mutable}")  // 9 : []
    
}
________________________________________________________________________________________________________

data class Student(var id : Int, var name : String, var email : String, val mobile : Long)

fun main() {
    val list = mutableListOf<Student>()
    list.add(Student(1,"Alex","alex@gmail.com",9988776655))
    list.add(Student(2,"Berry","ber@yahoo.com",8877665544))
    list.add(Student(3,"Charline","charlie@hotmail.com",7766554433))
    list.add(Student(4,"Dom","dom@yandex.com",6677889900))

    println(list)    /* will print following
    [
      Student(id=1, name=Alex, email=alex@gmail.com, mobile=9988776655), 
      Student(id=2, name=Berry, email=ber@yahoo.com, mobile=8877665544), 
      Student(id=3, name=Charline, email=charlie@hotmail.com, mobile=7766554433), 
      Student(id=4, name=Dom, email=dom@yandex.com, mobile=6677889900)
    ] */
  
    //-----------------------------------------------------------------------------------------------------
    val email = list.associateBy { it.email }  // email becomes keys of list
    println(email)   /* will print following 
    {
        alex@gmail.com=Student(id=1, name=Alex, email=alex@gmail.com, mobile=9988776655), 
        ber@yahoo.com=Student(id=2, name=Berry, email=ber@yahoo.com, mobile=8877665544), 
        charlie@hotmail.com=Student(id=3, name=Charline, email=charlie@hotmail.com, mobile=7766554433),
        dom@yandex.com=Student(id=4, name=Dom, email=dom@yandex.com, mobile=6677889900)
    }*/
    //-----------------------------------------------------------------------------------------------------
    
    val nameMobile = list.associateBy(Student::name,Student::mobile)
    println(nameMobile) /* will print following
    {
        Alex=9988776655, 
        Berry=8877665544, 
        Charline=7766554433, 
        Dom=6677889900
    }*/
    //-----------------------------------------------------------------------------------------------------
    
    val nameMobile = list.groupBy(Student::name,Student::mobile)
    println(nameMobile)
    /*
    {
        Alex=[9988776655], 
        Berry=[8877665544], 
        Charline=[7766554433], 
        Dom=[6677889900]
    }
    */

}



________________________________________________________________________________________________________

________________________________________________________________________________________________________
