/*
* Char 타입의 symbol 속성용 파라미터를 사용하게 된다.
* open 없이 display()를 정의했다면 어떤 suit의 값도 display()를 오버라이드 할 수 없다.
* 메소드를 오버라이드하길 원하는 suit엔 오버라이드를 하고 다른 suit에는 이미 구현된 메소드를 사용한다.
* */
enum class Suit(val symbol: Char) {
    CLUBS('\u2663'),
    DIAMONDS('\u2666'),
    HEARTS('\u2665') {  //display() 메소드를 오버라이드하는 익명 내부 클래스
        override fun display() = "${super.display()} $symbol"
    },
    SPADES('\u2660');
    open fun display() = "$symbol $name"
}

for (suit in Suit.values()) {
    println(suit.display())
    println(suit.javaClass) //나머지는 Suit의 인스턴스라고 나오지만 HEARTS는 Suit의 익명 내부 클래스의 인스턴스라고 나온다.
}
