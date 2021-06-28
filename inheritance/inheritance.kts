/*
* 인터페이스와 다르게, 코틀린의 클래스는 디폴트가 final이다.
* open이라고 명시되어있는 클래스로부터만 상속을 받을 수 있다.
* 자식 클래스는 open으로 명시한 열려있는 클래스의 열려있는 메소드만 오버라이드할 수 있고,
* 자식 클래스에선 override라고 명시를 해줘야 한다.
* 속성도 오버라이드 할 수 있다. val로 정의된 속성은 오버라이드 할 때 val, var둘 다 가능하지만
* var로 정의된 속성은 var로만 오버라이드 할 수 있다. 왜냐하면 val은 getter만 가지고 있다.
* */
open class Vehicle(val year: Int, open var color: String) {
    open val km = 0
    final override fun toString(): String = "year: $year, ColorL $color, KM: $km"
    fun repaint(newColor: String) {
        color = newColor
    }
}

/*
* Java와는 다르게, 코틀린은 implements와 extends를 구분하지 않는다. 그냥 상속이라고 표현한다.
* */
open class Car(year: Int, color: String) : Vehicle(year, color) {
    override var km: Int = 0
        set(value) {
            if (value < 1) {
                throw RuntimeException("can't set negative value")
            }
            field = value
        }
    fun drive(distance: Int) {
        km += distance
    }
}

val car = Car(2019, "Orange")
println(car.year)   //2019
println(car.color)  //Orange
car.drive(10)
println(car)    //year: 2019, Color: Orange, KM: 10
try {
    car.drive(-30)
} catch(ex: RuntimeException) {
    println(ex.message) //can't set negative value
}

class FamilyCar(year: Int, color: String) : Car(year, color) {
    override var color: String
        get() = super.color
        set(value) {
            if (value.isEmpty()) {
                throw RuntimeException("Color required")
            }
            super.color = value
        }
}

val familyCar = FamilyCar(2019, "Green")
println(familyCar.color)    //Green
try {
    familyCar.repaint("")
} catch (ex: RuntimeException) {
    println(ex.message) //Color Required
}