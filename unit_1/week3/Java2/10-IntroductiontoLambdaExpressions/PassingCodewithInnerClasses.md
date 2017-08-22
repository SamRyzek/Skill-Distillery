## Passing Code with Inner Classes

* Before Java 8, if you wanted to pass functionality to a method, you would have to wrap it in an inner class.

```java
class OrbitComparator implements Comparator<Planet> {
  public int compare(Planet a, Planet b) {
    return a.getOrbit() > b.getOrbit() ? 1 : -1;
  }
}
Collections.sort(planets, new OrbitComparator());
```

  * The `Collections.sort()` method, for example, takes an instance of a `Comparator` as an argument to describe the comparison logic.

  * The syntax is clumsy, especially when you use anonymous inner classes.

<hr>

PrintSortedPlanets.java
```java
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
```

#### Try It:
Run PrintSortedPlanets to list the planets in orbit order.

[Prev](README.md) | [Up](../README.md) | [Next](PassingCodewithLambdas.md)

