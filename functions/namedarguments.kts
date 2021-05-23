fun createPerson(name: String, age: Int = 1, height: Int, weight: Int) {
    println("$name $age $height $weight")
}

createPerson(name="Jake", age=12, weight=43, height=152)
createPerson("Jake", 12, weight=43, height=152) //틀린 것은 아니지만 가독성 관점에서 다 명시적 아규먼트를 쓰는 것이 좋다.

createPerson(weight=43, height=152, name="Jake")
createPerson("Jake", weight=43, height=152)