interface Remote {
    fun up()
    fun down()
    fun doubleUp() {
        up()
        up()
    }

    companion object {
        fun combine(first: Remote, second: Remote): Remote = object: Remote {
            override fun up() {
                first.up()
                second.up()
            }

            override fun down() {
                first.down()
                second.down()
            }
        }
    }
}

/*
* 내부 클래스를 사용하면 효율성 저하를 피하면서 분리된 클래스를 사용하는 이점을 얻을 수 있다.
* 코틀린의 클래스는 다른 클래스에 중첩(내부에 위치한다는 뜻)될 수 있다. Java와는 다르게 코틀린의 중첩 클래스는
* 외부 클래스의 private 멤버에 접근할 수 없다. 하지만 중첩 클래스에 inner 키워드를 사용한다면
* 내부 클래스로 변하면서 제약이 사라진다.
* */
class TV {
    private var volume = 0
    val remote: Remote
    get() = TVRemote()

    override fun toString(): String = "Volume: ${volume}"
    inner class TVRemote: Remote {
        override fun up() {
            volume++
        }

        override fun down() {
            volume--
        }

        // 내부 클래스의 속성이나 메소드가 외부 클래스의 멤버와 일치하다면 다음과 같은 특별한
        // this 표현식을 이용하여 내부 클래스에서 외부 클래스의 멤버에 접근할 수 있다.
        override fun toString(): String = "Remote: ${this@TV.toString()}"
    }
}

val tv = TV()
val remote = tv.remote
println("$tv") //Volume: 0
remote.up()
println("After increasing: $tv")    //After increasing: Volume: 1
remote.doubleUp()
println("After doubleUp: $tv")    //After increasing: Volume: 3
println(remote) //Remote: Volume: 3