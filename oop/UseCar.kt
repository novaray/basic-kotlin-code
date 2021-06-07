fun useCarObject(): Pair<Int, String> {
    val car = Car(2019, "Red")
    var year = car.yearOfMake
    car.color = "Green"
    val color = car.color
    return year to color
}

// 위의 코드를 커맨드를 이용해서 바이트코드를 생성하면
// '필드에 직접 접근할 수 없다'고 나온다. 코드는 JavaBean 컨벤션을
// 잘 따르고 있고 캡슐화를 깨뜨리지 않는다.
// 코틀린에선 getter, setter 대신 속성의 이름을 이용해서 속성에 접근할 수 있다.
