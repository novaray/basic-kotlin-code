/**
 * 람다에서 return은 허용되지 않는 게 기본이다. 하지만 특별한 상황에서는 사용할 수 있다.
 */
fun invokeWith(n: Int, action: (Int) -> Unit) {
    println("enter invokeWith $n")
    action(n)
    println("exit invokeWith $n")
}

/**
 * 컴파일 실패.
 * 1. 즉시 람다에서 빠져나오고 invokeWith() 함수의 action(n) 이후의 나머지를 실행하라.
 * 2. for 루프를 빠져나와라.
 * 3. caller() 함수에서 빠져나와라.
 * 이런 혼란을 피하기 위해 코틀린은 return 키워드를 허용하지 않는다.
 * 하지만 예외로 라벨(명시적) 리턴과 논로컬(비지역적)리턴은 예외다.
 */
fun caller() {
    (1..3).forEach { i ->
        invokeWith(i) {
            println("enter for $it")

            if (it == 2) { return } //ERROR, return is not allowed here

            println("exit for $it")
        }
    }

    println("end of caller")
}

caller()
println("after return from caller")