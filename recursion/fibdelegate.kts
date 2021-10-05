import kotlin.reflect.*
import kotlin.system.measureTimeMillis

class Memozie<T, R>(val func: (T) -> R) {
    val cache = mutableMapOf<T, R>()
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = { n: T ->
        cache.getOrPut(n) { func(n) }
    }
}

val fib: (Int) -> Long by Memozie { n: Int ->
    when (n) {
        0, 1 -> 1L
        else -> fib(n - 1) + fib(n - 2)
    }
}

println(measureTimeMillis { fib(40) })
println(measureTimeMillis { fib(45) })
println(measureTimeMillis { fib(500) })