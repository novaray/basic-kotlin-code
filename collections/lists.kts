//뮤터블 리스트를 만들 땐 mutableListOf()함수(java.util.ArrayList)를 이용해서 만들 수 있다.
//그러나 되도록 이뮤터블을 쓰고 뮤터블 리스트를 쓸 땐 충분한 고심 후에 구현한다.
//변경 가능 객체는 좋지 않다.

val fruits: List<String> = listOf("Apple", "Banana", "Grape")
println(fruits) //[Apple, Banana, Grape]
//인덱스 연산자를 사용하는 편이 get()보다 편리하고 노이즈가 적다.
println("fruit's ${fruits[0]}, that's ${fruits.get(0)}")
//fruit's Apple, that's Apple

//in을 사용하는 게 표련력이 좋고, 직관성이 있다.
println(fruits.contains("Apple"))   //true
println("Apple" in fruits)  //true

//fruits.add("Orange")    //error: unresolved reference: add

val fruits2 = fruits + "Orange"
println(fruits)     //[Apple, Banana, Grape]
println(fruits2)    //[Apple, Banana, Grape, Orange]

val noBanana = fruits - "Banana"
println(noBanana)   //[Apple, Grape]

println(fruits::class)      //class java.util.Arrays$ArrayList
println(fruits.javaClass)   //class java.util.Arrays$ArrayList