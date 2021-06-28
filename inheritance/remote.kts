// Java8에서 default 메소드가 처음으로 나왔지만, 코틀린의 인터페이스에서 구현된 메소드는 Java 1.6이상에서 사용 가능하다.
// 인터페이스를 구현할 때는 모든 추상 메소드를 구현해야 한다.
interface Remote {
    fun up()
    fun down()
    fun doubleUp() {
        up()
        up()
    }

    // Java에선 인터페이스 static 메소드를 가질 수 있지만 코틀린에서는 static 메소드를 직접 만들 수 없다.
    // 이는 클래스 안에 static 메소드를 직접 작성할 수 없는 것과 동일하다.
    // 인터페이스에 static 메소드를 작성하기 위해선 컴패니언 객체를 사용해야 한다.
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

class TV {
    var volume = 0
}

/* Remote 인터페이스를 구현한다는 것을 명시하기 위해서 주 생성자 뒤에 콜론(:)을 사용하고 Remote를 적었다.
* TVRemote처럼 직접 구현한 게 아니고 분리된 클래스를 가지고 있는 것에는 장/단점이 있다.
* 장점
* 첫 번째로, TV 인스턴스 하나에 여러 개의 TVRemote를 가질 수 있다는 점
* 두 번째로, TVRemote의 인스턴스들은 TV 인스턴스의 상태와 분리된 채로 내부 상태를 가질 수 있다.
* 단점
* Remote 인터페이스를 구현하고 있는 TVRemote 메소드들은 TV의 public 메소드로 사용해야만 한다.
* */
class TVRemote(val tv: TV): Remote {
    override fun up() {
        tv.volume++;
    }

    override fun down() {
        tv.volume--;
    }
}

val tv = TV()
val remote: Remote = TVRemote(tv)
println("Volume: ${tv.volume}") //0
remote.up()
println("After increasing: ${tv.volume}")   //1
remote.doubleUp()
println("After doubleUp: ${tv.volume}") //3

val anotherTV = TV()
val combinedRemote = Remote.combine(remote, TVRemote(anotherTV))
combinedRemote.up()
println(tv.volume)  //4
println(anotherTV.volume)   //1