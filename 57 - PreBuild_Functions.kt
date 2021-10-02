------> zip()

fun main() {

    val nums = arrayOf(1,2,3,4)
    val text = arrayOf("One","Two","Three","Four")

    println(nums.zip(text)) //  [(1, One), (2, Two), (3, Three), (4, Four)]
    println(text.zip(nums)) //  [(One, 1), (Two, 2), (Three, 3), (Four, 4)]
    println(nums.zip(nums)) //  [(1, 1), (2, 2), (3, 3), (4, 4)]
    println(text.zip(text)) //  [(One, One), (Two, Two), (Three, Three), (Four, Four)]
}
____________________________________________________________________________________________

-------> flatten()

fun main() {
    val numberSets = listOf(listOf("A","C","B"), listOf("1",2,'C'), listOf(3.14,true,0b111))
    println(numberSets.flatten()) // [A, C, B, 1, 2, C, 3.14, true, 7]
}

___________________________________________________________________________________________

-------> joinToString()
fun main() {
    val text = listOf("A","B","C","D","E","F","G")
    println(text.joinToString())    // A, B, C, D, E, F, G
}

___________________________________________________________________________________________

--------> filter()

fun main() {
    val num = listOf(1,22,5,4,8,8,5,5,5,2,1,4,5,2,1,4,4,45)

    num.filter { it > 5 }.forEach { print(" $it") }     //  22 8 8 45
    println()
    num.filterNotNull().forEach { print(" $it") }       //  1 22 5 4 8 8 5 5 5 2 1 4 5 2 1 4 4 45
    println()
    num.filterNot { it < 5 }.forEach { print(" $it") }  //  22 5 8 8 5 5 5 5 45
    println()
    println("==> ${num.filterIndexed { index, i -> index > i }}")     //==> [5, 5, 5, 2, 1, 4, 5, 2, 1, 4, 4]
    println("--> ${num.filterIsInstance<Int>()}")       // --> [1, 22, 5, 4, 8, 8, 5, 5, 5, 2, 1, 4, 5, 2, 1, 4, 4, 45]
    
    
    val text = listOf("a","k","s","h","a","y")
    text.filterIsInstance<String>().forEach { print(it.uppercase(Locale.getDefault())) }
}

____________________________________________________________________________________________

--------> partition{ }

fun main() {
    val list = listOf("Akshay",100,true,"Aman",84,false,"Aryan",25,true,"Sam",16,"Kolkata",12,15,true)

    val part1 = list.partition { it is String }
    println("Part 1 : $part1")  // Part 1 : ([Akshay, Aman, Aryan, Sam, Kolkata], [100, true, 84, false, 25, true, 16, 12, 15, true])

    val part2 = list.partition { it is String && it is Int }
    println("Part 2 : $part2")  // Part 2 : ([], [Akshay, 100, true, Aman, 84, false, Aryan, 25, true, Sam, 16, Kolkata, 12, 15, true])

    val part3 = list.partition { it is String || it is Boolean }
    println("Part 3 : $part3")  // Part 3 : ([Akshay, true, Aman, false, Aryan, true, Sam, Kolkata, true], [100, 84, 25, 16, 12, 15])

    val part4 = list.partition { it is Int }
    println("Part 4 : $part4")  // Part 4 : ([100, 84, 25, 16, 12, 15], [Akshay, true, Aman, false, Aryan, true, Sam, Kolkata, true])
}

________________________________________________________________________________________________

--------> take and drop () 

