package jav.to.kot.ex.travelator.chapter3.vo

import java.math.BigDecimal
import java.util.Currency

class MoneyV1 private constructor(
    val amount: BigDecimal,
    val currency: Currency
) {

    fun add(that: MoneyV1): MoneyV1 {
        require(currency == that.currency) {
            "cannot add Money values of different currencies"
        }
        return MoneyV1(amount.add(that.amount), currency)
    }

    companion object {
        @JvmStatic
        fun of(amount: BigDecimal, currency: Currency): MoneyV1 {
            return MoneyV1(amount.setScale(currency.defaultFractionDigits), currency)
        }
    }

    // equals, hashCode, toString
}