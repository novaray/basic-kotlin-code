// data class는 특정한 행동, 동작보다는 데이터를 옮기는 데 특화된 클래스다.
// 주 생성자에는 val이나 var를 사용한 속성 정의가 적어도 하나 이상이 필요하다.
// val이나 var가 아닌 파라미터는 사용할 수 없다.
// 코틀린은 자동으로 equals(), hashCode(), toString() 메소드를 만들어준다.
// 인스턴스를 복사해 주는 copy()메소드도 제공한다.
// 주 생성자에 의해서 정의된 각각의 속성에 접근할 수 있게 해주는 메소드인 이름이 component로 시작되는
// 특별한 메소드도 제공한다(통칭 componentN).
data class Task(val id: Int, val name: String,
                val completed: Boolean, val assigned: Boolean)

val task1 = Task(1, "Create Project", false, true)
println(task1)  //Task(id=1, name=Create Project, completed=false, assigned=true)
println("Name: ${task1.name}")  //Name: Create Project

// 프리미티브와 참조에 대한 쉘로우 카피만 가능하고 객체 내부의 참조들은 딥카피되지 않는다.
val task1Completed = task1.copy(completed = true, assigned = false)
println(task1Completed) //Task(id=1, name=Create Project, completed=true, assigned=false)

// 구조분해를 하지않으면 다음과 같은 많은 코드 라인이 필요하다.
/*val id = task1.id
val isAssigned = task1.assigned
println("Id: $id Assigned: $isAssigned")*/

// javascript 객체 구조분해는 속성 이름에 기반하지만, 슬프게도 코틀린의 경우는
// 주 생성자에 전달되는 프로퍼티 순서에 기반한다.
// component1(), component4() 메소드 호출
val (id, _, _, isAssigned) = task1
println("Id: $id Assigned: $isAssigned")