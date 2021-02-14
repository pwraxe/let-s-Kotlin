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
________________________________________________________________________________________________________
