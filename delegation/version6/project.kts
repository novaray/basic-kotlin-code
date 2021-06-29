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
    /**
     * override 키워드를 사용했기 때문에, 인터페이스의 메소드를 구현했다.
     * 코틀린 컴파일러는 takeVaction() 메소드의 랩퍼를 생성하지 않고 work()메소드의 랩퍼만 생성한다.
     */
    override fun takeVaction() = println("of course")
}

val doe = Manager(CsharpProgrammer())
doe.work()  //...write C#...
doe.takeVaction()   //of couse