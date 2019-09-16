enum class Direction
{
    EAST,WEST,SOUTH,NORTH
}

fun main() {
    var direction = Direction.EAST
	
    if(direction == Direction.WEST)
        println("Direction is WEST")
		
    else if( direction == Direction.SOUTH)
        println("Direction is South")
		
    else if(direction == Direction.NORTH)
        println("Direction is South")
		
    else
        println("Direction is EAST")

}

________________________________________________________________________

enum class Direction
{
    EAST,WEST,SOUTH,NORTH
}

fun main() {
    var direction = when(Direction.EAST)
    {
        Direction.EAST -> "Direction is EAST"
        Direction.WEST -> "Direction is WEST"
        Direction.SOUTH -> "Direction is SOUTH"
        Direction.NORTH -> "Doirection is NORTH"
        else -> "Unknown Direction"
    }
    println(direction)
}
________________________________________________________________________

enum class Direction
{
    EAST,WEST,SOUTH,NORTH;
    companion object
    {
        var num : Int? = 1
        fun show()
        {
            println("Show Function in Direction Enum Class")
        }
    }
}

fun main() {
    var direction = when(Direction.EAST)
    {
        Direction.EAST -> "Direction is EAST"
        Direction.WEST -> "Direction is WEST"
        Direction.SOUTH -> "Direction is SOUTH"
        Direction.NORTH -> "Doirection is NORTH"
        else -> "Unknown Direction"
    }
    println(direction)
    println("Value in direction Enum Class :  ${Direction.num}")
    Direction.show()
}
--------------------------> output :

Direction is EAST
Value in direction Enum Class :  1
Show Function in Direction Enum Class