package com.gridnine.testing;

import java.util.List;
import java.util.function.Predicate;

public class GroundTimeMoreThenHoursFilter implements Predicate<Flight> {
	
	int hours;
	
	public GroundTimeMoreThenHoursFilter(int hours) {
		this.hours = hours;
	}
	
	@Override
	public boolean test(Flight flight) {
		List<Segment> segments = flight.getSegments();

		for (int i = 0; i < (segments.size() - 1); i++) {
			if (segments.get(i).getArrivalDate().plusHours(hours).compareTo(segments.get(i + 1).getDepartureDate()) < 0)  {
				return false;
			}
		}
		return true;
	}
}
