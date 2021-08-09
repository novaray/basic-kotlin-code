/**
 * 클래스의 컴패니언 객체를 확장해서 static 메소드를 인젝팅할 수 있다.
 * 즉 메소드를 클래스가 아니라 컴패니언에 인젝팅한다는 의미다.
 * 그 결과 컴패니언 객체를 가지고 있다면 static 메소드를 인젝팅할 수 있다.
 */

// 코틀린은 String에 확장되고 추가된 컴패니언이 있따. 그렇기 때문에 String에는 static메소드를 추가할 수 있다.
fun String.Companion.toURL(link: String) = java.net.URL(link)

/**
 * 확장 함수를 추가하면, 파라미터로 받은 String을 URL인스턴스로 변경하기 위해 String 클래스에서 toURL()함수를 호출할 수 있다.
 */
val url: java.net.URL = String.toURL("https://pragprog.com")
println(url)