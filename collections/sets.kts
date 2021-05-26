//mutableSet<T>를 만들 땐 mutableSetOf()
//hashSet<T>를 만들 땐 hashSetOf()
//LinkedHashSet<T>을 만들 땐 linkedSetOf()
//TreeSet<T>를 만들 땐 sortedSetOf()

val fruits: Set<String> = setOf("Apple", "Banana", "Apple")
//Set은 중복 요소를 허용하지 않기 때문에 중복된 값은 누락된다.
println(fruits) //[Apple, Banana]

println(fruits::class)      //class java.util.LinkedHashSet
println(fruits.javaClass)   //class java.util.LinkedHashSet