package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import examples.ParsePresidents;
import examples.President;

public class ShortTermPresidents {
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
		
		List<President> filteredList = filterPresidents(presidentsList, 
				(p) -> p.getEndTerm() - p.getStartTerm() < 4);
		
		for (President president : filteredList) {
			System.out.println(president);
		}
	}
}
