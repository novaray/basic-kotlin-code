val names = listOf("Pam", "Pat", "Paul", "Paula")

/**
 * String을 파라미터로 받는 람다를 참조하고 있다. 이 람다의 리턴타입은 코틀린이 추론한다.
 */
//val checkLength5 = { name: String -> name.length == 5 }

/**
 * 잘못된 예1
 * 람다가 리턴하는 타입이 변수에 지정해놓은 타입과 다르다면 컴파일 에러가 발생한다.
 */
//val checkLength5 = (String) -> Boolean = { name -> name.length == 5 }

/**
 * 잘못된 예2
 * 변수와 람다 모두에 타입을 지정해 놓는 것.
 */
//val checkLength5 = (String) -> Boolean = { name: String -> name.length == 5 }

/**
 * 람다의 리턴타입을 고정하고 싶을 떄는 변수에 타입을 정의하고,
 * 리턴타입을 추론타입으로 사용하고 싶다면 람다의 파라미터에 타입을 정의한다.
 * 람다가 할당될 변수의 타입을 정의한다면 반드시 리턴타입을 지정해야 한다.
 * 람다의 파라미터 타입을 지정한다면 리턴타입은 타입 추론이 된다.
 */

/**
 * 또 다른 옵션으로 변수의 타입은 타입추론을 사용하고, 리턴타입만 지정하는 방법이 있는데 이게 바로 익명함수다.
 * 익명 함수는 일반 함수처럼 작성한다. 그래서 리턴타입을 지정하는 규칙이 적용된다.
 * 차이점은 익명 함수에는 이름이 없다라는 점밖에 없다.
 */
val checkLength5 = fun(name: String): Boolean { return name.length == 5 }
println(names.find(checkLength5))   //Paula

/**
 * 아규먼트에 직접 작성하는 방식
 * 람다보다 장황해서 특정 소수의 예외적인 상황을 제외하면 람다 대신 익명 함수를 사용할 이유가 없다.
 */
names.find(fun(name: String): Boolean { return name.length == 5 })

