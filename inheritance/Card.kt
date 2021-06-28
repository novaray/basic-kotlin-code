/*
* sealed 클래스의 생성자는 private이 표기되지 않았지만 private로 취급된다.
* Ace같은 sealed 클래스의 자식 클래스는 여러 개의 인스턴스를 생성할 수 있고, 상태(속성)을 가질 수 있고,
* 메소드를 가질 수 있다. 자식 클래스는 sealed 클래스의 싱글톤 객체가 될 수 있다.
* 다른 파일에서 Card를 상속받으려고 한다면 실패할 것이다.
* */
sealed class Card(val suit: String)
class Ace(suit: String) : Card(suit)
class King(suit: String) : Card(suit) {
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

/*
* when 표현식을 사용할 때 else를 사용하면 안 된다. 만일 when에 sealed 클래스의 자식 클래스가
* 어떤 타입이어도 속할 수 있는 조건이 있을 때 else를 사용한다면 else는 절대 사용되지 않는다는
* 경고가 나타난다. 만약 when에 자식 클래스가 속할 수 있는 조건이 누락된 경우 컴파일러가 else 조건을
* 추가하라는 제안을 하지만 절대 추가해서는 안 된다.
* */
fun process(card: Card) = when (card) {
    is Ace -> "${card.javaClass.name} of ${card.suit}"
    is King, is Queen, is Jack -> "$card"
    is Pip -> "${card.number} of ${card.suit}"
}

fun main() {
    println(process(Ace("Diamond")))    //Ace of Diamond
    println(process(Queen("Clubs")))    //Queen of Diamond
    println(process(Pip("Spades", 2)))    //2 of Spades
    println(process(Pip("Hearts", 6)))    //6 of Hearts
}