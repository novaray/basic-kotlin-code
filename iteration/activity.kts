//표현식에서의 when에서 코틀린 컴파일러는 else가 마지막이 아닌 부분에 오는 것을 허용하지 않는다.
fun whatToDo(dayOfWeek: Any) = when (dayOfWeek) {
    "Saturday", "Sunday" -> "Relax"
    in listOf("Monday", "Tuesday", "Wendesday", "Thursday") -> "Work hard"
    in 2..4 -> "Work hard"
    "Friday" -> "Party"
    is String -> "What?"
    else -> "No clue"
}
println(whatToDo("Sunday")) //Relax
println(whatToDo("Wendesday")) //Work hard
println(whatToDo(3)) //Work hard
println(whatToDo("Friday")) //Party
println(whatToDo("Munday")) //What?
println(whatToDo(8)) //Relax