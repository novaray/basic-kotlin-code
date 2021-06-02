// 추가로 Appendable을 제약조건으로 더하면 append()메소드도 사용 가능하다.
fun <T> useAndClose(input: T)
where T: AutoCloseable,
      T: Appendable {
          input.append("there")
          input.close()
      }

val writter= java.io.StringWriter()
writter.append("hello ")
useAndClose(writter)
println(writter)    //hello there