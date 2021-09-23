var length = 100

/**
 * String.(Int) 문법은 람다가 String의 인스턴스의 컨텍스트에서 실행된다는 의미를 가지고 있다.
 */
val printIt: String.(Int) -> Unit = { n: Int ->
    println("n is $n, length is $length")
}

/**
 * 추가적인 아규먼트를 전달해줘야 한다. 즉, 내부에서 this에 바운딩 될 컨텍스트 또는 리시버가 필요하다.
 * 코틀린에서 선호되는 문법은 아니다.
 */
printIt("Hello", 6)

/**
 * 아래 문법이 자주 사용된다.
 * 람다를 리시버의 멤버 함수(혹은 메소드)처럼 사용할 수 있다.
 */
"Hello".printIt(6)