/**
 * inline 키워드를 이용해서 람다를 받는 함수의 성능을 향상시킬 수 있다.
 * 함수가 inline으로 선언되어있으면 함수를 호출하는 대신 함수의 바이트코드가 함수를
 * 호출하는 위치에 들어가게 된다.
 * 함수 호출의 오버헤드를 제거하지만 함수가 호출되는 모든 부분에 바이트코드가 위치하기 때문에 바이트코드가 커지게 된다.
 * 일반적으로 긴 함수를 인라인으로 사용하는 건 좋은 생각이 아니다.
 */

inline fun invokeTwo(
        n: Int,
        action1: (Int) -> Unit,
        action2: (Int) -> Unit
): (Int) -> Unit {
    println("enter invokeTwo $n")
    action1(n)
    action2(n)
    println("exit invokeTwo $n")
    return { _:Int -> println("lambda returned from invokeTwo") }
}

fun callInvokeTwo() {
    invokeTwo(1, { i -> report(i) }, { i -> report(i) })
}

fun report(n: Int) {
    println("")
    print("called with $n, ")
    val stackTrace = RuntimeException().getStackTrace()
    println("Stack depth: ${stackTrace.size}")
    println("Partial listing of the stack:")
    stackTrace.take(3).forEach(::println)
}

/**
 * 실행하면 inline 어노테이션을 추가하기 전의 콜스택의 상위 3개가 사라졌다.
 * 하지만 inline이 될 함수가 매우 클 경우 그리고 함수를 여러 곳에서 많이 호출하면 어떻게 될까?
 * inline을 사용하지 않을 때에 비해서 바이트코드가 훨씬 커지게 된다.
 */
callInvokeTwo()