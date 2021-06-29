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
* by 키워드로 델리게이션을 대신 해준다. by 키워드의 왼쪽에는 인터페이스가, 오른쪽엔 인터페이스를 구현한 클래스가 필요.
* */
class Manager() : Worker by JavaProgrammer()

val doe = Manager()
/*
* 코틀린의 델리게이션을 사용하면, 컴파일러가 내부적으로 Manager 클래스에 메소드를 생성하고 요청(라우팅)을 한다.
* 사실상 doe.work()를 호출할 때, Manager 클래스의 보이지 않는 메소드인 work()를 호출하는 격이다.
* */
doe.work()  //...write Java...

//상속을 받는 것은 아니다.
val coder: JavaProgrammer = doe //ERROR: type mismatch

