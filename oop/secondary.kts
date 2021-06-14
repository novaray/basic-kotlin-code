class Person(val first: String, val last: String) {
    var fulltime = true
    var location: String = "-"

    // 첫 번째 보조 생성자는 this를 이용해서 주 생성자를 호출한다.
    // 바디 안에서 필드 하나를 초기화한다.
    constructor(first: String, last: String, fte: Boolean): this(first, last) {
        fulltime = fte
    }

    // 두 번째 보조 생성자는 첫 번째 보조 생성자를 호출한다.
    constructor(first: String, last: String, loc: String): this(first, last, false) {
        location = loc
    }

    override fun toString() = "$first $last $fulltime $location"
}

println(Person("Jane", "Doe"))          //Jane Doe true -
println(Person("John", "Doe", false))   //John Doe false -
println(Person("Baby", "Doe", "home"))  //John Doe false home