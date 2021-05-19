# Kotlin 컴파일러를 활용한 Code Snipet 실행

### .kt 파일을 컴파일 할 때
*Hello.kt파일(클래스 미포함)의 경우*
```shell
kotlinc-jvm Hello.kt -d Hello.jar
kotlin -classpath Hello.jar HelloKt
```
*Hello.kt* 파일이 함수만을 가지고 있고 클래스가 아니라면 코틀린 컴파일러가
자동으로 확장자를 제거한 파일 이름을 가지고 Kt라는 접미사를 추가한 클래스 이름을 만든다.

### 코틀린 스크립트(.kts)파일을 즉시 실행할 때(REPL 실험)
*myscript.kts의 경우*
```shell
kotlinc-jvm -script myscript.kts
```
**Unix-like 시스템을 쓸 경우 셔뱅(shebang)을 사용할 수 있다.**
```kotlin
#!/usr/bin/env kotlinc-jvm -script
println("hi")
```