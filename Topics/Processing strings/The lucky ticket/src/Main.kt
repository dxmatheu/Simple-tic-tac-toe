fun main() {
    val input = readln()
    println(if (input[0].digitToInt() + input[1].digitToInt() + input[2].digitToInt() == input[3].digitToInt() + input[4].digitToInt() + input[5].digitToInt()) "Lucky" else "Regular")
}
