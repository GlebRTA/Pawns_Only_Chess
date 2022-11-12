fun isMovable(player: String, n1: Int, n2: Int, n3: Int, n4: Int): Boolean {
    if (player == player1 && (if (n1 == 6) n1 - n3 in 1..2 else n1 - n3 == 1) && n2 == n4) {
        return true
    }
    else if (player == player2 && (if (n1 == 1) n1 - n3 in -2..-1 else n1 - n3 == -1) && n2 == n4) {
        return true
    }
    return false
}

fun isCapture(player: String, n1: Int, n2: Int, n3: Int, n4: Int): Boolean {
    if (player == player1 && (n4 == n2 - 1 || n4 == n2 + 1) && n1 - n3 == 1 ) {
        return true
    }
    else if (player == player2 && (n4 == n2 - 1 || n4 == n2 + 1) && n1 - n3 == -1){
        return true
    }
    return false
}


fun swap(playerCheck: String, player1: String, player2: String): String {
    return when(playerCheck) {
        player1 -> { player2 }
        player2 -> { player1 }
        else -> "error"
    }
}

fun translate(str: Char): Int {
    return when (str) {
        'a' -> 0
        'b' -> 1
        'c' -> 2
        'd' -> 3
        'e' -> 4
        'f' -> 5
        'g' -> 6
        'h' -> 7
        else -> 10
    }
}
