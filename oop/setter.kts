// 속성과 파라미터는 자바처럼 this.color같은 것을 붙이는 것보단
// 다른 이름을 사용하도록 하자.
// yearOfMake는 속성이지만 theColor는 필드가 아니다. 단순 파라미터다.
// 이 파라미터에는 val이나 var를 사용하지 않았다.
class Car(val yaerOfMake: Int, theColor: String) {
    var fuelLevel = 100
    var color = theColor
    set(value) {
        if (value.isBlank()) {
            throw RuntimeException("no empty, please")
        }
        field = value
    }
}

val car = Car(2019, "Red")
car.color = "Green"
car.fuelLevel--
println(car.fuelLevel)  //99
try {
    car.color = ""
} catch(ex: Exception) {
    println(ex.message) //no empty, please
}
println(car.color)