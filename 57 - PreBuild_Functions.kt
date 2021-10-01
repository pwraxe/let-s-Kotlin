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
