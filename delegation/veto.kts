/**
 * 변경을 허가할 지, 불허할지 결정할 수 있는 vetoable 델리게이션.
 * vetoable 핸들러를 등록하면 Boolean 결과를 리턴받을 수 있다.
 * true를 리턴하면 변경을 허가한다는 뜻이고, false라면 변경을 불허한다.
 */
import kotlin.properties.Delegates.vetoable

var count by vetoable(0) { _, oldValue, newValue -> newValue > oldValue }
println("The value of count is: $count")
count++
println("The value of count is: $count")
count--
println("The value of count is: $count")