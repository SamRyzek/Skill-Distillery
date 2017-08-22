package examples;

import java.util.Collections;
import java.util.List;

public class PrintSortedPlanetsLambda {

	public static void main(String[] args) {
		List<Planet> planets = PlanetUtilities.getPlanets();

		Collections.sort(planets, 
				(Planet a, Planet b) -> 
					a.getOrbit() > b.getOrbit() ? 1 : -1);

		for (Planet planet : planets) {
			System.out.println(planet);
		}
	}
}