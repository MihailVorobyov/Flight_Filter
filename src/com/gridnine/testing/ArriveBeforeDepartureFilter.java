package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.function.Predicate;


public class ArriveBeforeDepartureFilter implements Predicate<Flight> {
	@Override
	public boolean test(Flight flight) {
		for (Segment segment : flight.getSegments()) {
			if (segment.getArrivalDate().compareTo(segment.getDepartureDate()) < 0)  {
				return false;
			}
		}
		return true;
	}
}
