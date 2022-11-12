class PawnsOnlyChess {
    val board = MutableList(8){ MutableList(8) { EMPTY } }
    val bigMoveBoard1 = MutableList(8) { false }
    val bigMoveBoard2 = MutableList(8) { false }


    constructor() {
        for(i in board[1].indices){
            board[1][i] = BLACK
        }

        for(i in board[6].indices){
            board[6][i] = WHITE
        }
    }

    fun startGame() {
        println("Pawns-only Chess")
        println("First Player's name:")
        player1 = readln()
        println("Second Player's name:")
        player2 = readln()
    }

    fun printBoard() {
        for(i in 8 downTo 1) {
            println("  +---+---+---+---+---+---+---+---+")
            print("$i |")
            for (j in 0..7) {
                print(" ${board[8 - i][j]} |")
            }
            println()
        }
        println("  +---+---+---+---+---+---+---+---+")
        println("    a   b   c   d   e   f   g   h  ")
    }

    fun checkWinner(player: String): Boolean {
        //val n = if (player == player1) 0 else 7
        var blackCount = 0
        var whiteCount = 0
        for (i in board[0]) {
            if (i == WHITE) {
                println("White Wins!")
                return true
            } else if (i == BLACK){
                println("Black Wins!")
                return true
            }
        }

        for (i in board[7]) {
            if (i == WHITE) {
                println("White Wins!")
                return true
            } else if (i == BLACK){
                println("Black Wins!")
                return true
            }
        }

        for(row in board) {
            for (elem in row) {
                if( elem == WHITE){
                    whiteCount++
                }
                else if (elem == BLACK) {
                    blackCount++
                }
            }
        }
        if(blackCount == 0) {
            println("White Wins!")
            return true
        } else if(whiteCount == 0) {
            println("Black Wins!")
            return true
        }
        return false
    }

    fun stalemate(): Boolean {
        for(row in board.indices) {
            for (elem in board[row].indices) {

                if(board[row][elem] == BLACK && board[row + 1][elem] == WHITE && (when (elem) {
                        0 -> board[row + 1][elem + 1] == EMPTY
                        7 -> board[row + 1][elem - 1] == EMPTY
                        else -> board[row + 1][elem + 1] == EMPTY && board[row + 1][elem - 1] == EMPTY
                    })) {
                    return true
                }
                else if(board[row][elem] == WHITE && board[row - 1][elem] == BLACK && (when (elem) {
                        0 -> board[row - 1][elem + 1] == EMPTY
                        7 -> board[row - 1][elem - 1] == EMPTY
                        else -> board[row - 1][elem + 1] == EMPTY && board[row - 1][elem - 1] == EMPTY})) {

                    return true
                }

            }
        }
        return false
    }

    fun notHaveMoves(): Int {
        var bCount = 0
        var wCount = 0
        for (row in board.indices) {
            for (elem in board[row].indices) {
                if (board[row][elem] == BLACK && board[row + 1][elem] == EMPTY) {
                    bCount++
                } else if(board[row][elem] == WHITE && board[row - 1][elem] == EMPTY) {
                    wCount++
                }
            }
        }
        if (wCount == 0) {
            return 2
        } else if (bCount == 0) {
            return 1
        } else {
            return 0
        }

    }
}
