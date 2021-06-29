interface Worker {
    fun work()
    fun takeVaction()
}

class JavaProgrammer : Worker {
    override fun work() = println("...write Java...")
    override fun takeVaction() = println("code at the beach...")
}
class CsharpProgrammer : Worker {
    override fun work() = println("...write C#...")
    override fun takeVaction() = println("branch at the ranch...")
}

// Java방식 델리게이션을 코틀린 코드로 표현.
class Manager(val worker: Worker) {
    fun work() = worker.work()
    fun takeVacation() = worker.work()  //그렇다. 쉬는 게 쉬는 게 아니다.
}

/*
* 장점1. Manager가 Worker 인터페이스를 구현한 클래스의 인터페이스라면 어떤 인터페이스든 넘길 수 있다.
* 장점2. JavaProgrammer 클래스가 더 이상 상속을 해주지 않기 때문에 open 키워드를 입력할 필요 X
* 하지만 이런 디자인은 바람직하지 못하다. 코드가 장황할 뿐만 아니라, 소프트웨어 디자인의 기본사항 몇 가지도 어긴다.
* DRY(Don't Repeat Yourself, 반복하지 말 것), 개방-폐쇄원칙(OCP)지키지 못함.
* */
val doe = Manager(JavaProgrammer())
doe.work()  //...write Java...
