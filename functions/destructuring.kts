fun getFullName() = Triple("John", "Quincy", "Adams")

val result = getFullName()
// val first = result.first
// val second = result.second
// val last = result.third
//val (first, second, last) = getFullName()
//println("$first $second $last") //John Quincy Adams

// val (first, _, last) = getFullName()
//println("$first $last") //John Adams

val(_, middle) = getFullName()
println("$middle") //Quincy