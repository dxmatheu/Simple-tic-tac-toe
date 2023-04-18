fun main() {
    val input = readln()
    val vowels = "aeiouy"
    var prevWasVowel = false
    var count = 0
    var needed = 0
    for (char in input){
        if (char in vowels){
            if (prevWasVowel){
                count++
                if(count == 3) {
                    needed++
                    count -= 2
                }
            } else count = 1
            prevWasVowel = true
        } else {
            if (!prevWasVowel){
                count++
                if(count == 3) {
                    needed++
                    count -= 2
                }
            } else count = 1
            prevWasVowel = false
        }
    }
    println(needed)
}
