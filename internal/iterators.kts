data class Person(val firstName: String, val age: Int)
val people = listOf(
        Person("Sara", 12),
        Person("Jill", 51),
        Person("Paula", 23),
        Person("Paul", 25),
        Person("Mani", 12),
        Person("Jack", 70),
        Person("Sue", 10))

// 내부 반복자 사용하여 20살 이상인 사람의 이름을 대문자로 바꾸고, 콤마로 구분.
val result = people.filter { person -> person.age >= 20}
        .map { person -> person.firstName }
        // 하나로 합쳐서 사용할 수 있지만, 분리시켜 놓는 것이 코드를 각 라인의 하나의 연산에 집중할 수 있도록 해준다.
        .map { name -> name.uppercase() }
        // joinToString을 사용하면 더 간결하다.
        //.reduce { names, name -> "$names, $name" }
        .joinToString(", ")
println(result) //JILL, PAULA, PAUL, JACK

// 나이를 더한 결과
val totalAge = people.map { person -> person.age }
        .reduce { total, age -> total + age }
// 특화된 sum()사용
val totalAge2 = people.map { person -> person.age }
        .sum()
println(totalAge)   //203
println(totalAge2)   //203

// 첫 번째 성인의 이름 찾기. 17살보다 나이가 큰 것으로 판단.
val nameOfFirstAdult = people.filter { person -> person.age > 17 }
        .map { person -> person.firstName }
        .first()
println(nameOfFirstAdult)   //Jill

// 마지막 성인의 이름 찾기. 17살보다 나이가 큰 것으로 판단.
val nameOfLastAdult = people.filter { person -> person.age > 17 }
        .map { person -> person.firstName }
        .last()
println(nameOfLastAdult)   //Jack

/**
 * flatten()함수에 Iterable<Iterable<T>>를 전달하면 모든 중첩된 반복가능 객체가
 * 탑레벨로 합쳐진 Iterable<T>를 리턴한다. 계층구조를 단일화할 수 있다.
 */
val families = listOf(
        listOf(Person("Jack", 40), Person("Jill", 40)),
        listOf(Person("Eve", 18), Person("Adam", 18))
)
println(families.size)  //2
println(families.flatten().size)    //4

/**
 * 이름을 가져와 소문자로 바꾸고 이름과 거꾸로 만든 이름을 만든다.
 * map을 사용하면 List<List<String>>이 된다. 하지만 원한 결과는 List<String>이다.
 */
val namesAndReversed = people.map { person -> person.firstName}
        .map(String::lowercase)
        .map { name -> listOf(name, name.reversed()) }
println(namesAndReversed.size)  //7

/**
 * flatten()함수를 사용하면 List<String>으로 만들어진다.
 */
val namesAndReversed2 = people.map { person -> person.firstName}
        .map(String::lowercase)
        .map { name -> listOf(name, name.reversed()) }
        .flatten()
println(namesAndReversed2.size) //14

/**
 * 위 두 과정을 합쳐 만든 것이 flatMap()이다. 실제 연산은 맵을 만든 다음에 플랫화하는 연산이다.
 */
val namesAndReversed3 = people.map { person -> person.firstName}
        .map(String::lowercase)
        .flatMap { name -> listOf(name, name.reversed()) }
println(namesAndReversed3.size) //14

/**
 * 성인의 이름들을 가져온 후 나이에 따라서 정렬
 */
val namesSortedByAge = people.filter { person -> person.age > 17 }
        // 내림차순으로 정렬을 원한다면 sortedByDescending()함수를 사용
        //.sortedBy { person -> person.age }
        .sortedByDescending { person -> person.age }
        .map { person -> person.firstName }
println(namesSortedByAge)   // [Paula, Paul, Jill, Jack]
                            //내림차순 [Jack, Jill, Paul, Paula]

/**
 * people 콜렉션의 Person을 firstName의 첫 번째 글자를 기준으로 그룹화.
 * groupBy() 함수는 콜렉션의 각각의 요소에 대해서 주어진 람다를 실행하고,
 * 람다가 리턴 한 것에 기반해서 요소들을 적절한 버켓에 담는다.
 * 아래 예젠에선 첫 글자가 같은 Person이 같은 버켓 혹은 그룹안에 들어가게 된다.
 * 연산의 결과는 Map<L, List<T>>이다. 람다는 결과 Map의 키의 타입을 결정한다.
 */
val groupBy1stLetter = people.groupBy { person -> person.firstName.first() }
println(groupBy1stLetter)   //{S=[Person(firstName=Sara, age=12), Person(firstName=Sue, age=10)], J=[...

/**
 * 이름만 그룹핑할 수도 있다. 오버로드된 버전의 groupBy()를 사용하면 된다.
 */
val namesBy1stLetter = people.groupBy({ person -> person.firstName.first() }) {
    person -> person.firstName  //{S=[Sara, Sue], J=[Jill, Jack], P=[Paula, Paul], M=[Mani]}
}
println(namesBy1stLetter)