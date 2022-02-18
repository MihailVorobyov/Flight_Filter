package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.function.Predicate;


public class DepartureBeforeNowFilter implements Predicate<Flight> {
	@Override
	public boolean test(Flight flight) {
		for (Segment segment : flight.getSegments()) {
			if (segment.getDepartureDate().compareTo(LocalDateTime.now()) < 0)  {
				return false;
			}
		}
		return true;
	}
}
