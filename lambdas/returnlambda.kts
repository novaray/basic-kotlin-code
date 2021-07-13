val names = listOf("Pam", "Pat", "Paul", "Paula")

/**
 *  두 람다는 이름의 길이를 제외하면 모두 같은 일을 한다. 별로 큰일은 아니지만
 *  코드가 중복되는 것은 좋지 않다.
 */
println(names.find { name -> name.length == 5 })    //Paula
println(names.find { name -> name.length == 4 })    //Paul

/**
 * 길이를 파라미터로 받고, 람다를 리턴하는 함수를 만들면 해당 함수를 다시 사용할 수 있다.
 */
//fun predicateOfLength(length: Int): (String) -> Boolean {
//    return { input: String -> input.length == length }
//}

/**
 * 위 코드를 타입추론을 이용해서 리팩토링 결과다.
 * 타입추론은 함수가 짧고, 블록바디가 없는 경우에만 사용 가능하다.
 * 단, 블록 바디 함수에서 리턴할 때는 항상 리턴타입을 명시하도록 한다.
 * 타입추록은 리턴할 함수가 블록 바디가 아닌 경우만 사용한다.
 */
fun predicateOfLength(length: Int): = { input: String -> input.length == length }
println(names.find(predicateOfLength(5)))   //Paula
println(names.find(predicateOfLength(4)))   //Paul