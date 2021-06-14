// init 블록은 여러 개를 정의할 수 있지만 반드시 init 블록을 정의하라는 뜻은 아니다.
// 클래스 안에서 첫 번째로 속성을 가장 위에 정의하도록 하고,
// 그 후에 init블록을 작성해야한다(필요한 경우에 한해서).
// 그리고 보조(Secondary) 생성자를 구현하도록 한다(필요한 경우에 한해서)
// 가장 마지막으로 필요한 메소드를 작성하면 된다.
class Car(val yearOfMake: Int, theColor: String) {

//    var fuelLevel = if (yearOfMake < 2020) 90 else 100
    var fuelLevel = 100
    private set
    var color = theColor
    set(value) {
        if (value.isBlank()) {
            throw RuntimeException("no empty, please")
        }
        field = value
    }
    // init 블록이 아니라 fuelLevel을 정의하는 시점에 처리하려면 위 주석처럼하면된다.
    // 가급적 init 블록은 1개만 만들고, 가능하다면 1개도 만들지 말라.
    // 생성자에서 최대한 아무런 작업도 안 하는 것이 프로그램의 안정성과 퍼포먼스 측면 모두에서
    // 더 장점이 크다.
    init {
        if (yearOfMake < 2000) {
            fuelLevel = 90
        }
    }
}
