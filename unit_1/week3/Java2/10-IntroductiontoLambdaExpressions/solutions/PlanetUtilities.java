package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import examples.Planet;

public class PlanetUtilities {
	public static List<Planet> filterPlanets(List<Planet> list, Predicate<Planet> ps) {
		List<Planet> tempList = new ArrayList<>();
		for (Planet planet : list) {
			if (ps.test(planet)) {
				tempList.add(planet);
			}
		}
		return tempList;
	}
	
	public static List<Planet> getPlanets() {
		return Arrays.asList(
				new Planet("Mercury", 57_910_000, 4_880), 
				new Planet("Venus", 108_200_000, 12_103),
				new Planet("Earth", 149_600_000, 12_756), 
				new Planet("Mars", 227_940_000, 6_794),
				new Planet("Jupiter", 778_330_000, 142_984), 
				new Planet("Saturn", 1_429_400_000, 120_536),
				new Planet("Uranus", 2_870_990_000L, 51_118), 
				new Planet("Neptune", 4_504_000_000L, 49_532));
	}
}
