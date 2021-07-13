/**
 * 명령형 스타일은 복잡하고 읽기 어렵다. 이런 이유 중 하나는 변화하는 부분이 너무 많기 때문이다.
 */
//var doubleOfEven = mutableListOf<Int>()
//for (i in 1..10) {
//    if (i % 2 == 0) {
//        doubleOfEven.add(i * 2)
//    }
//}

/**
 * 뮤터블 리스트를 만들고 값을 반복적으로 추가하는 대신 코드에서 로직의 흐름을 볼 수 있다.
 * 결과는 값들의 이뮤터블 리스트가 된다. 코드를 실행하는 동안 뮤터블한 변수를 하나도 사용하지 않았다.
 */
val doubleOfEven = (1..10)
        .filter { e -> e % 2 == 0 }
        .map { e -> e * 2 }
println(doubleOfEven)   //[4, 8, 12, 16, 20]


