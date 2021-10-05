import java.math.BigInteger
fun factorialRec(n: Int): BigInteger =
        if (n <= 0) 1.toBigInteger() else n.toBigInteger() * factorialRec(n - 1)
println(factorialRec(5))    //120

//반복문을 이용한 예제

fun factorialIterative(n: Int) =
        (1..n).fold(BigInteger("1")) { product, e -> product * e.toBigInteger() }
println(factorialIterative(5))  //120