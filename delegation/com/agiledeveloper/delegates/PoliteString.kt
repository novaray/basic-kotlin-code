package com.agiledeveloper.delegates
import kotlin.reflect.KProperty
class PoliteString(var content: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = content.replace("stupid", "s*****")
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        content = value
    }

    /**
     * by 뒤에 나오는 클래스의 생성자를 호출하기보단 델리게이션 인스턴스를 리턴해주는
     * 함수를 사용하길 원한다면 top-level함수를 사용할 수 있다.
     */
    fun beingpolite(content: String) = PoliteString(content)
}
