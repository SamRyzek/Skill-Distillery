## Standard Functional Interfaces

* Java 8 provides a number of functional interfaces as part of the `java.util.function` package.

* You can reuse the `Predicate` interface rather than write your own.

```java
@FunctionalInterface
public interface Predicate<T> {
  public boolean test(T t);
}
```

* Use the `BiPredicate` interface when you need to pass in two arguments and get a `boolean` result.

```java
@FunctionalInterface
public interface BiPredicate<T, U> {
  public boolean test(T t, U u);
}
```

* Use the `Function` interface when you want to specify the result type as a generic as well.

```java
@FunctionalInterface
public interface Function<T,R> {
  public R apply(T t);
}
```

* Avoid the extra overhead of boxing to a wrapper class by using the primitive specific version of each interface.

```java
@FunctionalInterface
public interface IntFunction<R> {
  public R apply(int value);
}
```

* See the documentation for the `java.util.function` package for more.

<hr>

#### Hands On:

Since Java already provides a `Predicate` interface, delete the one you wrote yourself and instead add an import at the top of your `PlanetUtilities` class for the `java.util.function.Predicate`. If you run PrintBigPlanets again, it will work like before.

```java
...
import java.util.function.Predicate;

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

As of Java 8, you can add "default" methods to interfaces. Unlike other interface methods which are implicitly abstract, a method declared with the default keyword has implementation code.

One example of a default method is the `negate()` method in the `Predicate` interface. It will perform the logical negation of the predicate it is contained in. Try it out by modifying your PlanetUtilities program again and then re-run the PrintBigPlanets program.

```java
    ...
      if (ps.negate().test(planet)) {
        tempList.add(planet);
      }
    ...

```

[Prev](GeneralizingtheFunctionalInterface.md) | [Up](../README.md) | [Next](Labs.md)

