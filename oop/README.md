### com.agiledeveloper 패키지 빌드법

```bash
kotlinc-jvm ./com/agiledeveloper/util/Util.kt \
./com/agiledeveloper/use/UseUtil.kt \
-d Util.jar
```
위 명령 후 Util.jar파일이 해당 경로에 나온다.
해당 경로에서 다음 명령어 실행

```bash
kotlin -classpath Util.jar com.agiledeveloper.use.UseUtilKt
```

### oop/Car.kt 컴파일 후 자바클래스 확인법
```bash
kotlinc-jvm Car.kt
javap -p Car.class
```

### oop/Car.kt, UseCar.kt 컴파일후 바이트코드 확인
```bash
kotlinc-jvm Car.kt UseCar.kt
javap -c UseCarKt.class
```