// inline 클래스는 아직 실험적(2021.01)
// 책에서는 아래의 코드로 예시를 짰지만 inline modifier는
// deprecated되서 밑의 코드처럼 써야된다.
/*inline class SSN(val id: String)
fun receiveSSN(ssn: SSN) {
    println("Received $ssn")
}*/

// 아직은(2021.06) @JvmInline 어노테이션을 붙여야 하며
// inline -> value modifier를 붙이는 걸로 바뀌었다.
@JvmInline
value class SSN(val id: String)
fun receiveSSN(ssn: SSN) {
    println("Received $ssn")
}