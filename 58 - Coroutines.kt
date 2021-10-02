in Android Studio add following lib

    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5'


_________________________________________________________________________________________________________________________________
// following both global scope work parallely unfix sequence

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
