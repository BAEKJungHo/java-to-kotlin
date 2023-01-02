package jav.to.kot.ex.travelator.chapter3.vo;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Money 구현에서 감춰야 하는 세부사항
 * - 이 클래스는 amount 필드의 정밀도가 currency 필드가 가리키는 통화의 보조 통화 단위와 일치하게 보장한다는 불변 조건을 유지한다.
 * - 따라서 private constructor 가 불변 조건을 어기는 것을 막는다.
 *    - Money.of(BigDecimal, Currency) 와 add 메서드가 그렇다.
 *
 * 값 타입이 불변 조건을 유지해야 하거나 내부 표현을 캡슐화해야 한다면 데이터 클래스는 적합하지 않다.
 */
public class MoneyJava {

    private final BigDecimal amount;
    private final Currency currency;

    private MoneyJava(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static MoneyJava of(BigDecimal amount, Currency currency) {
        return new MoneyJava(amount.setScale(currency.getDefaultFractionDigits()), currency);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public MoneyJava add(MoneyJava that) {
        if (!this.currency.equals(that.currency)) {
            throw new IllegalArgumentException("cannot add Money values of different currencies");
        }
        return new MoneyJava(this.amount.add(that.amount), this.currency);
    }

    // equals, hashCode, toString
}
