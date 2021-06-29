interface Worker {
    fun work()
    fun takeVaction()
}

open class JavaProgrammer : Worker {
    override fun work() = println("...write Java...")
    override fun takeVaction() = println("code at the beach...")
}
class CsharpProgrammer : Worker {
    override fun work() = println("...write C#...")
    override fun takeVaction() = println("branch at the ranch...")
}

class Manager(val staff: Worker) : Worker by staff {
    fun meeting() = println("organizing meeting with ${staff.javaClass.simpleName}")
}

val doe = Manager(CsharpProgrammer())
val roe = Manager(JavaProgrammer())
doe.work()  //...write C#...
doe.meeting()   //organizing meeting with CsharpProgrammer
roe.work()  //...write Java...
roe.meeting()   //organizing meeting with JavaProgrammer