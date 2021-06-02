fun <T: AutoCloseable> useAndClose(input: T) {
    input.close();  //OK
}

val writter= java.io.StringWriter()
writter.append("hello ")
useAndClose(writter)
println(writter)    //hello