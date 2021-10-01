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
