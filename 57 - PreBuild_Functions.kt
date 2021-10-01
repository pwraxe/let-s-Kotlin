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
