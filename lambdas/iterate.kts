/**
 * 화살표의 왼쪽은 함수가 받을 인풋 타입을 나타내고, 화살표의 오른쪽은 리턴 타입을 나타낸다.
 * 이 코드는 동작하지만 약간 읽기 어렵다. 파라미터를 재정리해 함수를 향상시킬 수 있다.
 */
//fun walk1To(action: (Int) -> Unit, n: Int) = (1..n).forEach { action(it) }
//walk1To({ i -> print(i) }, 5) //12345

/**
 * 람다 파라미터는 제일 마지막으로 보낸다. 람다가 한 줄 이상의 코드일 경우 훨씬 더 읽기 어렵기 때문이다.
 */
//fun walk1To(n: Int, action: (Int) -> Unit) = (1..n).forEach { action(it) }

/**
 * 첫 번째와 같이 쓸 수 있지만 두 번째처럼 더 잘 읽히게 바꿀 수도 있다.
 * 콤마를 제거하고, 람다를 괄호 밖에 놓는다.
 */
//walk1To(5, { i -> print(i) })
//walk1To(5) { i -> print(i) }    //이전 호출보다는 간단해보인다. 멀티라인 람다면 변화의 의미가 더 크다.
//walk1To(5) { i ->
//    print(i)
//}

/**
 * 한 발자국 더 나아가서 i 대신 암시적 변수 it를 사용할 수도 있다.
 */
//walk1To(5) { print(it) }

/**
 * 파라미터를 다른 함수로 전달하는 것 외에는 아무 동작도 하지 않는다면
 * 패스스루 람다를 파라미터가 전달될 함수의 이름으로 대체할 수 있다.
 * ex) ({ x-> someMethod(x) }) >>> (::someMethod)
 * 중개인을 제거해서 아무런 가치도 더하지 않는 람다를 제거했다.
 * 전반적으로 이해하기도 쉬워지고 작업도 줄어들며 작동 시간도 짧아진다.
 */
fun walk1To(n: Int, action: (Int) -> Unit) = (1..n).forEach(action)

/**
 * walk1To() 함수 호출을 할 때 람다를 제거할 수 있다. 하지만 action과는 다르게 함수 print()는 람다가 아니다.
 * 함수가 람다에 적합하다면 함수이름 앞에 ::를 붙인다.
 */
walk1To(5) { i -> print(i) }
walk1To(5, ::print)

walk1To(5) { i -> System.out.println(i) }
walk1To(5, System.out::println)

/**
 * println()은 System.out 인스턴스에서 호출되었다.
 * 참조는 암시적 리시버인 this가 될 수 있다. 만약 암시적 리시버인 this를 사용한 상황이라면
 * 람다를 this의 함수 레퍼런스로 대체 할 수 있다. 아래 예제에서 send()는 암시적 리시버인 this를 사용한다.
 */
fun send(n: Int) = println(n)
walk1To(5) { i -> send(i) }
walk1To(5, this::send)

/**
 * 같은 구조가 싱글톤에서 함수를 사용할 때 사용된다.
 */
object Terminal {
    fun write(value: Int) = println(value)
}
walk1To(5) { i -> Terminal.write(i) }
walk1To(5, Terminal::write)