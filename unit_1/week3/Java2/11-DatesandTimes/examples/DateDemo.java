package examples;

import java.time.*;

public class DateDemo {
	public static void main(String[] args) {
		// LocalDate
		LocalDate christmas = LocalDate.of(2016, 12, 25);
		LocalDate mayDay = LocalDate.of(2016, Month.MAY, 1);
		LocalDate today = LocalDate.now();
		
		System.out.println("\nLocalDate: ");
		System.out.println(christmas);
		System.out.println(mayDay);
		System.out.println(today);

		// LocalTime
		LocalTime oneThirty = LocalTime.of(13, 30, 0);
		LocalTime twoThirty = oneThirty.plusHours(1);
		
		System.out.println("\nLocalTime: ");
		System.out.println(oneThirty);
		System.out.println(twoThirty);
		
		// LocalDateTime
		LocalDateTime ldt = 
				LocalDateTime.of(christmas, twoThirty);
		LocalDateTime ldt2 = 
				LocalDateTime.of(2016, 12, 1, 10, 30);
		
		System.out.println("\nLocalDateTime: ");
		System.out.println(ldt);
		System.out.println(ldt2);

		// Duration and Period
		Period p1 = Period.between(LocalDate.of(2015, 1, 1), 
				LocalDate.now());
		Period p2 = Period.ofMonths(6);
		Duration d1 = Duration.between(LocalTime.of(12,30,20), 
				LocalTime.of(15,35,21));
		Duration d2 = Duration.between(
				LocalDateTime.of(2015,1,1,15,35,20),
				LocalDateTime.of(2016,1,1,12,30,20)); 

		System.out.println("\nPeriod and Duration: ");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(d1);
		System.out.println(d2);
	}
}

