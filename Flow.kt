Own Note : 
-> Flow is something like live data

like when mutableLiveData change, we get data in observer same 
when emit() data collect{} immidiate calls and we get data in collect{}



---------------------------------------------------------------------------------------------------------------------------------------------


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {


    getNumber().collect {
        println("Collected : $it")
    }

    getList().collect {
        println("List Data : $it")
    }

    getSeries().collect {
        println("Series No : $it")
    }

    (11..20)
        .asFlow()
        .map {
            it.plus(it)
        }
        .transform {
            emit("Hello From : $it")
        }
        .onEach {
            check(it == "Hello From : 15")  //if string match then throw exception finally call onCompletion
        }
        .catch {
            println("Exception : $it") //Exception : java.lang.IllegalStateException: Check failed.
        }
        .onCompletion {
            println("On Completion")
        }
        .collect {
            println("New List : $it")
        }

}

fun getNumber(): Flow<Int> = flow {
    (0..10).forEach {
        delay(100)
        emit(it)
    }
}

fun getList() = (0..10).asFlow()

fun getSeries() = flowOf("ONE","TWO","THREE","FOUR","FIVE")

