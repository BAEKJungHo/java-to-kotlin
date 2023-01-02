package jav.to.kot.ex.travelator.chapter4.kt

import jav.to.kot.ex.travelator.chapter4.Leg
import java.time.Duration
import java.util.Optional

// java optional 을 kotlin 으로 전환할 때는 optional 을 반환하는 함수와 ?(nullable)을 반환하는 하는 함수 2개가 있어야 한다.
// java 에서 Optional.orElseThrow() 는 코틀린의 !! 와 같다.
// !! 는 가급적 사용하는 것을 지양해야 하지만, Optional.orElseThrow() 의 대안으로는 사용 가능하다.
object LegsV2 {

    // 자바가 사용하는 메서드
    // 추후에 모든 코드가 리팩토링되면 해당 메서드는 삭제하면 된다.
    @JvmStatic
    fun findLongestLegOver(
        legs: List<Leg>,
        duration: Duration
    ): Optional<Leg> {
        return Optional.ofNullable(longestLegOver(legs, duration))
    }

    // 코틀린이 사용하는 메서드
    fun longestLegOver(legs: List<Leg>, duration: Duration): Leg? {
        var result: Leg? = null
        for (leg in legs) {
            if (isLongerThan(leg, duration)) {
                if (result == null || isLongerThan(leg, result.plannedDuration)) {
                    result = leg
                }
            }
        }
        return result
    }


    private fun isLongerThan(leg: Leg, duration: Duration): Boolean {
        return leg.plannedDuration > duration
    }
}