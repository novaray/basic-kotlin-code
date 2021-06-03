fun createRunnable(): Runnable {
    val runnable = object: Runnable {
        override fun run() { println("You called...") }
    }
    return runnable
}

val aRunnable = createRunnable()
aRunnable.run() //You called...

// 위의 코드를 싱글 추상 메소드 인터페이스(Single abstract method interface. Java8의 함수형 인터페이스)
// 라면 다음과 같이 메소드 이름을 명명하지 않고 바로 구현할 수도 있다.
fun createRunnable2(): Runnable = Runnable { println("You called2...") }

val aRunnable2 = createRunnable2()
aRunnable2.run()

// 둘 이상의 인퍼테이스를 구현해야 한다면 리턴이 필요한 경우에는
// 반드시 리턴할 인스턴스 타입을 명시해줘야 한다.
fun createRunnable3(): Runnable = object: Runnable, AutoCloseable {
    override fun run() { println("You called2...") }
    override fun close() { println("closing...") }
}