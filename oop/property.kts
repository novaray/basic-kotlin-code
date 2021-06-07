// 생성자가 정수형 파라미터를 받도록 만들었다.
// 단 한 줄의 코드로 yaerOfMake라는 이름으로 Int 타입의 읽기전용 속성을 만들었다.
// 코틀린 컴파일러는 생성자를 작성했고, 필드를 정의하고,
// 해당 필드에 접근하게 해주는 getter를 추가했다.
class Car(val yearOfMake: Int)

// 위의 한 줄은 아래의 내용을 축약해서 적은 것이다.
//public class Car public constructor(public val yearOfMake: Int)

val car = Car(2019)
println(car.yearOfMake) //2019