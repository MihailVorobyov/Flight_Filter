package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Flight> flightList = FlightBuilder.createFlights();
		
		Filter<Flight> f = new FilterImpl();
		
		System.out.println("Исключите из тестового набора перелёты по следующим правилам:");
		
		System.out.printf("\n1.\tвылет до текущего момента времени(%s)\n\n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
		System.out.println(f.filter(flightList, new DepartureBeforeNowFilter()));
		
		System.out.println("\n2.\tимеются сегменты с датой прилёта раньше даты вылета\n");
		System.out.println(f.filter(flightList, new ArriveBeforeDepartureFilter()));
		
		System.out.println("\n3.\tобщее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)\n");
		System.out.println(f.filter(flightList, new GroundTimeMoreThenHoursFilter(2)));
	}
}
