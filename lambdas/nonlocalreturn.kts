fun invokeWith(n: Int, action: (Int) -> Unit) {
    println("enter invokeWith $n")
    action(n)
    println("exit invokeWith $n")
}

/**
 * 논로컬 리턴은 람다와 함께 구현된 현재 함수에서 나갈 때 유용하다.
 */
fun caller() {
    (1..3).forEach { i ->
        println("in forEach for $i")
        /*
            현재 람다를 빠져나가는 라벨 리턴과는 달리 아랫줄의 리턴은 현재 실행 중인 함수를
            빠져나간다. 이걸 논로컬 리턴이라 부른다.
         */
        if (i == 2) { return }
        invokeWith(i) {
            println("enter for $it")
            if (it == 2) {
                return@invokeWith
            }
            println("exit for $it")
        }
    }
    println("end of caller")
}
caller()
println("after return from caller")

/**
 * 왜 에러가 안나는 것인가? invokeWith()함수와 코틀린 스탠다드 라이브러리의 forEach() 함수를 보면 다음과 같다.
 * fun invokeWith(n: Int, action: (Int) -> Unit) { ...
 * inline fun <T> Iterable<T>.forEach(action: (T) -> kotlin.Unit): kotlin.Unit { ...
 * 답은 inline 키워드에 있다(논로컬 리턴은 람다를 받는 함수가 inline으로 선언된 경우만 가능).
 */
