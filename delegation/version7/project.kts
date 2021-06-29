interface Worker {
    fun work()
    fun takeVaction()
    fun fileTimeSheet() = println("Why? Really?") //오바라이드 없이 바로 사용 가능
}

interface Assistant {
    fun doChores()
    fun fileTimeSheet() = println("No escape from that") //오바라이드 없이 바로 사용 가능
}

class DepartmentAssistant : Assistant {
    override fun doChores() = println("routine stuff")
}

open class JavaProgrammer : Worker {
    override fun work() = println("...write Java...")
    override fun takeVaction() = println("code at the beach...")
}
class CsharpProgrammer : Worker {
    override fun work() = println("...write C#...")
    override fun takeVaction() = println("branch at the ranch...")
}

class Manager(val staff: Worker, val assistant: Assistant) :
        Worker by staff, Assistant by assistant {

    override fun takeVaction() = println("of course")

    // 아래 메소드를 오버라이드 하지 않았다면 두 인터페이스에 모두 포함되어 있는 메소드의 충돌 때문에 컴파일 오류 발생.
    override fun fileTimeSheet() {
        print("manually forwarding this...")
        assistant.fileTimeSheet()
    }
}

val doe = Manager(CsharpProgrammer(), DepartmentAssistant())
doe.work()  //...write C#...
doe.takeVaction() //of course
doe.doChores()  //routine stuff
doe.fileTimeSheet() //manually forwarding this..No escape from that