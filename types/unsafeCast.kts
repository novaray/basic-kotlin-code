fun fetchMessage(id: Int): Any = if (id == 1) "Record found" else StringBuilder("data not found")

//as를 이용해서 캐스팅하는 것은 결과가 안 좋을 게 뻔하다. 실행 시간 예외가 발생한다.
//for (id in 1..2) {
//    println("Message length: ${(fetchMessage(id) as String).length}")
//}

//as 연산자는 우측에 지정된 타입과 같은 타입을 결과로 준다.
val message: String = fetchMessage(1) as String
//as?는 null 가능 참조 타입을 결과로 지닌다.
val message2: String? = fetchMessage(1) as? String

//as연산자는 캐스팅이 실패하면 죽는데 반해서
//안전한 캐스트 연산자인 as?는 캐스팅이 실패하면 null을 할당한다.
//---

// 위의 코드를 안전하게 바꾼 예이다.
for (id in 1..2) {
    println("Message length: ${(fetchMessage(id) as? String)?.length ?: "---"}")
}