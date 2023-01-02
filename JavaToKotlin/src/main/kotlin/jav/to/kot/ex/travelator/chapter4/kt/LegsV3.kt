package jav.to.kot.ex.travelator.chapter4.kt

import jav.to.kot.ex.travelator.chapter4.Leg
import java.time.Duration
import java.util.Optional

// 코틀린스러운 코드로 리팩토링하기
fun longestLegOverV1(legs: List<Leg>, duration: Duration): Leg? {
    // takeIf 는 술어가 true 면 수신객체를 반환하고 true 가 아니면 null 을 반환한다.
    return legs.maxByOrNull(Leg::getPlannedDuration)?.let { longestLeg ->
        if (longestLeg.plannedDuration > duration) longestLeg
        else null
    }
}

fun longestLegOverV2(legs: List<Leg>, duration: Duration): Leg? =
    // takeIf 는 술어가 true 면 수신객체를 반환하고 true 가 아니면 null 을 반환한다.
    legs.maxByOrNull(Leg::getPlannedDuration)?.takeIf { longestLeg -> longestLeg.plannedDuration > duration }

// V2 보다 코드는 길지만 명시성 측면에서 더 좋다.
fun List<Leg>.longestLegOverV3(duration: Duration): Leg? {
    val longestLeg = maxByOrNull(Leg::getPlannedDuration)
    return when {
        longestLeg == null -> null
        longestLeg.plannedDuration > duration -> longestLeg
        else -> null
    }
}

private fun isLongerThan(leg: Leg, duration: Duration) = leg.plannedDuration > duration