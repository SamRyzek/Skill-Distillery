## Passing Code with Lambdas

* Use lambda expressions to simplify your Java 8 programs.

```java
Comparator<Planet> lambda =
  (Planet a, Planet b) ->
     a.getOrbit() > b.getOrbit() ? 1 : -1;
Collections.sort(planets, lambda);
```

* A lambda is an anonymous function that you can store in a variable or pass as an argument to a method.

  * It is anonymous because it has no name.

  * It can take zero or more parameters which are embedded in parenthesis and separated from the body by an arrow.

    * The parameter's datatype is optional since it can be inferred based on the context.

    ```java
    Comparator<Planet> lambda =
      (a, b) -> a.getOrbit() > b.getOrbit() ? 1 : -1;
    ```

  * The body is typically a single expression whose result is the lambda's return value.

  * You are allowed to embed multiple statements within the body, just use curly braces and, optionally, the return keyword as before.

  ```java
  Comparator<Planet> lambda = (a, b) -> {
    int result = 0;
    if (a.getOrbit() > b.getOrbit())
      result = 1;
    else if (a.getOrbit() < b.getOrbit())
      result = -1;
    return result;
  };
  ```

<hr>

PrintSortedPlanetsLambda.java
```java
package examples;

import java.util.Collections;
import java.util.List;

public class PrintSortedPlanetsLambda {
  public static void main(String[] args) {
    List<Planet> planets = PlanetUtilities.getPlanets();
    Collections.sort(planets,
      (Planet a, Planet b) -> a.getOrbit() > b.getOrbit() ? 1 : -1);
    for (Planet planet : planets) {
      System.out.println(planet);
    }
  }
}
```

#### Try It:

Run PrintSortedPlanetsLambda to display the planets in orbit order this time using a lambda expression rather than an inner class to specify the sort order.

[Prev](PassingCodewithInnerClasses.md) | [Up](../README.md) | [Next](FunctionalInterface.md)

