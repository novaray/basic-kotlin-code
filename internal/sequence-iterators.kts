data class Person(val firstName: String, val age: Int)
val people = listOf(
        Person("Sara", 12),
        Person("Jill", 51),
        Person("Paula", 23),
        Person("Paul", 25),
        Person("Mani", 12),
        Person("Jack", 70),
        Person("Sue", 10))

fun isAdult(person: Person): Boolean {
    println("is Adult called for ${person.firstName}")
    return person.age > 17
}
fun fetchFirstName(person: Person): String {
    println("fetchFirstName called for ${person.firstName}")
    return person.firstName
}

/**
 * 시퀀스를 사용하지 않으면 실행이 종료되기까지 많은 작업을 수행한다.
 */
val nameOfFirstAdult = people
        .filter(::isAdult)
        .map(::fetchFirstName)
        .first()
println(nameOfFirstAdult)

/**
 * 작은차이지만 asSequence() 메소드를 사용함으로써 성능상에 큰 이득이 있다.
 * filter() 메소드가 adults 리스트를 생성하지 않고 시퀀스에서 호출을 하면 다른 시퀀스를 리턴한다.
 * 이와 유사하게 시퀀스에서 map()을 호출하면 다른 시퀀스를 리턴한다.
 * 하지만 filter()나 map()에 전달된 람다는 아직 실행되지 않는다.
 * first() 메소드가 호출될 때 지금까지 연기됐던 실행이 시작된다.
 * first()같은 마지막 메소드는 연산의 파이프라인의 실행 결과를 리턴해준다.
 */
val nameOfFirstAdult2 = people.asSequence()
        .filter(::isAdult)
        .map(::fetchFirstName)
        .first()
println(nameOfFirstAdult2)