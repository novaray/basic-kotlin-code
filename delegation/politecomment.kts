//import com.agiledeveloper.delegates.PoliteString
// comment 변수를 PoliteString을 사용하도록 변경랬다.
// String이 PoliteString에 접근할 때 델리게이션을 사용한다.
//var comment: String by PoliteString("Some nice message")

// top-level함수 사용
import com.agiledeveloper.delegates.beingpolite
var comment: String by beingpolite("Some nice message")
println(comment)
comment = "This is stupid"
println(comment)
println("comment is of length: ${comment.length}")
