## List Implementation Classes

* An `ArrayList` is a resizable array that implements the `List` interface.
  
  * An `ArrayList` follows an indexed ordering scheme similar to arrays.
  
  * It resembles the legacy container class `Vector`.
    
    * `Vector` methods are `synchronized` for thread safety, while `ArrayList` methods are not.
  
  * Use an `ArrayList` when an application frequently needs to retrieve an element from the middle of the `List`.
    
    * Positional access is fast, because each element in an `ArrayList` is associated with an index.

* The `LinkedList` class implements a doubly-linked list.
  
  * Like `ArrayList` objects, `LinkedList` objects can have duplicates and maintain the order of elements.
  
  * `LinkedLists` are useful when an application needs to frequently insert elements into the beginning or the end of the list.
    
    * Positional access is slower with `LinkedList` than with `ArrayList`, because only head and tail references are maintained.

<hr>

```java
package examples;

public class Planet {
    private final String name;
    private final long orbit;
    private final int diameter;

    public Planet(String name, long orbit, int diameter) {
        this.name = name;
        this.orbit = orbit;
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return name;
    }
    // ... gets/sets
}
```

```java
package examples;

import java.util.ArrayList;
import java.util.List;

public class PlanetTest {
    public void printPlanets() {
        List<Planet> planets = new ArrayList<>();
        // List<Planet> planets = new LinkedList<>();

        planets.add(new Planet("Mercury", 57_910_000, 4_880));
        planets.add(new Planet("Venus", 108_200_000, 12_103));
        planets.add(new Planet("Earth", 149_600_000, 12_756));
        planets.add(new Planet("Mars", 227_940_000, 6_794));
        planets.add(new Planet("Jupiter", 778_330_000, 142_984));
        planets.add(new Planet("Saturn", 1_429_400_000, 120_536));
        planets.add(new Planet("Uranus", 2_870_990_000L, 51_118));
        planets.add(new Planet("Neptune", 4_504_000_000L, 49_532));

        System.out.println("Num Planets: " + planets.size());
        for (Planet planet : planets) {
            System.out.println(planet);
        }
    }

    public static void main(String[] args) {
        PlanetTest pt = new PlanetTest();
        pt.printPlanets();
    }
}
```

[Prev](Collections.md) | [Up](../README.md) | [Next](Labs.md)

