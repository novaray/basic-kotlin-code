/**
 * 이미 존재하는 메소드의 동작을 바꾸지 말라.
 * 할 수 있다.라고 생각도 말라, 그냥 하지 말라.
 * 괴로워진다.
 */
fun String.lowercase() = uppercase()    //BAD COD

val str = "Please don't"
println(str.lowercase())