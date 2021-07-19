/**
 * 뮤터블리티는 함수형 프로그래밍의 금기사항이다.
 * 클로저에서 뮤터블 변수를 사용하는 것은 에러의 원인이 되기도 하기 때문에 사용을 피해야 한다.
 * 클로저를 순수한 함수로 놔주는 것이 좋다.
 */
var factor = 2
val doubled = listOf(1, 2).map { it * factor }
val doubledAlso = sequenceOf(1, 2).map { it * factor }
factor = 0
doubled.forEach { println(it) }
doubledAlso.forEach { println(it) }