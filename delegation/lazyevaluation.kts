fun getTemperature(city: String): Double {
    println("fetch from webservice for $city")
    return 30.0
}

val showTemperature = false
val city = "Boulder"

/**
 * 개발자는 직접 컴파일러에게 식의 결과가 정말로 필요하기 전까지는 식을 실행하지 않도록
 * 지연 연산을 요청할 수 있다.
 * Lazy 델리게이션 클래스를 직접 사용하는 대신 편리한 lazy 랩퍼 함수를 사용한다.
 * temperature를 by키워드를 사용해서 델리게이션 속성으로 변경했다.
 * 참고: LazyThreadSafetyMode아규먼트를 lazy함수로 전달해서 다른 종류의 동기화 옵션을 선택할 수 있다.
 */
val temperature by lazy { getTemperature(city) }
// 이 예제에서는 영원히 실행되지 않는다.
if (showTemperature && temperature > 20)
    println("Warm")
else
    println("Nothing to report")    //Nothing to report