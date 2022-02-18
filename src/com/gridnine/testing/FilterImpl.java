package com.gridnine.testing;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterImpl implements Filter<Flight> {
	
	@Override
	public List<Flight> filter(List<Flight> flightList, Predicate<Flight> predicate) {
		return flightList.stream().filter(predicate).collect(Collectors.toList());
	}
}
