fun invokeWith(n: Int, action: (Int) -> Unit) {
    println("enter invokeWith $n")
    action(n)
    println("exit invokeWith $n")
}

/**
 * 현재 람다에서 즉시 나가고 싶다면 라벨 리턴을 사용하면 된다.
 * 라벨 리턴은 return@label 형태로 사용되고.
 * label 자리에는 label@ 문법을 이용해서 만든 라벨을 넣을 수 있다.
 */
fun caller() {
    (1..3).forEach { i ->
        invokeWith(i) here@ {
            println("enter for $it")

            if (it == 2) {
                return@here
            }

            println("exit for $it")
        }
    }

    println("end of caller")
}
caller()
println("after return from caller")