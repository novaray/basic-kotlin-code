data class Point(val x: Int, val y: Int)
data class Circle(val cx: Int, val cy: Int, val radius: Int)

/**
 * 확장 함수 역시 연산자가 될 수 있다. 단순히 확장 함수 앞에 operator 키워드를 붙여주면 된다.
 * cotains() 메소드도 사용 가능하다.
 */
operator fun Circle.contains(point: Point) = (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) <
        radius * radius

val circle = Circle(100, 100, 25)
val point1 = Point(110, 110)
val point2 = Point(10, 110)
println(circle.contains(point1))    //true
println(point1 in circle)    //true
println(point2 in circle)    //false

