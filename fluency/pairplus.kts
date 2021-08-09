/**
 * 연산자를 오버로딩하기 위해서, 함수는 operator 키워드로 정의되어 있어야 한다.
 * 아래는 Pair<Int, Int>에 + 연산자를 오버로딩해서 숫자 페어를 더하는 예제이다.
 */
operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>) = Pair(first + other.first, second + other.second)

