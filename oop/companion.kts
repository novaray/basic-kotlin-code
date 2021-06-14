class MachineOperator(val name: String) {
    fun checkin() = checkedIn++
    fun checkout() = checkedIn--
    // companion 객체는 클래스 안에 정의한 싱글톤이다.
    // 인터페이스를 구현할 수도 있고 다른 클래스를 확장할 수도 있다.
//    companion object {
    //아래와 같이 이름을 준 경우 Companion이라는 이름은 더 이상 사용 불가.
    companion object MachineOperatorFactory {
        var checkedIn = 0
        fun minimumBreak() = "15 minutes every 2 hours"
    }
}

MachineOperator("Mater").checkin()
// 컴패니언 객체의 한 부분인 minimumBreak()같은 메소드는 인스턴스를 이용해서 접근할 수 없다.
// 클래스 이름을 이용해서 접근해야 한다. checkedIn도 마찬가지.
println(MachineOperator.minimumBreak()) //15 minutes every 2 hours
println(MachineOperator.checkedIn)  //1

// 컴패니언 개체 자체의 참조가 필요할 때(ex. 컴패니언 객체가 인터페이스를 구현하고 있는 경우)
// 빈번하게 사용해야한다면 Companion보다는 더 적절한 이름을 주는 게 좋다.
// 이름을 부여하면 Companion이름은 사용 불가다.
//val ref = MachineOperator.Companion

val ref = MachineOperator.MachineOperatorFactory
