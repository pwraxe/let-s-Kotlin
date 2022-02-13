/**
*
*  Logic : if any number last digit grater than 5  OR less than 5 then make that number multiply by 10 
*
*  Input Example 
*  a = 12
*  b = 38
*  c  45
* 
*  Output : 
*  a = 10
*  b = 40
*  c = 50
*
*  Addition of a+b+c > 100
*/

fun main() {
        var a = 6
        var b = 29
        var c = 1

      
        var nums = intArrayOf(a,b,c)


        for(i in 0 until nums.size) {
           
            var va = nums[i].toString()
            
            println("--> $va")
            
            if(va.length > 1){

                var lastNumber = va[va.length-1].toString().toInt()
                println("Last No : $lastNumber")

                if(lastNumber >= 5){
                    val valToAdd = 10 - lastNumber;
                    nums[i] =  nums[i]+valToAdd
                    println("==> ${nums[i]}")
                }else{
                   
                    nums[i] = nums[i] - lastNumber
                    println("$va >>> ${nums[i]}")
                }
            }else{
                //valueLenght == 1
                
                val lastNumber = va[va.length-1].toString().toInt()
                if(lastNumber >= 5){
                    nums[i] = 10
                }else{
                    nums[i] = 0
                }
            }
        }
        var addition = 0
        
       for(num in nums){
           addition += num
       }
       println("Addition : $addition")
    
}
