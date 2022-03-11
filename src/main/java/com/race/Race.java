package com.race;

import java.time.*;
import java.util.*;

class Race {

	private final List<Leg> legs = new ArrayList<>();

	void addLeg(Leg leg) {
		legs.add(leg);
	}

	int getLegsCount() {
		return legs.size();
	}

	Duration getTotalDuration() {
		return this.legs.stream().map(Leg::getDuration).reduce(Duration.ZERO, Duration::plus);
	}

	Duration getAverageLegDuration() {
		return getTotalDuration().dividedBy(this.legs.size());
	}

	double getTotalDistance() {
		return this.legs.stream().mapToDouble(Leg::getDistance).sum();
	}

	double getAverageLegDistance() {
		return this.legs.stream().mapToDouble(Leg::getDistance).average().orElse(0);
	}

}
