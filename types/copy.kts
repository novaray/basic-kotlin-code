open class Fruit
class Banana: Fruit()
class Orange: Fruit()

fun copyFromTo(from: Array<Fruit>, to: Array<Fruit>) {
    for(i in 0 until from.size) {
        to[i] = from[i]
    }
}

val fruitsBasket1 = Array<Fruit>(3) { _ -> Fruit() }
val fruitsBasket2 = Array<Fruit>(3) { _ -> Fruit() }
copyFromTo(fruitsBasket1, fruitsBasket2)  //OK

// Banana가 아닌 Fruit을 Array<Banana>에 추가할 수 있기 때문에
// 코틀린에서는 이런 일이 일어나지 않도록 막는다. Array<T> 타입은 변경할 수 없다.
val fruitsBasket3 = Array<Fruit>(3) { _ -> Fruit() }
val bananaBasket = Array<Banana>(3) { _ -> Fruit() }
copyFromTo(bananaBasket, fruitsBasket3)  //ERROR: type mismatch