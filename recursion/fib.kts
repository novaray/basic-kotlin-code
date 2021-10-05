import kotlin.system.measureTimeMillis
fun fib(n: Int): Long = when(n) {
    0, 1 -> 1L
    else -> fib(n - 1) + fib( n - 2)
}
//println(measureTimeMillis { fib(40) })    //3ms
//println(measureTimeMillis { fib(45) })      //3second