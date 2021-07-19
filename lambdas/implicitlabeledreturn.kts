fun invokeWith(n: Int, action: (Int) -> Unit) {
    println("enter invokeWith $n")
    action(n)
    println("exit invokeWith $n")
}

/**
 * 명시적인 라벨(return@invokeWith) 사용.
 * 비록 메소드 이름을 라벨로 사용할 수 있지만, 명시적 라벨을 사용하는 걸 권장한다.
 * 명시적 라벨이 의도를 명확하게 보이게 하고 코드를 쉽게 이해할 수 있게 도와준다.
 * 컴파일러는 라벨 리턴이 스코프 바깥의 임의의 곳을 향하지 못하도록 막는다.
 */
fun caller() {
    (1..3).forEach { i ->
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