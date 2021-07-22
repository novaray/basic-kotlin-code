val numbers = listOf(10, 12, 15, 17, 18, 19)
/**
 * 반복 진행에 따라서 각 연산마다 변수 i는 콜렉션의 다른 값들을 가지게 된다.
 * if식이 현재 i가 가지고 있는 값이 짝수인지를 확인한다. 그리고 현재 i값이 짝수라면 값을 출력한다.
 * 이게 외부 반복이다.
 */
for (i in numbers) {
    if (i % 2 == 0) {
        print("$i, ")
    }
}

/**
 * 내부반복자 사용. 코틀린 스탠다드 라이브러리는 콜렉션에 몇 가지 확장 함수를 추가했다.
 * 다음은 filter()와 forEach() 함수를 사용했다.
 */
numbers.filter { e -> e % 2 == 0 }
        .forEach { e -> print("$e, ") }

/**
 * 냄새가 나는 첫 번째 부분은 빈 뮤터블 리스트를 정의.
 * 두 번째로 반복문 안에서 두 배로 만든 짝수를 리스트에 넣고 있다.
 */
val doubled = mutableListOf<Int>()
for (i in numbers) {
    if (i % 2 == 0) {
        doubled.add(i * 2)
    }
}
println(doubled)    //[20, 24, 36]

/**
 * 다음은 내부 반복자를 사용해서 구현한 버전이다.
 * map() 함수는 새 콜렌션을 만들어준다. 내부 반복자는 함수형 파이프라인에서 나온다.
 * 코틀린의 외부 반복자도 좋다. 하지만 내부 반복자가 더 뛰어나다.
 */
val doubledEven = numbers.filter { e -> e % 2 == 0 }
        .map { e -> e * 2 }
println(doubledEven)    //[20, 24, 36]