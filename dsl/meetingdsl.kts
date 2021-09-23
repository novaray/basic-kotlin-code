class Meeting(val title: String) {
    var startTime: String = ""
    var endTime: String = ""
    val start = this
    val end = this
    private fun convertToString(time: Double) = String.format("%.02f", time)
    infix fun at(time: Double) { startTime = convertToString(time) }
    infix fun by(time: Double) { endTime = convertToString(time) }
    override fun toString() = "$title Meeting starts $startTime ends $endTime"
}
infix fun String.meeting(block: Meeting.() -> Unit) {
    val meeting = Meeting(this)
    meeting.block()
    println(meeting)
}

/**
 * 훌륭하게 구현되었지만 start나 end를 타이핑하면 IDE의 자동완성 기능이 at과 by를 모두 보여준다.
 * 이런 점이 유절르 잘못된 길로 이끌 수 있다.
 * at, by 메소드를 분리된 클래스로 옮겨서 이런 잠재적인 에러를 예방할 수 있다.
 * meetingdslresolved.kts
 */
"Release Planning" meeting {
    start at 14.30
    end by 15.20
}