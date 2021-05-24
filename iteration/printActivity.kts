//명령문으로 when이 사용될 때는 else가 없어도 상관없다.
fun printWhatToDo(dayOfWeek: Any) {
    when (dayOfWeek) {
        "Saturday", "Sunday" -> println("Relax")
        in listOf("Monday", "Tuesday", "Wendesday", "Thursday") -> println("Work hard")
        in 2..4 -> println("Work hard")
        "Friday" -> println("Party")
        is String -> println("What?")
    }
}
printWhatToDo("Sunday") //Relax
printWhatToDo("Wendesday") //Work hard
printWhatToDo(3) //Work hard
printWhatToDo("Friday") //Party
printWhatToDo("Munday") //What?
printWhatToDo(8) //