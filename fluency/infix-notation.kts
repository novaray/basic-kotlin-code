/**
 * if (obj instanceof String) {
 * 이렇게 연산자가 중간에 있거나 피연산자 사이에 있는 것을 중위표기법(infix notation)이라고 부른다.
 * 이런 문법은 아주 좋다(ex. if (obj.instanceOf(String) ).
 * 자바에서는 이미 정의된 연산자에서만 제한적으로 사용이 가능하지만 코틀린에서는 코드에 사용할 수 있다.
 */

data class Point(val x: Int, val y: Int)
data class Circle(val cx: Int, val cy: Int, val radius: Int)

//operator fun Circle.contains(point: Point) = (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) <
//        radius * radius

val circle = Circle(100, 100, 25)
val point1 = Point(110, 110)
val point2 = Point(10, 110)

/**
 * 코틀린에서 연산자는 항상 자동으로 중위표기법을 사용한다. 하지만 메소드는 기본으로 중위표기를 사용하지 않는다(합리적인 이유가 있다).
 * 꼭 따라야만 하는 것은 아님. 점과 괄호가 없어지면 코드의 표현력이 강해지고, 노이즈가 적어진다.
 * 이런 특징은 DSL을 만들 때 매우 도움이 된다.
 */
//println(circle.contains(point1))    //true
//println(point1 in circle)   //true

/**
 * 메소드에 infix 어노테이션을 사용하면 코틀린은 점과 괄호를 제거하는 것을 허용해준다. infix는 operator와 함께 사용할 수 있다.
 * 그러나 서로 독립적이다.
 */
operator infix fun Circle.contains(point: Point) = (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) <
        radius * radius

println(circle.contains(point1))    //true
println(point1 in circle)   //true
println(circle contains point1) //true