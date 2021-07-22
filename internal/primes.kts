fun isPrime(n: Long) = n > 1 && (2 until n).none { i-> n % i == 0L }

/**
 * tailRec는 StackOverflowError를 방지해준다. 이건 추후 공부하면서 더 깊게배운다.
 */
tailrec fun nextPrime(n: Long): Long = if (isPrime(n + 1)) n + 1 else nextPrime(n + 1)

/**
 * generateSequence()함수를 이용해서 아무 소수로나 시작하는 무한 시퀀스를 만들 수 있다.
 * 첫 번째 파라미터로 시작하는 값(seed value)를 받고, 함수(람다)를 두 번째 파라미터로 받는다.
 * generateSequence()가 지연 연산을 하고, 우리가 값을 요청할 때까지 nextPrime() 함수가 실행되지 않는다.
 * 값이 몇 개든 상관없이 take() 메소드를 이용해서 값을 요청할 수 있다.
 */
val primes = generateSequence(5, ::nextPrime)

/**
 * toList() 함수의 호출이 시퀀스의 값의 평가를 발생시켰다.
 */
println(primes.take(6).toList())    //[5, 7, 11, 13, 17, 19]

/**
 * generateSequence()를 사용하는 대신 sequence() 함수를 사용할 수도 있다.
 * 컨티뉴에이션(연속적으로 동작하는) 람다.
 * 이건 추후 컨티뉴에이션과 코루틴에 대해서 자세히 다룰 예정. 맛만 본다.
 * sequence() 호출의 결과는 Sequence 인터페이스를 구현한 인스턴스이다.
 */
val primes2 = sequence {
    var i: Long = 0
    while (true) {
        i++
        if (isPrime(i)) {
            yield(i)
        }
    }
}

/**
 * 소수의 시퀀스가 2로 시작되니까 drop()을 이용해서 처음 2개의 값을 버리고 그 이후의 6개의 값을 취한다.
 */
println(primes2.drop(2).take(6).toList())   //[5, 7, 11, 13, 17, 19]