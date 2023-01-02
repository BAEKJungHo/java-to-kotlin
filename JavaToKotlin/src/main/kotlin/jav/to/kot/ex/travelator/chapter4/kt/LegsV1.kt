package jav.to.kot.ex.travelator.chapter4.kt

import jav.to.kot.ex.travelator.chapter4.Leg
import java.time.Duration
import java.util.Optional

// java optional 을 kotlin 으로 전환할 때는 optional 을 반환하는 함수와 ?(nullable)을 반환하는 하는 함수 2개가 있어야 한다.
object LegsV1 {

    @JvmStatic
    fun findLongestLegOver(
        legs: List<Leg>,
        duration: Duration
    ): Optional<Leg> {
        var result: Leg? = null
        for (leg in legs) {
            if (isLongerThan(leg, duration)) {
                if (result == null || isLongerThan(leg, result.plannedDuration)) {
                    result = leg
                }
            }
        }
        return Optional.ofNullable(result)
    }

    private fun isLongerThan(leg: Leg, duration: Duration): Boolean {
        return leg.plannedDuration > duration
    }
}