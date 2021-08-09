data class Point(val x: Int, val y: Int)
data class Circle(val cx: Int, val cy: Int, val radius: Int)

fun Circle.contains(point: Point) = (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) <
        radius * radius

val circle = Circle(100, 100, 25)
val point1 = Point(110, 110)
val point2 = Point(10, 110)
/**
 * Circle에는 contains() 메소드가 없지만 Circle클래스의 인스턴스에서 해당 메소드를 호출할 수 있다.
 * 코틀린의 확장 함수는 패키지의 static 메소드로 만들어진다. 그리고 컨텍스트 객체를 함수의 첫 번째 파라미터로 전달하고,
 * 이어서 실제 파라미터를 전달한다.
 * 짧게 말하면 확장 함수를 사용할 때 메소드 호출로 보이는 과정은 사실은 static 메소드를 호출하는 과정과 동일하다.
 * 확장 함수는 한계를 가지고 있다. 확장 함수와 인스턴스 메소드가 같은 이름을 가지고 있어서 충돌을 일으키면,
 * 항상 인스턴스 메소드가 실행된다. 또한 객체에 보이는 부분(public 메소드 혹은 속성)에만 접근 가능하다.
 */
println(circle.contains(point1))    //true
println(circle.contains(point2))    //false

/**
 * 확장 속성 역시 추가할 수 있다. 확장 속성은 클래스 내부에 존재하는 것이 아니기 때문에, 백킹 필드를 가질 수 없다.
 * 즉, 확장 속성은 field에 접근할 수 없다.
 */
val Circle.area:Double get() = kotlin.math.PI * radius * radius

// 객체의 사용자 관점에서, 확장 속성을 실제 속성처럼 사용할 수 있다.
val circle2 = Circle(100, 100, 25)
println("Area is ${circle2.area}")  //1963.49...