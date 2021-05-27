class Animal {
    override operator fun equals(other: Any?) = other !is Animal
}

val greet: Any = "hello"
val odie: Any = Animal()
val toto: Any = Animal()
// 소스 코드에서 발견되는 타입 불일치 때문에 동등성 검사를 하지 않는 걸 회피하기 위해
// Any로 선언을 해서 타입체크를 회피했다.
println(odie == greet)  //false
println(odie == toto)   //true

//코틀린은 1+1 정책을 사용하므로 !is 연산자는 덤으로 쓸 수 있다.