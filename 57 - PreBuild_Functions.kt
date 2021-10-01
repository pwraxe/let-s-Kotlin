------> zip()

fun main() {

    val nums = arrayOf(1,2,3,4)
    val text = arrayOf("One","Two","Three","Four")

    println(nums.zip(text)) //  [(1, One), (2, Two), (3, Three), (4, Four)]
    println(text.zip(nums)) //  [(One, 1), (Two, 2), (Three, 3), (Four, 4)]
    println(nums.zip(nums)) //  [(1, 1), (2, 2), (3, 3), (4, 4)]
    println(text.zip(text)) //  [(One, One), (Two, Two), (Three, Three), (Four, Four)]
}
