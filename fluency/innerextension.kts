/**
 * Point 클래스에서 Pair<Int, Int>로 확장 함수를 인젝트했다. 그렇기 때문에 클래스 외부에서 Pair<Int, Int>의 확장 함수를
 * 사용하려고 하면 컴파일 에러가 난다.
 * 확장 함수가 클래스 내부에 생성되었기 떄문에 확장 함수에는 this와 this@Point 두개의 리시버를 가지고 있다.
 * 하나는 익스텐션 리시버이고 다른 하나는 디스패치 리시버이다. 익스텐션 리시버는 확장 함수가 실행되는 객체(Pair)이다.
 * 디스패치 리시버는 개발자가 확장 함수를 만들어 추가한 클래스의 인스턴스(Point)이다. 즉, 메소드 인젝션이 된 클래스이다.
 * 익스텐션 리시버가 우선순위가 더 높다.
 * 익스텐션 리시버를 바이패스한 후 디스패치 리시버에 참조를 걸고 싶다면 this@Outer 문법을 사용하면 된다.
 */
class Point(x: Int, y: Int) {
    private val pair = Pair(x, y)
    private val firstsign = if (pair.first < 0) "" else "+"
    private val secondsign = if (pair.second < 0) "" else "+"
    override fun toString() = pair.point2String()
    fun Pair<Int, Int>.point2String() =
        "(${firstsign}${first}, ${this@Point.secondsign}${this.second})"
}

println(Point(1, -3))   //(+1, -3)
println(Point(-3, 4))   //(-3, +4)
