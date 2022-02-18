package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FilterJUnitTest {
	
	private final List<Flight> flightList;
	private final Filter<Flight> f;
	
	public FilterJUnitTest() {
		this.flightList = FlightBuilder.createFlights();
		this.f = new FilterImpl();
	}
	
	@Test
	void shouldReturnFlightListWithout2() {
		List<Flight> actual = f.filter(flightList, new DepartureBeforeNowFilter());
		List<Flight> expectedList = new ArrayList<>(flightList);
		expectedList.remove(2);
		
		Assertions.assertEquals(expectedList, actual);
	}
	
	@Test
	void shouldReturnFlightListWithout3() {
		List<Flight> actual = f.filter(flightList, new ArriveBeforeDepartureFilter());
		List<Flight> expectedList = new ArrayList<>(flightList);
		expectedList.remove(3);
		
		Assertions.assertEquals(expectedList, actual);
	}
	
	@Test
	void shouldReturnFlightListWithout4() {
		List<Flight> actual = f.filter(flightList, new GroundTimeMoreThenHoursFilter(2));
		List<Flight> expectedList = new ArrayList<>(flightList);
		expectedList.remove(4);
		
		Assertions.assertEquals(expectedList, actual);
	}
}
