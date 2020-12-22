package playground.`6boardgame`

public enum class Direction {
    UP, DOWN, RIGHT, LEFT;

    public fun reversed() = when (this) {
        UP -> DOWN
        DOWN -> UP
        RIGHT -> LEFT
        LEFT -> RIGHT
    }
}