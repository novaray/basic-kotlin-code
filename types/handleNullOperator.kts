fun nickName(name: String?): String? {
    if (name == "William") {
        return "Bill";
    }
    //toUpperCase()메소드는 deprecated됐다.
//    val result = name?.reversed()?.uppercase()
//    return if (result == null) "Joker" else result

    return name?.reversed()?.uppercase() ?: "Joker"
}

//세이프 콜이나 엘비스 연산자는 값을 추출해낼 때 사용하고
//when은 null가능 참조에 대한 처리를 결정해야 할 때 사용한다.
//세이프 콜이나 엘비스 연산자 사용보다 when을 사용해 코드를 정리하는 것도 좋은 방법.
//null체크를 먼저 했기 때문에 else 절에서 null아닐 경우에만 동작하기에 null체크가 불필요하다.
fun nickName2(name: String?) = when (name) {
    "William" -> "Bill"
    null -> "Joker"
    else -> name.reversed().uppercase()
}

//코틀린은 null 가능 참조가 메소드를 호출할 때는 세이프 콜 연산자(safe call operator)또는
//null이 아님을 확인해 주는 연산자(non-null assertion operator) 프리픽스를 요구한다.
println("Nickname for William is ${nickName("William")}")
println("Nickname for Venkat is ${nickName("Venkat")}")
println("Nickname for null is ${nickName(null)}")

//not-null 확정(not-null assertion) 연산자 !!가 있지만 이 연산자를 사용하고
//실행 중에 null이 발생하면 NPE가 발생해서 프로그램이 종료된다. 그냥 잊어버리는 게 좋다.