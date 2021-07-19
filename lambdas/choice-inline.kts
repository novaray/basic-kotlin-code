/**
 * 람다 호출을 최적화하지 않고 싶다면, 람다의 파라미터를 noinline으로 표시하여 최적화를 제거할 수 있다.
 * noline 키워드는 함수가 inline인 경우에만 파라미터에 사용할 수 있다.
 * action1에 전달된 람다에는 논로컬 리턴과 라벨 리턴을 허용하지만,
 * action2에 전달된 람다에는 라벨 리턴만 허용한다.
 * 인라인 람다는 함수 내에서 확장되지만, 인라인이 아닌 람다는 다른 함수 호출을 사용하기 때문이다.
 */
inline fun invokeTwo(
        n: Int,
        action1: (Int) -> Unit,
        noinline action2: (Int) -> Unit
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
 * action2는 최적화에서 제외되었기 때문에 호출 시 action1보다 action2의 콜스택이 더 깊다.
 */
callInvokeTwo()