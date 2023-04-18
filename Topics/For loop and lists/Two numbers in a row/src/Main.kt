fun main() {
    val totalNum = readln().toInt()
    val numList= mutableListOf<Int>()
    for (i in 1..totalNum){
        numList.add(readln().toInt())
    }
    val requirement = readln().split(" ")
    val num1 = requirement[0].toInt()
    val num2 = requirement[1].toInt()
    var prev = -1
    var isParNotPresent = "YES"
    for (i in numList){
        if (prev == num1 && i == num2 || prev == num2 && i == num1){
            isParNotPresent = "NO"
        }
        prev = i
    }
    println(isParNotPresent)
}

//9
//3
//4
//5
//6
//3
//8
//6
//4
//4
//4 6
