// 익명 객체를 이용하여 그룹핑 할 수 있다.
// 익명 객체의 내부 타입은 함수나 메소드의 리턴타입, 파라미터가 될 수 없다.
// 클래스 안에 저장된 속성들이 있다면 해당 속성들은 Any로 간주된다. 그러면 모든 속성이나 메소드에 직접 접근할 수 없게 된다.
fun drawCircle() {
    val circle = object {   //an expression
        val x = 10
        val y = 20
        val radius = 30
    }
    //Pass circle.x, circle.y, circle.radius to a draw function here
    println("Circle x: ${circle.x}, y: ${circle.y}, radius: ${circle.radius}")
    //Circle x: 10, y: 20, radius: 30
}
drawCircle()