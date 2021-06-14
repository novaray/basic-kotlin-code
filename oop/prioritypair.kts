class PriorityPair<T: Comparable<T>>(member1: T, member2: T) {
    val first: T
    val second: T
    init {
        // Comparable 인터페이스의 compareTo() 메소드 대신
        // >= 연산자를 사용했다.
        if (member1 >= member2) {
            first = member1
            second = member2
        } else {
            first = member2
            second = member1
        }
    }

    override fun toString() = "${first}, ${second}"
}

println(PriorityPair(2, 1))     //2, 1
println(PriorityPair("A", "B")) //B, A