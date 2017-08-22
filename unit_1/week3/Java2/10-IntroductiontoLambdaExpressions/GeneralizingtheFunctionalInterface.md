## Generalizing the Functional Interface

* Interfaces are more reusable if you choose more general names for the interface itself and for its methods.

  * One popular interface name is `Predicate` based on the mathematical concept of a function that returns a boolean value.

  * Use generics for your method parameters and return types to make further gains in reusability.

  ```java
  @FunctionalInterface
  public interface Predicate <T> {
    public boolean test(T t);
  }
  ```

<hr>

#### Hands On:

Refactor your `PlanetSizer` interface to be named `Predicate`. Change the method from `isBigPlanet()` to `test()`. Add the parameterized type T instead of Planet.

```java
package examples;

@FunctionalInterface
public interface Predicate <T> {
  public boolean test(T t);
}
```

Now, update `PlanetUtilities.filterPlanets()` to take a `Predicate` rather than a `PlanetSizer` as a parameter. Also update the if statement to call the `test()` method instead of `isBigPlanet()`.

```java
...
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
  ...
}
```

Notice that your `PrintBigPlanets` class is unchanged because the lambda expression is based on the function descriptor (parameter and return types) rather than on names.

[Prev](FunctionalInterface.md) | [Up](../README.md) | [Next](StandardFunctionalInterfaces.md)

