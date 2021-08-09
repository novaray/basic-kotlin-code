/**
 * 연산자를 오버로딩할 때는 지켜야 할 규칙이 있다. 개발자는 연관된 연산자의 동작의 관행을 따라야 한다.
 * 예를 들어서 +나 - 연산자를 오버로딩할 때 객체를 변경(mutable)하면 안 된다.
 * 이런 규칙은 객체를 변경시키는 연산자에도 적용된다.
 */
class Counter(val value: Int) {
    operator fun inc() = Counter(value + 1)
    operator fun dec() = Counter(value - 1)
    override fun toString() = "$value"
}

var counter = Counter(2)
println(counter)    //2
println(++counter)  //3
println(counter)    //3
println(counter++)  //3
println(counter)    //4

/**
 * 연산자 오버로딩은 강력한 기능이지만 아래의 추천사항을 따른다.
 * 절제하여 사용하라.
 * 코드를 읽는 사람 입장에서 당연하게 받아들여질 경우에만 사용하라.
 * 오버로딩된 연산자는 일반적인 연산자의 동작이어야 한다.
 * 변수이름을 의미있게 만들어라. 그래야 오버로딩의 문맥을 파악하기 좋다.
 */