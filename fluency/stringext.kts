/**
 * 이미 존재하는 메소드로 확장 함수를 라우팅할 수 있다.
 * 아래는 java.lang.String클래스에 확장함수를 추가한 것이다.
 * 코틀린의 확장 함수인 reversed()를 이용해서 현재 주어진 문자열이 palindrome인지 결정한다.
 */
fun String.isPalindrome(): Boolean {
    return reversed() == this
}

/**
 * 단일표현식(single line expression)도 사용 가능.
 */
fun String.shout() = uppercase()

val str = "dad"
println(str.isPalindrome()) //true
println(str.shout())    //DAD