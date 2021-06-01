open class Fruit
class Banana: Fruit()
class Orange: Fruit()

//fun receiveFruits(fruits: Array<Fruit>) {
//    println("Number of fruits: ${fruits.size}")
//}
//
//val bananas: Array<Banana> = arrayOf()
//receiveFruits(bananas)  //Error: type mismatch

fun receiveFruits(fruits: List<Fruit>) {
    println("Number of fruits: ${fruits.size}")
}

val bananas: List<Banana> = listOf()
receiveFruits(bananas)  //OK

//이런 다른 동작이 이루어지는 이유는 Array<T>는 뮤터블하지만 List<T>는 이뮤터블하다.
//Array<T>는 class Array<T>로 정의되며 List<T>는 interface List<out E>로 정의한다.
