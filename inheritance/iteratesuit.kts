// valueOf()에 전달된 String과 매치되는 값이 해당 enum 클래스에 없다면 실행 시간 예외(RuntimeException)가 발생한다.
val diamonds = Suit.valueOf("DIAMONDS")

// values 메소드는 enum 클래스의 인스턴스의 모든 값을 배열로 제공해준다.
for (suit in Suit.values()) {
    println("${suit.name} -- ${suit.ordinal}")  //CLUBS -- 0, etc.
}