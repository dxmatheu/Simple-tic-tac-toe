package tictactoe

import java.lang.IllegalArgumentException
import kotlin.math.absoluteValue

fun countX(inputString: CharArray): Int{
    return inputString.count { it == 'X' }
}

fun countO(inputString: CharArray): Int{
    return inputString.count { it == 'O' }
}

fun printGrid(inputString: CharArray){
    println("---------")
    println("| ${inputString[0]} ${inputString[1]} ${inputString[2]} |")
    println("| ${inputString[3]} ${inputString[4]} ${inputString[5]} |")
    println("| ${inputString[6]} ${inputString[7]} ${inputString[8]} |")
    println("---------")
}

fun checkBoard(inputString: CharArray): String{
    var gameState = "Game not finished"
    var xwin = false
    var owin = false
//    Verticales
//        primera file
    if (inputString.joinToString().startsWith("O, O, O")) owin = true
    if (inputString.joinToString().startsWith("X, X, X")) xwin = true
//        segunda fila
    if (inputString[3] == inputString[4] && inputString[3] == inputString[5]){
        if (inputString[3] == 'X') xwin = true
        else if  (inputString[3] == 'O') owin = true
    }
//        tercera fila
    if (inputString[6] == inputString[7] && inputString[6] == inputString[8]){
        if (inputString[6] == 'X') xwin = true
        else if  (inputString[6] == 'O') owin = true
    }
//    Columnas
//        primera columna
    if (inputString[0] == inputString[3] && inputString[0] == inputString[6]){
        if (inputString[0] == 'X') xwin = true
        else if  (inputString[0] == 'O') owin = true
    }
//        segunda columna
    if (inputString[1] == inputString[4] && inputString[1] == inputString[7]){
        if (inputString[1] == 'X') xwin = true
        else if  (inputString[1] == 'O') owin = true
    }
//        tercera columna
    if (inputString[2] == inputString[5] && inputString[2] == inputString[8]){
        if (inputString[2] == 'X') xwin = true
        else if  (inputString[2] == 'O') owin = true
    }
//    Diagonales
//        primera diagonal
    if (inputString[0] == inputString[4] && inputString[0] == inputString[8]){
        if (inputString[0] == 'X') xwin = true
        else if  (inputString[0] == 'O') owin = true
    }
//        segunda diagonal
    if (inputString[2] == inputString[4] && inputString[2] == inputString[6]){
        if (inputString[2] == 'X') xwin = true
        else if  (inputString[2] == 'O') owin = true
    }
    val playDifference = (countO(inputString) - countX(inputString)).absoluteValue
    val turn = countX(inputString) + countO(inputString)
    if (xwin && owin || playDifference > 1 ){
        gameState = "Impossible"
    } else if (xwin == false && owin == false){
        when(turn) {
            in 0..8 -> gameState = "Game not finished"
            9 -> gameState = "Draw"
            else -> gameState = "Impossible"
        }
    } else if (xwin == true){
        gameState = "X wins"
    } else if (owin == true){
        gameState = "O wins"
    }

    return gameState
}

fun main() {
    val boardState = "         ".toCharArray()
    printGrid(boardState)
    var player = 'X'
    while (checkBoard(boardState) == "Game not finished"){
        var validInput = false
        var x = 0
        var y = 0
        var position1D = -1
        do{
            var move = readln()
            try {
                x = move[0].digitToInt()
                y = move[2].digitToInt()
            } catch (e: IllegalArgumentException) {
                println("You should enter numbers!")
            }
            position1D = (x-1)*3 + (y-1)
            if (x !in 1..3 || y !in 1..3 ){
                println("Coordinates should be from 1 to 3!")
            }
            else if (boardState[position1D] != ' '){
                println("This cell is occupied! Choose another one!")
            }
            else validInput = true

        }while (!validInput)

        boardState[position1D] = player
        if (player == 'X') player = 'O' else player = 'X'

        printGrid(boardState)
    }
    println(checkBoard(boardState))


}