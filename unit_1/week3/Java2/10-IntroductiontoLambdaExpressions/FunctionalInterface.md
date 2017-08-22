## Functional Interface

* Use lambdas whenever a functional interface is required.

  * A functional interface contains only one abstract method.

  * Since there is only one abstract method, you can omit the name when you create your lambda which automatically implements the interface.

  * `Comparator`, `Runnable`, `Callable`, and `ActionListener` are examples of functional interfaces that you have recently seen.

* Create your own functional interface by simply building an interface with one abstract method.

  * You can optionally use the `@FunctionalInterface` annotation to ask the compiler to generate an error if the interface is not compliant.

<hr>

#### Hands On:

Create a functional interface called `PlanetSizer`:

```java
package examples;

@FunctionalInterface
public interface PlanetSizer {
  public boolean isBigPlanet(Planet p);
}
```

Modify `PlanetUtilities.java` and add another method that returns a list of all big planets by using a `PlanetSizer` parameter:

```java
...
public class PlanetUtilities {
  public static List<Planet> filterPlanets(List<Planet> list, PlanetSizer ps) {
    List<Planet> tempList = new ArrayList<>();
    for (Planet planet : list) {
      if (ps.isBigPlanet(planet)) {
        tempList.add(planet);
      }
    }
    return tempList;
  }
...
}
```

Create a new class called PrintBigPlanets.java whose main() method includes code that uses an inner class to get all big planets:

```java
package examples;

import java.util.List;

public class PrintBigPlanets {
  public static void main(String[] args) {
    class DiameterFilter implements PlanetSizer {
      public boolean isBigPlanet (Planet p) {
        return p.getDiameter() > 45_000;
      }
    }
    List<Planet> planets = PlanetUtilities.getPlanets();
    planets = PlanetUtilities.filterPlanets(planets, new DiameterFilter());
    for (Planet planet : planets) {
      System.out.println(planet);
    }
  }
}
```

Now, comment out your inner class and change the code to use a lambda expression instead :

```java
    ...
    List<Planet> planets = PlanetUtilities.getPlanets();
    planets = PlanetUtilities.filterPlanets(planets, (p) -> p.getDiameter() > 45_000);
    ...
```

[Prev](PassingCodewithInnerClasses.md) | [Up](../README.md) | [Next](GeneralizingtheFunctionalInterface.md)

