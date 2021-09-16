class Mailer {
    val details = StringBuilder()
    fun from(addr: String) = details.append("from $addr...\n")
    fun to(addr: String) = details.append("to $addr...\n")
    fun subject(line: String) = details.append("subject $line...\n")
    fun body(message: String) = details.append("body $message...\n")
    fun send() = "...sending...\n$details"
}

/**
 * 장황할 뿐더러 반복저이고 좋지 않다.
 */
val mailer = Mailer()
mailer.from("builder@agiledeveloper.com")
mailer.to("venkats@agiledeveloper.com")
mailer.subject("Your code sucks")
mailer.body("...deatils...")
val result = mailer.send()
println(result)

/**
 * 위의 mailer인스턴스를 참조하는 것보다 깔끔해졌지만 apply{... 호출로 인해서 지저분하다.
 */
val mailer2 = Mailer()
    .apply { from("builder@agiledeveloper.com") }
    .apply { to("venkats@agiledeveloper.com") }
    .apply { subject("Your code sucks") }
    .apply { body("...deatils...") }
val result2 = mailer.send()
println(result2)

/**
 * apply() 메소드는 apply()를 마지막으로 호출한 객체의 컨텍스트에서 람다를 실행시킨다.
 * apply()에 전달하는 람다에서 Mailer에 여러 번의 메소드 호출을 사용할 수 있다.
 */
val mailer3 = Mailer().apply {
    from("builder@agiledeveloper.com")
    to("venkats@agiledeveloper.com")
    subject("Your code sucks")
    body("...deatils...")
}
val result3 = mailer.send()
println(result3)

/**
 * 최종적으로 원하는 건 send() 메소드를 호출하는 것이다.
 * 메소드가 수행된 이후에도 Mailer의 참조가 유지되고 해당 인스턴스로 다른 일을 더 한다면 apply() 메소드가 좋은 선택이지만,
 * 인스턴스를 쓸 일이 없다면 run()을 사용할 수 있다. run() 메소드는 람다의 결과를 리턴한다.
 */
val result4 = Mailer().run {
    from("builder@agiledeveloper.com")
    to("venkats@agiledeveloper.com")
    subject("Your code sucks")
    body("...deatils...")
    send()
}
println(result4);

/**
 * 함수에서 인스턴스를 받았지만 해당 인스턴스를 다른 메소드의 아규먼트로 전달하고 싶다면
 * let() 메소드가 자연스러움을 유지하도록 도와준다.
 * 다음 예는 지루하다. 여러 개의 괄호 때문에 무겁게 느껴진다. 일반적으로 작성하는 코드와 차이도 없다.
 * 메소드 호출을 한 후 다음 메소드로 연결을 편하게 해주는 것이 let() 메소드이다(전달한 람다의 결과를 사용하기 원한다면).
 */
fun createMailer() = Mailer()
fun prepareAndSend(mailer: Mailer) = mailer.run {
    from("builder@agiledeveloper.com")
    to("venkats@agiledeveloper.com")
    subject("Your code sucks")
    body("...deatils...")
    send()
}
//val mailer5 = createMailer()
//val result5 = prepareAndSend(mailer5)
//val result5 = prepareAndSend(createMailer())
//val result5 = createMailer().let { mailer ->
//    prepareAndSend(mailer)  //과연 진짜로 이게 향상된 코드인가?
//}
//val result5 = createMailer().let {
//    prepareAndSend(it)  //조금은 나아졌지만..
//}
val result5 = createMailer().let(::prepareAndSend)
println(result5)

/**
 * also() 메소드는 체이닝을 사용할 수 없는 void 함수를 체이닝 하려고 할 때 유용하다.
 * void 함수(코틀린에선 Unit을 리턴하는 함수)를 사용하는 예제를 본다.
 */

fun prepareMailer(mailer: Mailer): Unit {
    mailer.run {
        from("builder@agiledeveloper.com")
        to("venkats@agiledeveloper.com")
        subject("Your code sucks")
        body("...deatils...")
    }
}
fun sendMail(mailer: Mailer): Unit {
    mailer.send()
    println("Mail sent")
}

//val mailer6 = createMailer()
//prepareMailer(mailer6)
//sendMail(mailer6)
/**
 * also()를 이용하면 함수 호출을 할 때 체이닝이 가능하다.
 * 왜냐면 also()가 타깃 객체를 람다에 파라미터로 전달하고, 람다의 리턴을 무시한 후 타깃을 다시 호출한 곳으로 리턴하기 때문이다.
 */
createMailer()
    .also(::prepareMailer)
    .also(::sendMail)