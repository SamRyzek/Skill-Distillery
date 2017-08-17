## Sorting Lists and Arrays

* Use `TreeSet` or `TreeMap` to sort `Set`s or `Map`s.

* To sort a `List`, pass it to the `sort()` method of the `Collections` class.

  * Use the one-parameter version of the `sort()` method if all elements of the `List` implement `Comparable`.

    * Otherwise, pass a `Comparator` as the second parameter.

* The `Arrays` class has multiple `sort()` methods defined to allow you to sort Java language arrays.

<hr>

```java
package examples;

import java.util.Comparator;

public class PlanetDiameterComparator implements Comparator<Planet> {
    public int compare(Planet a, Planet b) {
        if (a.getDiameter() < b.getDiameter())
            return -1;
        else if (a.getDiameter() > b.getDiameter())
            return 1;
        else
            return a.getName().compareTo(b.getName());
    }
}
```

```java
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
```

#### Try It:
Run SortPlanets2.java to list the planets from the smallest to the largest.

[Prev](SortingwithComparable.md) | [Up](../README.md) | [Next](CollectionsUtilityMethods.md)

