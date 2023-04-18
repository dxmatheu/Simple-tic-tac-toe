fun main() {
    val num1 = readln().toInt()
    val num2 = readln().toInt()
    var sum = 0
    for (num in num1..num2) {
        sum += num
    }
    println(sum)
}
