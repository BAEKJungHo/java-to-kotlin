package jav.to.kot.ex.travelator.chapter4;

import java.time.Duration;

public class Leg {

    private Duration plannedDuration;

    public Leg(Duration plannedDuration) {
        this.plannedDuration = plannedDuration;
    }

    public Duration getPlannedDuration() {
        return plannedDuration;
    }
}