fun main() {
    val list = listOf(1,2,3,4,5,6,7,8,9)

    val take1 = list.take(4)                 // takes first 4 nums
    println("1 -------> $take1")                // 1 -------> [1, 2, 3, 4]

    val take2 = list.takeLast(2)            // takes last 2 nums
    println("2 -------> $take2")               // 2 -------> [8, 9]

    val take3 = list.takeWhile { it in 5..7 }  // take only those numbers which between 5..7
    println("3 -------> $take3")               // 3 -------> []

    val take4 = list.takeLastWhile { it > 7 }   // take last nums which > 7
    println("4 -------> $take4")                // 4 -------> [8, 9]

    val drop1 = list.drop(2)                 // drop/delete first 2 nums
    println("5 -------> $drop1")                // 5 -------> [3, 4, 5, 6, 7, 8, 9]

    val drop2 = list.dropLast(3) // drop/delete last 3 nums
    println("6 -------> $drop2")                // 6 -------> [1, 2, 3, 4, 5, 6]

    val drop3 = list.dropWhile { it < 8 }    // drop/delete all odd numbers
    println("7 -------> $drop3")                // 7 -------> [8, 9]

    val drop4 = list.dropLastWhile { it > 7 }   // drop/delete last nums less than 7
    println("8 -------> $drop4")                // 8 -------> [1, 2, 3, 4, 5, 6, 7]
}
___________________________________________________________________________________________________

------> windowed() 

fun main() {
    val list = listOf(1,2,3,4,5,6,7,8,9)
    println(list.windowed(1))   // [[1], [2], [3], [4], [5], [6], [7], [8], [9]]
    println(list.windowed(2))   // [[1, 2], [2, 3], [3, 4], [4, 5], [5, 6], [6, 7], [7, 8], [8, 9]]
    println(list.windowed(3))   // [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7], [6, 7, 8], [7, 8, 9]]
    println(list.windowed(4))   // [[1, 2, 3, 4], [2, 3, 4, 5], [3, 4, 5, 6], [4, 5, 6, 7], [5, 6, 7, 8], [6, 7, 8, 9]]
    println(list.windowed(5))   // [[1, 2, 3, 4, 5], [2, 3, 4, 5, 6], [3, 4, 5, 6, 7], [4, 5, 6, 7, 8], [5, 6, 7, 8, 9]]
    
    println(list.windowed(3,2,true))        // [[1, 2, 3], [3, 4, 5], [5, 6, 7], [7, 8, 9], [9]]
    println(list.windowed(3,3,false))       // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
}

_____________________________________________________________________________________________________
-------> groupBy()

fun main() {
    val list = listOf(1,2,3,4,5,6,7,8,9)
    println(list.groupBy { it > 5 })            // {false=[1, 2, 3, 4, 5], true=[6, 7, 8, 9]}
    println(list.groupBy { it%2 == 0 })         //{false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8]}
    
    val text = listOf("Google","Xerox","Microsoft","Apple")
    println(text.groupBy { it.length >5 })      //{true=[Google, Microsoft], false=[Xerox, Apple]}
    
    println(text.groupBy(keySelector = { it.first() },valueTransform = { it.uppercase(Locale.getDefault()) }))  //{G=[GOOGLE], X=[XEROX], M=[MICROSOFT], A=[APPLE]}
    println(text.groupingBy { it.first() }.eachCount()) // {G=1, X=1, M=1, A=1}
}
_____________________________________________________________________________________________________

--------> slice()

fun main() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")

    println(numbers.slice(1..4))        //[two, three, four, five]
    println(numbers.slice(1..5 step 2)) //[two, four, six]
}

_____________________________________________________________________________________________________

---------> Retrieving Element
 fun main() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")

    // Retrieving element
    println("1 ------> : ${numbers.elementAt(2)}")                     // 1 ------> : three
    println("2 ------> : ${numbers.first()}")                          // 2 ------> : one
    println("3 ------> : ${numbers.first { it.length == 5 }}")         // 3 ------> : three
    println("4 ------> : ${numbers.first { it.startsWith("f") }}")     // 4 ------> : four
    println("5 ------> : ${numbers.find { it.length > 4 }}")           // 5 ------> : three
    println("6 ------> : ${numbers.random()}")                         // 6 ------> : five
    println("7 ------> : ${numbers.randomOrNull()}")                   // 7 ------> : one

    //check element existence
    println("8 ------> : ${numbers.contains("five")}")                 // 8 ------> : true
    println("9 ------> : ${"zero" in numbers}")                        // 9 ------> : false

    println("10------> : ${numbers.isEmpty()}")                        // 10------> : false
    println("11------> : ${numbers.isNotEmpty()}")                     // 11------> : true
}
