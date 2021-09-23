import datedsl.*
import datedsl.DateUtil.Tense.*
println(2 days ago)
println(3 days from_now)

//kotlinc-jvm DateUtil.kt -d datedsl.jar
//kotlinc-jvm -classpath datedsl.jar -script usedatedsl.kts