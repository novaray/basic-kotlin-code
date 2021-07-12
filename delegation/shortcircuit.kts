fun getTemperature(city: String): Double {
    println("fetch from webservice for $city")
    return 30.0
}

val showTemperature = false
val city = "Boulder"
/**
 * 단축 평가식 덕분에 getTemperature() 메소드는 생략된다. 효율적이다.
 */
if (showTemperature && getTemperature(city) > 20) //(nothing here)
    println("Warm")
else
    println("Nothing to report")    //Nothing to report

/**
 * getTemperature의 결과를 지역 임시변수에 저장해 오버헤드 발생.
 */
val temperature = getTemperature(city)  //fetch from webservice
if (showTemperature && temperature > 20)
    println("Warm")
else
    println("Nothing to report")    //Nothing to report