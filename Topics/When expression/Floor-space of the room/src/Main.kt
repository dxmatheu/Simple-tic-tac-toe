fun main() = println(
    when (readln()) {
        "rectangle" -> readln().toDouble() * readln().toDouble()
        "circle" -> 3.14 * Math.pow(readln().toDouble(), 2.0)
        "triangle" -> {
            val a = readln().toDouble()
            val b = readln().toDouble()
            val c = readln().toDouble()
            val s = (a + b + c) / 2
            kotlin.math.sqrt(s * (s - a) * (s - b) * (s - c))
        }
        else -> {
            //do nothing
        }
    }
)
