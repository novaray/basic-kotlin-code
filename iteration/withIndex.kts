val names = listOf("Tom", "Jerry", "Spike")
//구조 분해 사용
for((index, name) in names.withIndex()) {
    println("Position of $name is $index")
}