const val EMPTY = ' '
const val BLACK = 'B'
const val WHITE = 'W'
val regex = "[a-h][1-8][a-h][1-8]".toRegex()
lateinit var player1: String
lateinit var player2: String
lateinit var currentMove: String

var oneMovePl1 = false
var oneMovePl2 = false
