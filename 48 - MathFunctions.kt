import java.lang.Math.pow
import kotlin.math.*

fun main() {
    println("Math.PI  :  ${Math.PI}")
    println("abs(-95)  :  ${abs(-95)}")
    println("Math.E :  ${Math.E}")
    println("Math.addExact(5,8) : ${Math.addExact(5,8)}")
    println("ceil(126.5) : ${ceil(126.5)}")
    println("floor(126.5)  :  ${floor(126.5)}")
    println("Math.getExponent(2.6) : ${Math.getExponent(2.6e10)}")
    println("ln(10.2) : ${ln(10.2)}")
    println("max(25,52) : ${max(25,52)}")
    println("min(10,100)  :  ${min(10,100)}")
    println("exp(5.0) : ${exp(5.0)}")

    println("pow(2.0,3.0)  :  ${pow(2.0,3.0)}")
    println("Math.random() : ${Math.random()}")
    println("rint(126.2) : ${round(126.2)}")
    println("Math.round(125.55)  :  ${round(125.55)}")
    println("sqrt(16.0)  :  ${sqrt(16.0)}")
    println("Math.toDegrees(45.0) : ${Math.toDegrees(45.0)}")
    println("Math.ulp(125.5) : ${Math.ulp(125.5)}")
}

---------------------------------------OUTPUT

Math.PI  :  3.141592653589793
abs(-95)  :  95
Math.E :  2.718281828459045
Math.addExact(5,8) : 13
ceil(126.5) : 127.0
floor(126.5)  :  126.0
Math.getExponent(2.6) : 34
ln(10.2) : 2.322387720290225
max(25,52) : 52
min(10,100)  :  10
exp(5.0) : 148.4131591025766
pow(2.0,3.0)  :  8.0
Math.random() : 0.24744237523637724
rint(126.2) : 126.0
Math.round(125.55)  :  126.0
sqrt(16.0)  :  4.0
Math.toDegrees(45.0) : 2578.3100780887044
Math.ulp(125.5) : 1.4210854715202004E-14