package com.race;

import java.time.*;


import static com.race.DistanceCalculator.betweenPoints;


class Leg {

    private final double distance;
    private final Duration duration;
    private final Location startLocation;
    private final Location finishLocation;

    Leg(Location startLocation, LocalDateTime startLocalTime, Location finishLocation, LocalDateTime finishLocalTime) {
        this.startLocation = startLocation;
        this.finishLocation = finishLocation;
        if(startLocation.getZone() == finishLocation.getZone()) {
            this.duration = Duration.between(startLocalTime, finishLocalTime);
        } else {
            ZonedDateTime startLocalZonedTime = startLocalTime.atZone(startLocation.getZone());
            ZonedDateTime finishLocalZonedTime = finishLocalTime.atZone(finishLocation.getZone());
            this.duration = Duration.between(startLocalZonedTime, finishLocalZonedTime);
        }
        this.distance = betweenPoints(startLocation.getPoint(), finishLocation.getPoint());
    }

    Duration getDuration() {
        return duration;
    }

    double getDistance() {
        return distance;
    }

    Location getStartLocation() {
        return startLocation;
    }

    Location getFinishLocation() {
        return finishLocation;
    }
}
