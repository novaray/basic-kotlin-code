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

/*
* 잘 동작하지만 이 디자인에는 문제점이 존재한다. Manager 클래스는 JavaProgrammer 클래스에 갇혀버린다.
* 이제 Manager에서는 CsharpProgrammer 클래스가 제공하는 구현을 사용할 수 없다.
* */
class Manager : JavaProgrammer()

val doe = Manager()
doe.work()  //...write Java...

/*
* Manager가 JavaProgrammer나 특정 언어의 프로그래머라고 얘기한 적이 없지만 상속이 그렇게 만들어버렸다.
* 의도된 디자인은 아니지만, 막을 방도가 없다. 원래 의도했던 바는 JavaProgrammer뿐만 아니라
* 작업을 맡길 수 있는 모든 Worker에게 Manager가 의존하는 것이다.
* 이건 상속이 아니라 델리게이션에서 가능하다.
* */
val coder: JavaProgrammer = doe