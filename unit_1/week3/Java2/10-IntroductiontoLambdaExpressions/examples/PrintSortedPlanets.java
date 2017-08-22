package examples;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrintSortedPlanets {

	public static void main(String[] args) {
		List<Planet> planets = PlanetUtilities.getPlanets();
		
		Collections.sort(planets, new Comparator<Planet>() {
			public int compare(Planet a, Planet b) {
				return a.getOrbit() > b.getOrbit() ? 1 : -1;
			}
		});
		
		for (Planet planet : planets) {
			System.out.println(planet);
		}
	}
}