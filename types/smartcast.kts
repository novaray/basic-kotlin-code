class Animal(val age: Int) {
/*    override operator fun equals(other: Any?): Boolean {
        return if (other is Animal) age == other.age else false
    }*/
    //스마트 캐스트는 if문뿐만 아니라 || 혹은 && 연산자 이후에도 작동한다.
    //다음 코드는 위의 equals()를 리팩토링 한 것이다.
    override operator fun equals(other: Any?) = other is Animal && age == other.age
}

val odie = Animal(2)
val toto = Animal(2)
val butch = Animal(3)
println(odie == toto)    //true
println(odie == butch)   //false

