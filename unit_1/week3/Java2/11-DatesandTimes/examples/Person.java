package examples;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
	private String name;
	private LocalDate birthDate;
	
	public Person(String name, String birthDate) {
		this.name = name;
		DateTimeFormatter formatter = 
				DateTimeFormatter.ofPattern("MM/dd/yyyy");
		this.birthDate = 
				LocalDate.parse(birthDate, formatter);
	}
	
	public String toString() {
		DateTimeFormatter formatter = 
				DateTimeFormatter.ofPattern("MM-dd-yyyy");
		return "Name: " + name + ", birth date: " + 
						formatter.format(birthDate);
	}
	
	public static void main(String[] args) {
		Person p = new Person("John Doe", "12/22/2016");
		System.out.println(p);
	}
}
