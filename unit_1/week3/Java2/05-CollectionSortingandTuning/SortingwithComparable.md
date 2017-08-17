## Sorting with Comparable

* The `java.util` package defines two classes that allow you to create sorted collections.

  * The `TreeSet` implementation represents a sorted `Set`.

  * The `TreeMap` implementation sorts a `Map` based on the key.

* Both classes rely on each member of the collection implementing the `java.lang.Comparable` interface.

```java
public class Planet implements Comparable<Planet> { }
```

  * The `compareTo()` method defines whether the given object is greater than, less than, or equal to a passed-in object.

  ```java
  public int compareTo(Planet p) { }
  ```

    * Return a positive integer for greater than, a negative integer for less than, and zero for equal.

  * Each time an element is added to the collection, its `compareTo()` method is called and it is stored based on its relation to other members of the collection.

* Many of the Java SE library classes implement `Comparable`, including `String` and the primitive wrapper classes.

<hr>

```java
package examples;

public class Planet implements Comparable<Planet> {
    private final String name;
    private final long orbit;
    private final int diameter;

    public Planet(String name, long orbit, int diameter) {
        super();
        this.name = name;
        this.orbit = orbit;
        this.diameter = diameter;
    }

    public String getName() {
        return name;
    }

    public long getOrbit() {
        return orbit;
    }

    public int getDiameter() {
        return diameter;
    }

    @Override
    public int compareTo(Planet other) {
        if (this.orbit < other.orbit) {
            return -1;
        }
        else if (this.orbit > other.orbit) {
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + diameter;
        result = prime * result
                + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (int) (orbit ^ (orbit >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Planet other = (Planet) obj;
        if (diameter != other.diameter)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (orbit != other.orbit)
            return false;
        return true;
    }
}
```

```java
package examples;

import java.util.Set;
import java.util.TreeSet;

public class SortPlanets {

    public static void main(String[] args) {
        Set<Planet> planets = new TreeSet<>();

        planets.add(new Planet("Earth", 149_600_000, 12_756));
        planets.add(new Planet("Jupiter", 778_330_000, 142_984));
        planets.add(new Planet("Mars", 227_940_000, 6_794));
        planets.add(new Planet("Mercury", 57_910_000, 4_880));
        planets.add(new Planet("Neptune", 4_504_000_000L, 49_532));
        planets.add(new Planet("Saturn", 1_429_400_000, 120_536));
        planets.add(new Planet("Uranus", 2_870_990_000L, 51_118));
        planets.add(new Planet("Venus", 108_200_000, 12_103));
        
        for (Planet planet : planets) {
            System.out.println(planet);
        }
    }
}
```

#### Try It:
Run SortPlanets.java to list the planets from closest to farthest from the Sun.

[Prev](README.md) | [Up](../README.md) | [Next](SortingwithComparator.md)

