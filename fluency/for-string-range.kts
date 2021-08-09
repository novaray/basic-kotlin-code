/**
 * ./iteration/ranges.kts에서 에러나는 부분을 해결한다.
 * 1. 반복자를 만들 때 어노니머스(익명) 객체로 만들 수 있다.
 * 2. start 속성을 이용해서 range의 첫 번쨰 요소에 접근할 수 있고, ClosedRange<T> 클래스의 endInclusiv를 이용해서 마지막 요소에 접근할 수 있다.
 * 3. 코틀린은 >= 연산자를 사용하면 compareTo() 메소드를 실행한다.
 * 4. 뮤터블 String을 사용하기 위해서 JDK의 StringBuilder 클래스를 사용할 수 있다.
 * 5. Kotiln.Char의 + 연산자는 다음 문자를 가져오기 위해 사용된다. + 연산자를 StringBuilder의 마지막 캐릭터를 증가시키기 위해서 사용한다.
 */

operator fun ClosedRange<String>.iterator() =
        object: Iterator<String> {
            private val next = StringBuilder(start)
            private val last = endInclusive
            override fun hasNext() =
                    last >= next.toString() && last.length >= next.length
            override fun next(): String {
                val result = next.toString()
                val lastCharacter = next.last()
                if (lastCharacter < Char.MAX_VALUE) {
                    next.setCharAt(next.length - 1, lastCharacter + 1)
                } else {
                    next.append(Char.MIN_VALUE)
                }
                return result
            }
        }

/**
 * 에러가 발생하지 않는다.
 * 코틀린이 제공하는 다른 기능인 코루틴의 yield를 이용하면 반복자를 더 간단히 구현할 수도 있다.
 * 추후 알아본다.
 */
for (word in "hell".."help") { print("$word, ") }   //hell, helm, heln, helo, help,