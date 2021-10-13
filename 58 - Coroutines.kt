in Android Studio add following lib

    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5'

    
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"


- A CoroutineScope is a context that enforces cancellation and other rules to its children.
- A Dispatcher manages backing thread, coroutine will use for its execution, removing the responsibility to use a new thread from the developer.

- Job : A cancelable unit of work, such as one created with the launch() function.
- CoroutineScope : This used to create new coroutines such as launch() and async() extend CoroutineScope.
- Dispatcher : Determines the thread on which coroutine will use. 
- Dispatcher.Main =  It always runs coroutines on the main thread.
- GlobalScope : The GlobalScope allows any coroutines in it to run as long as the app is running.

____________________________________________________________________________________________________________________________________________________________________

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
    - To cancel job first check whether .cancel() block executes or not by if(isActive) 
    - lifecycleScope --> coroutine executes till activity or fragment lifecycle alive

    - runBlocking{}  Vs coroutineScope{}  
        - runBlocking{} =  The main difference is that the runBlocking method blocks the current thread for waiting.
        - coroutineScope{} = It is suspend fun, releasing the underlying thread for other usages.
        - We can write multiple launch{} block in coroutineScope{}
        - launch{} block return reference of job type
    
    - async{}  Vs  launch{} : async does return a Deferred<>, while launch does only return a Job,
        - async :  Use async when you need the results from the multiple tasks that run in parallel.
        - launch : Launch can be used at places if you don`t need the result from the method called
    - if we cancel work/job then we need to check whether coroutine active or not by using `isActive`  in launch{} or await{} etc block
    - If I want to execute certain code in specific/given time then we will use `withTimeout(timeInMiliSec){}` if code remain to execute then get `TimeoutCancellationException`
    - withTimeoutOrNull(timeInMilliSec){ return null if time exausted}
    - If you want to know , how much time took for execution then,    val time = measureTimeMillis{ /* todo work */ } ; print(time) //prints in milisecond    
    - Flow : - It is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value.
             - For example, you can use a flow to receive live updates from a database.








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

class MainActivity : ...{
    
    onCreate(){
         val job = GlobalScope.launch(Dispatchers.Default){
            repeat(5){
                Log.d("AXE","global launch : $it")
                delay(1000)
            }
        }

        runBlocking {
            Log.d("AXE","run block launch")
        }
    }
}
// runBlocking executes at any time can't say sequence

______________________________________________________________________________________________________________________________________________________

join () ====> 
    
class MainActivity : ...{

    onCreate(){
        val job = GlobalScope.launch(Dispatchers.Default){
            repeat(5){
                Log.d("AXE","global launch : $it")
                delay(1000)
            }
        }

        runBlocking {
            job.join()                                      // once above code done with execution, this thread continue to run
            job.cancel()   // cancel the job
            Log.d("AXE","run block launch")
        }
    }
}
__________________________________________________________________________________________________________________________________________________________

make thread run parallal 

class MainActivity : AppCom..{

    onCreate(){
    
        GlobalScope.launch {
            val time = measureTimeMillis {
                launch { doWork1() }
                launch { doWork2() }
            }
            Log.d("AXE","Time taken : $time")   // 2s
        }
    }
     private suspend fun doWork1(){
        delay(2000L)
        Log.d("AXE","Do Work 1")
    }

    private suspend fun doWork2(){
        delay(2000L)
        Log.d("AXE","Do Work 2")
    }
}

===============================OR=============================
class MainActivity : AppCom..{

    onCreate(){ 
        GlobalScope.launch {
            val time = measureTimeMillis {
                val work1 = async { doWork1() }
                val work2 = async { doWork2() }

                Log.d("AXE", work1.await())
                Log.d("AXE", work2.await())
            }
            Log.d("AXE","Time taken : $time")   //2013 Second

        }
    }
    
    private suspend fun doWork1() : String{
            delay(2000L)
            return "Do Work 1"
        }

        private suspend fun doWork2(): String{
            delay(2000L)
            return "Do Work 2"
        }
}
    
    
    




 
