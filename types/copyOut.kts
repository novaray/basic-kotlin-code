open class Fruit
class Banana: Fruit()
class Orange: Fruit()

// 다음의 두 호출이 있다면 컴파일에 실패한다.
// from[i] = Fruit()  //ERROR
// from.set(i, to[i]) //ERROR
// from에서는 읽기만 하고 to에 값을 설정하는 경우이다.
fun copyFromTo(from: Array<out Fruit>, to: Array<Fruit>) {
    for(i in 0 until from.size) {
        to[i] = from[i]
    }
}

val fruitsBasket = Array<Fruit>(3) { _ -> Fruit() }
val bananaBasket = Array<Banana>(3) { _ -> Fruit() }
copyFromTo(bananaBasket, fruitsBasket)  //OK