//String은 non-null type이다.
//코틀린 코드를 작성할 때 Java와 상호운용할 목적이 아니라면 null과 nullable타입은
//절대 사용하지 않는 편이 좋다.

fun nickName(name: String): String {
    if (name == "William") {
        return "Bill";
    }
    return null //ERROR
}

println("Nickname for William is ${nickName("William")}")
println("Nickname for Venkat is ${nickName("Venkat")}")
println("Nickname for null is ${nickName(null)}")