fun main() {
    val totalNums = readln().toInt()
    var longest = 1
    var length = 0
    var prev = 0
    for ( x in 1..totalNums){
        val num = readln().toInt()
        if (num >= prev){
            length +=1
            if(length > longest) longest = length
        } else {
            length = 1
        }
        prev = num
    }
    println(longest)
}
