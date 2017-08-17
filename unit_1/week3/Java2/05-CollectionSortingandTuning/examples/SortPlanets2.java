package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPlanets2 {

    public static void main(String[] args) {
        List<Planet> planets = new ArrayList<>();

        planets.add(new Planet("Mercury", 57_910_000, 4_880));
        planets.add(new Planet("Venus", 108_200_000, 12_103));
        planets.add(new Planet("Mars", 227_940_000, 6_794));
        planets.add(new Planet("Earth", 149_600_000, 12_756));
        planets.add(new Planet("Jupiter", 778_330_000, 142_984));
        planets.add(new Planet("Saturn", 1_429_400_000, 120_536));
        planets.add(new Planet("Uranus", 2_870_990_000L, 51_118));
        planets.add(new Planet("Neptune", 4_504_000_000L, 49_532));

        PlanetDiameterComparator comparator = 
                new PlanetDiameterComparator();
        Collections.sort(planets, comparator);
        for (Planet planet : planets) {
            System.out.println(planet);
        }
    }
}
