fun nickName(name: String?): String? {
    if (name == "William") {
        return "Bill";
    }
    return name.reversed() //ERROR
}

//코틀린은 null 가능 참조가 메소드를 호출할 때는 세이프 콜 연산자(safe call operator)또는
//null이 아님을 확인해 주는 연산자(non-null assertion operator) 프리픽스를 요구한다.
println("Nickname for William is ${nickName("William")}")
println("Nickname for Venkat is ${nickName("Venkat")}")
println("Nickname for null is ${nickName(null)}")