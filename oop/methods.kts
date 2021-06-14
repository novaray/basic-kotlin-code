class Person(val first: String, val last: String) {
    var fulltime = true
    var location: String = "-"

    constructor(first: String, last: String, fte: Boolean): this(first, last) {
        fulltime = fte
    }

    constructor(first: String, last: String, loc: String): this(first, last, false) {
        location = loc
    }

    override fun toString() = "$first $last $fulltime $location"

    internal fun fullName() = "$last, $first"
    private fun yearsOfService(): Int = throw RuntimeException("Not implemented yet")
}

val jane = Person("Jane", "Doe")
println(jane.fullName())
jane.yearsOfService() //ERROR: 'Person' 클래스의 private 메소드에 접근할 수 없다.