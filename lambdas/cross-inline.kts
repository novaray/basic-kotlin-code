/**
 * 람다가 호출될지 안 될지 모를 때 인라인으로 만들고 싶다면 호출한 쪽으로 인라인으로 전달하도록
 * 함수에게 요청할 수 있다. 바로 크로스인라인이다.
 */

/**
 * invokeTwo()가 action2를 직접 호출하지 않기 때문에 마지막 줄의
 * 람다에 포함된 action2(input)은 인라인이 될 수 없다.
 * 하지만 crossinline 키워드를 붙이면 action2함수는 invokeTwo()함수가 아니고 호출되는 부분에서 인라인이 된다.
 * crossinline인 람다 파라미터에는 논로컬 리턴을 사용할 수 없다.
 * 람다가 실행될 때까지 파라미터로 전달된 함수로부터 빠져나갔을 수도 있기 떄문이다. 이미 완료된 함수에서 리턴을 하려고 하는 것은 의미가 없다.
 */
inline fun invokeTwo(
        n: Int,
        action1: (Int) -> Unit,
//        action2: (Int) -> Unit  //ERROR
        crossinline action2: (Int) -> Unit
): (Int) -> Unit {
    println("enter invokeTwo $n")
    action1(n)
    println("exit invokeTwo $n")
    return { input:Int -> action2(input) }
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