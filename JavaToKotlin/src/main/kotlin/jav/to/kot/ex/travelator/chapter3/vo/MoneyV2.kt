package jav.to.kot.ex.travelator.chapter3.vo

import java.math.BigDecimal
import java.util.Currency

class MoneyV2 private constructor(
    val amount: BigDecimal,
    val currency: Currency
) {

    fun add(that: MoneyV2): MoneyV2 {
        require(currency == that.currency) {
            "cannot add Money values of different currencies"
        }
        return MoneyV2(amount.add(that.amount), currency)
    }

    companion object {
        @JvmStatic
        fun of(amount: BigDecimal, currency: Currency): MoneyV2 {
            return MoneyV2(amount.setScale(currency.defaultFractionDigits), currency)
        }
    }

    // equals, hashCode, toString
}