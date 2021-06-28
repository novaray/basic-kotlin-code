enum class Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
sealed class Card(val suit: Suit)
class Ace(suit: Suit) : Card(suit)
class King(suit: Suit) : Card(suit) {
    override fun toString(): String = "King of $suit"
}
class Queen(suit: String) : Card(suit) {
    override fun toString(): String = "Queen of $suit"
}
class Jack(suit: String) : Card(suit) {
    override fun toString(): String = "Jack of $suit"
}
class Pip(suit: String, val number: Int) : Card(suit) {
    init {
        if (number < 2 || number > 10) {
            throw RuntimeException("Pip has to be between 2 and 10")
        }
    }
}

fun process(card: Card) = when (card) {
    is Ace -> "${card.javaClass.name} of ${card.suit}"
    is King, is Queen, is Jack -> "$card"
    is Pip -> "${card.number} of ${card.suit}"
}

fun main() {
    println(process(Ace(Suit.DIAMONDS)))    //Ace of Diamond
    println(process(Queen(Suit.CLUBS)))    //Queen of Diamond
    println(process(Pip(Suit.SPADES, 2)))    //2 of Spades
    println(process(Pip(Suit.HEARTS, 6)))    //6 of Hearts
}
