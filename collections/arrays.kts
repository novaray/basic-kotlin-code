val friends = arrayOf("Tintin", "Snowy", "Haddock", "Calculus")
println(friends::class) //class Kotlin.Array
println(friends.javaClass)  //class [Ljava.lang.String;
println("${friends[0]} and ${friends[1]}")   //Tintin, Snowy

//원시 타입인 int말고 Integer 클래스로 작업해서 오버헤드가 크게 걸려 비추다.
val numbers = arrayOf(1, 2, 3)
println(numbers::class) //class Kotlin.Array
println(numbers.javaClass)  //class [Ljava.lang.Integer;

val numbers2 = intArrayOf(1, 2, 3)
println(numbers2::class) //class Kotlin.IntArray
println(numbers2.javaClass)  //class [I

println(numbers2.size)       //3
println(numbers2.average())  //2.0

println(Array(5) { i -> (i + 1) * (i + 1) }.sum())   //55