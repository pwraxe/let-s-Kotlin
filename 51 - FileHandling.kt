// File Reading

import java.io.FileNotFoundException
import java.io.FileReader

fun main() {
    try {
        var fr = FileReader("C:\\Users\\DELL\\Desktop\\The Kotlin\\Kotlin Code\\Enum.txt")
        var c : Int?
        do {
            c = fr.read()
            print(c.toChar())
        }while(c != -1)
    }
    catch (ex : FileNotFoundException)
    {
        println("File not found ${ex.message}")
    }

}
_____________________________________________________________________________________________________
import java.io.FileNotFoundException
import java.io.FileReader

fun main()
{
    try {                             //Enumaration
        var fr = FileReader("C:\\Users\\DELL\\Desktop\\The Kotlin\\Kotlin Code\\Enumaration.kt")
        for (f in fr.readLines())
        {
            println(f)
        }
    }catch (ex : FileNotFoundException)
    {
        println("File not found")
    }
	fr.close()
}
_____________________________________________________________________________________________________

import java.io.FileWriter

fun main() {
    var fw = FileWriter("C:\\Users\\DELL\\Desktop\\The Kotlin\\Kotlin Code\\Sample.txt")
    fw.write(65)    // This Prints Character of 65 to the file
    fw.write("\nHi I am Akshay")
    fw.flush()         
}
