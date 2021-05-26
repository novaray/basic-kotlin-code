//mutableMap<T>를 만들 땐 mutableMapOf()
//hashMap<T>를 만들 땐 hashMapOf()
//LinkedHashMap<T>을 만들 땐 linkedMapOf()
//SortedMap<T>를 만들 땐 sortedMapOf()

//읽기 전용 참조만 전달한다(변경 불가).
val sites = mapOf("pragprog" to "https://www.pragprog.com",
    "agiledeveloper" to "https://agiledeveloper.com")
println(sites.size) //2

println(sites.containsKey("agiledeveloper"))    //true
println(sites.containsValue("https://www.example.com")) //false
println(sites.contains("agiledeveloper"))   //true
println("agiledeveloper" in sites)  //true

//get() 메소드는 키가 맵에 없을 경우 nullable타입을 리턴하기 때문에 nullable 참조 타입 사용을 권장한다.
//val pragProgSite: String = sites.get("pragprog")    //오류
val pragProgSite: String? = sites.get("pragprog")
val pragProgSite2: String? = sites["pragprog"]

val agiledeveloper = sites.getOrDefault("agiledeveloper", "https://www.example.com")

val sitesWithExample = sites + ("example" to "https://www.example.com")
val withoutAgileDeveloper = sites - "agiledeveloper"

for (entry in sites) {
    println("${entry.key} --- ${entry.value}")
}

//구조분해로 추출한 key, value는 이뮤터블이다.
for ((key, value) in sites) {
    println("$key --- $value")
}