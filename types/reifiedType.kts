abstract class Book(val name: String)
class Fiction(name: String): Book(name)
class NonFiction(name: String): Book(name)

val books: List<Book> = listOf(Fiction("Moby Dick"),
        NonFiction("Learn to Code"),
        Fiction("LOTR"))

// 다음 코드는 자바 스타일로 짠 코드이다.
// 바이트코드로 컴파일되면서 파라미터 타입 T가 지워지기 때문에 함수 안에서 T를
// book is T 또는 selected[0] as T같은 연산자를 함께 사용할 수 없다.
// 이런 접근은 호출하는 쪽과 받아주는 쪽 모두에게 나쁜 코드를 만들게 된다.
/* fun <T> findFirst(books: List<Book>, ofClass: Class<T>): T {
    val selected = books.filter { book -> ofClass.isInstance(book) }
    if (selected.size == 0) {
       throw RuntimeException("Not found")
    }
    return ofClass.cast(selected[0])
}
println(findFirst(books, NonFiction::class.java).name)  //Learn to Code
*/

// 위의 코드를 리팩토링한 결과다.
// 인라인 함수는 간단하게 컴파일 시점에 확정되므로 함수 호출 시 오버헤드가 없는 함수다.
// reified는 inline 함수에서만 사용 가능하다.
// 타입 T는 컴파일 시간에 확인되는 실제 타입으로 대체된다.
inline fun <reified T> findFirst(books: List<Book>): T {
    val selected = books.filter{ book -> book is T }
    if (selected.size == 0) {
        throw RuntimeException("Not found")
    }
    return selected[0] as T
}

println(findFirst<NonFiction>(books).name)  //Learn to Code