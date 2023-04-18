fun main() {
    val totalNum = readln().toInt()
    val numList = mutableListOf<Int>()
    for (i in 1..totalNum) {
        numList.add(readln().toInt())
    }
    var max = -1
    for (i in numList) {
        if (i > max) max = i
    }
    println(numList.indexOf(max))
}