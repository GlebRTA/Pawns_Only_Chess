fun main() {
    var gameLoop = true
    val game = PawnsOnlyChess()
    game.startGame()
    game.printBoard()
    currentMove = player1
    while (gameLoop) {

        if (game.checkWinner(currentMove)) {
            println("Bye!")
            break
        } else if (game.stalemate() && if (currentMove == player2) game.notHaveMoves() == 1 else game.notHaveMoves() == 2){
            println("Stalemate!")
            println("Bye!")
            break
        }

        println("$currentMove's turn:")
        val info = readln()
        if (info.equals("exit", ignoreCase = true) ) {
            println("Bye!")
            gameLoop = false
        } else if(!regex.matches(info)) {
            println("Invalid Input")
            continue
        } else {
            val n1: Int = 8 - info[1].digitToInt()
            val n2: Int = translate(info[0])
            val n3: Int = 8 - info[3].digitToInt()
            val n4: Int = translate(info[2])

            if (currentMove == player1 && game.board[n1][n2] == WHITE && (game.board[n3][n4] != BLACK && isMovable(player1, n1, n2, n3, n4))
                || (game.board[n3][n4] == BLACK && isCapture(player1, n1, n2, n3, n4))) {
                oneMovePl1 = false
                game.board[n1][n2] = EMPTY
                game.board[n3][n4] = WHITE
                if (n1 - n3 == 2) {
                    game.bigMoveBoard1[n2] = true
                    oneMovePl1 = true
                }

            } else if((oneMovePl2 && currentMove == player1 && game.board[n1][n2] == WHITE && game.board[n3][n4] != BLACK
                        && n1 == 3) && (when (n2) {
                    0 -> (game.board[n1][n2 + 1] == BLACK && game.bigMoveBoard2[n2 + 1])
                    7 -> (game.board[n1][n2 - 1] == BLACK && game.bigMoveBoard2[n2 - 1])
                    else -> ((game.board[n1][n2 - 1] == BLACK && game.bigMoveBoard2[n2 - 1])
                            || (game.board[n1][n2 + 1] == BLACK && game.bigMoveBoard2[n2 + 1]))
                })
            ) {
                game.board[n1][n2] = EMPTY
                game.board[n3][n4] = WHITE
                game.board[n1][n4] = EMPTY
            } else if (currentMove == player2 && game.board[n1][n2] == BLACK && (game.board[n3][n4] != WHITE && isMovable(player2, n1, n2, n3, n4))
                || (game.board[n3][n4] == WHITE && isCapture(player2, n1, n2, n3, n4))) {
                oneMovePl2 = false
                game.board[n1][n2] = EMPTY
                game.board[n3][n4] = BLACK
                if (n1 - n3 == -2){
                    game.bigMoveBoard2[n2] = true
                    oneMovePl2 = true
                }
            } else if ((oneMovePl1 && currentMove == player2 && game.board[n1][n2] == BLACK && game.board[n3][n4] != WHITE
                        && n1 == 4) && (when (n2) {
                    0 -> (game.board[n1][n2 + 1] == WHITE && game.bigMoveBoard1[n2 + 1])
                    7 -> (game.board[n1][n2 - 1] == WHITE && game.bigMoveBoard1[n2 - 1])
                    else -> ((game.board[n1][n2 - 1] == WHITE && game.bigMoveBoard1[n2 - 1])
                            || (game.board[n1][n2 + 1] == WHITE && game.bigMoveBoard1[n2 + 1]))
                })
            ) {
                game.board[n1][n2] = EMPTY
                game.board[n3][n4] = BLACK
                game.board[n1][n4] = EMPTY
            } else if (currentMove == player1 && game.board[n1][n2] != WHITE){
                println("No white pawn at ${info[0]}${info[1]}")
                //currentMove = swap(currentMove, player1, player2)
                continue
            } else if(currentMove == player2 && game.board[n1][n2] != BLACK) {
                println("No black pawn at ${info[0]}${info[1]}")
                //currentMove = swap(currentMove, player1, player2)
                continue
            } else if (isMovable(currentMove, n1, n2, n3, n4)) {
                println("Stalemate!\nBye!")
                gameLoop = false
                break
            } else {
                println("Invalid Input")
                continue
            }

            game.printBoard()

        }
        currentMove = swap(currentMove, player1, player2)
    }
}


