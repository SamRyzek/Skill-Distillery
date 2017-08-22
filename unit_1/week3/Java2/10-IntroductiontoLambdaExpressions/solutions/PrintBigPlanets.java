package solutions;

import java.util.List;
import examples.Planet;

public class PrintBigPlanets {
	public static void main(String[] args) {
		List<Planet> planets = PlanetUtilities.getPlanets();
		List<Planet> bigPlanets = 
				PlanetUtilities.filterPlanets(planets, 
						(a) -> a.getOrbit() > 200_000_000);
		for (Planet planet : bigPlanets) {
			System.out.println(planet);
		}
	}
}