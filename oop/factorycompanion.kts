// 컴패니언을 팩토리로 사용하기 위해서는 클래스에 private 생성자를 만들어야 한다.
// 클래스 외부에서 어떤 인스턴스도 직접 생성할 수 없다.
// create(name) 메소드로 생성해야한다.

class MachineOperator private constructor(val name: String) {
    fun checkin() = checkedIn++
    fun checkout() = checkedIn--

    companion object {
        var checkedIn = 0
        fun minimumBreak() = "15 minutes every 2 hours"
        fun create(name: String): MachineOperator {
            val instance = MachineOperator(name)
            instance.checkin()
            return instance
        }
    }
}

// static 접근처럼 보이겠지만 그렇게 생각하면 안 된다.
// 코틀린 컴파일러는 컴패니언 객체의 멤버에 접근하면 싱글톤 객체로 라우팅한다.
// Java와의 상호 운용성 측면에서 봤을 때 이런 동작은 문제를 야기할 수 있다.

val operator = MachineOperator.create("Mater")
println(MachineOperator.checkedIn)