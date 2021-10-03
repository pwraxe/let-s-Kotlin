in Android Studio add following lib

    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5'

Few Notes about Coroutine
    - delay(0L) ---> this is suspend function so you only have to call from either in launch{ .. } or suspend function 
    - code sequentially run inside suspend fun 
    - Excecution Sequence > Dispatchers.Unconfined > Dispatchers.Default > Dispatchers.IO > Dispatchers.Main
    - launch{ .. } this bloack create new coroutine/thread and continue work
    - 1. Dispatchers.Main = run on main thread
      //IO Thread = This create an event to communicate with other thread 
      2. Dispatchers.IO =  it is used to perform all the data operations such as networking, reading, or writing from the database, reading, or writing to the files
      3. Dispatchers.Default = When coroutines are launched in GlobalScope is represented by Dispatchers. Default and uses a shared background pool of threads
      4. Dispatchers.Unconfined = when Dispatchers dont know thread then it continue with thread with in used
            // lets the coroutine resume in whatever thread that is used by the corresponding suspending function
    - runBlocking{} ===> This Block run on main thread. It block main thread till execution completion in runBlock 
    - If we have multiple runBlocking{} it executes sequentially

_________________________________________________________________________________________________________________________________
// following both global scope work parallely unfix sequence

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        ..... 
        
        GlobalScope.launch {
            repeat(50){
                Log.d("AXE","${Thread.currentThread().name}  Hi : $it")
                delay(1000L)
            }
        }

        GlobalScope.launch {
            repeat(20){
                Log.d("AXE","${Thread.currentThread().name} Hello : $it")
                delay(1000L)
            }
        }
    }
}

__________________________________________________________________________________________________________________________________

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        .....
        
        CoroutineScope(Dispatchers.Main).launch { doWork("Main") }                      // -------------------------- 4th this execute
        
        CoroutineScope(Dispatchers.IO).launch{ doWork("IO") }                           // -------------------------- 3rd this execute

        CoroutineScope(Dispatchers.Default).launch { doWork("Default") }                // -------------------------- 2nd this execute

        CoroutineScope(Dispatchers.Unconfined).launch { doWork("Unconfined") }          // -------------------------- 1st this execute
    }

    private suspend fun doWork(name:String){
        repeat(20){
            delay(1500L)
            Log.d("AXE","Thread $name Working : $it")
        }
    }
}

output : //following same sequence executes for 20 times

D/AXE: Thread Unconfined Working
D/AXE: Thread Default Working : 
D/AXE: Thread IO Working : 0
D/AXE: Thread Main Working : 0
________________________________________________________________________________________________________________________

// Switch between Threads 
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        GlobalScope.launch(Dispatchers.IO) {
            doWork("IO")                                        // control stuck here till doWork complete its execution
            withContext(Dispatchers.Main){ doWork("Main") }     // IO Thread Join to Main Thread here
        }
    }

    private suspend fun doWork(name:String){
        repeat(20){
            delay(1500L)
            Log.d("AXE","Thread $name Working : $it")
        }
    }
}
_____________________________________________________________________________________________________________________________________________________






 
