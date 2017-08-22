package examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterPresidents {
	public static List<President> filterPresidents(List<President> presidents,
			Predicate<President> predicate) {
		List<President> tempList = new ArrayList<>();
		for (President president : presidents) {
			if (predicate.test(president))
				tempList.add(president);
		}
		return tempList;
	}
	
	public static void main(String[] args) {
		ParsePresidents parser = new ParsePresidents();
		parser.parse();
		List<President> presidentsList = parser.getPresidents();
		
		class RepublicanPredicate implements Predicate<President> {
			public boolean test(President p) {
				return p.getParty().equals("Republican");
			}
		}
		
		List<President> filteredList = filterPresidents(presidentsList, 
				new RepublicanPredicate());
		
		for (President president : filteredList) {
			System.out.println(president);
		}
	}
}
