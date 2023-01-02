package jav.to.kot.ex.travelator.chapter3.dto

/**
 * 일반 클래스로 만든 경우
 */
class EmailAddressV1(val localPart: String, val domain: String) {
    companion object {
        /**
         * @JvmStatic 을 붙이면 자바에서도 EmailAddress.parse 형식으로 호출할 수 있다.
         */
        @JvmStatic
        fun parse(value: String): EmailAddressV1 {
            val atIndex = value.lastIndexOf('@')
            require(!(atIndex < 1 || atIndex == value.length - 1)) {
                "EmailAddress must be two parts separated by @"
            }
            return EmailAddressV1(value.substring(0, atIndex), value.substring(atIndex + 1))
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EmailAddressV1

        if (localPart != other.localPart) return false
        if (domain != other.domain) return false

        return true
    }

    override fun hashCode(): Int {
        var result = localPart.hashCode()
        result = 31 * result + domain.hashCode()
        return result
    }

    override fun toString(): String {
        return super.toString()
    }
}