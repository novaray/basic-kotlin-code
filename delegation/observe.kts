/**
 * observable()이란 함수는 연관된 변수나 속성의 변화를 가로채는 ReadWriteProperty 델리게이션을 만든다.
 * 변화가 발생하면 델리게이션이 개발자가 observable() 함수에 등록한 이벤트 핸들러를 호출한다.
 * 핸들러는 속성, 이전 값, 새로운 값에 대한 메타데이터를 가지고 있는 KProperty 타입의 파라미터 3개를 받는다.
 * 아무것도 리턴하지 않는다(Unit 혹은 void).
 */
import kotlin.properties.Delegates.observable

//초기화 값으로 0을 줌.
var count by observable(0) { property, oldValue, newValue ->
    println("Property: $property old: $oldValue: new: $newValue")
}
println("The value of count is: $count")
count++
println("The value of count is: $count")
count--
println("The value of count is: $count")
