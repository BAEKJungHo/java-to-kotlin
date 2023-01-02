package jav.to.kot.ex.travelator.chapter3.dto

/**
 * Kotlin 은 언어 수준에서 Value Object 타입을 지원한다.
 * data class 는 equals, hashCode, toString 을 자동으로 생성해 준다.
 *
 * data class 의 한계는 캡슐화를 제공하지 않는다는 점이다.
 * data class 는 copy 메서드를 지원한다. (copy 메서드는 항상 public)
 *   - 컴파일러가 데이터 클래스 객체의 모든 프로퍼티 값을 그대로 복사한 객체를 생성하되, 원하면 일부를 다른 값으로 교체 가능
 *   - 이 문제는 클래스가 내부 표현을 추상화하거나 프로퍼티 사이에 어떤 불변 조건(invariant)을 유지해야 하는 경우에 copy 메서드가
 *   - 클라이언트 코드에 값의 내부 상테에 직접 접근하도록 불변 조건을 깰 수 있다.
 *   - 따라서, 완벽한 불변 조건을 유지해야하는 경우에는 data class 를 사용하면 안된다.
 */
data class EmailAddressV2(val localPart: String, val domain: String) {
    companion object {
        /**
         * @JvmStatic 을 붙이면 자바에서도 EmailAddress.parse 형식으로 호출할 수 있다.
         */
        @JvmStatic
        fun parse(value: String): EmailAddressV2 {
            val atIndex = value.lastIndexOf('@')
            require(!(atIndex < 1 || atIndex == value.length - 1)) {
                "EmailAddress must be two parts separated by @"
            }
            return EmailAddressV2(value.substring(0, atIndex), value.substring(atIndex + 1))
        }
    }
}