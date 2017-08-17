## Collections Utility Methods

* In addition to `sort()`, the `Collections` class has many other utility methods defined for working with lists.

  * `reverse(list)` — reverses the order of the elements of the passed-in *list*.

  * `rotate(list, dist)` — rotates the elements of the passed-in *list* by the specified distance.

  * `shuffle(list)` — randomly shuffles the order of the elements of the passed-in *list*.

  * `binarySearch(list, object)` — uses a binary search algorithm to locate the given *object* within the *list*.

    * The `int` return value represents the index of the first match, if found; otherwise a negative number indicating where the object would have occured in the sorted list (see `java.util.Collections` in the JavaDocs).

    * For the algorithm to work properly, make sure to `sort()` the *list* before calling `binarySearch()`.

  * `fill(list, object)` — replaces all elements within the given *list* with the passed-in *object*.

* Other `Collections` methods are available for working with all of the collection

  * `synchronizedList(list)` — returns a thread-safe version of *list*.

    * Versions of this method exist for `Map` and `Set` as well.

  * `unmodifiableList(list)` — returns a read-only version of *list*.

    * Versions of this method also exist for `Map` and `Set`.

<hr>

The `Arrays` class contains many similar methods for use with Java language arrays.

```java
package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListPlanets {
    public static void main(String args[]) {
        new ListPlanets();
    }

    public ListPlanets() {
        List<Planet> planets = new ArrayList<>();

        planets.add(new Planet("Mercury", 57_910_000, 4_880));
        planets.add(new Planet("Venus", 108_200_000, 12_103));
        planets.add(new Planet("Mars", 227_940_000, 6_794));
        planets.add(new Planet("Earth", 149_600_000, 12_756));
        planets.add(new Planet("Jupiter", 778_330_000, 142_984));
        planets.add(new Planet("Saturn", 1_429_400_000, 120_536));
        planets.add(new Planet("Uranus", 2_870_990_000L, 51_118));
        planets.add(new Planet("Neptune", 4_504_000_000L, 49_532));

        System.out.println("\n**Original List**");
        printPlanets(planets);

        System.out.println("\n**After Reverse**");
        Collections.reverse(planets);
        printPlanets(planets);

        System.out.println("\n**After Rotate**");
        Collections.rotate(planets, 2);
        printPlanets(planets);

        System.out.println("\n**After Shuffle**");
        Collections.shuffle(planets);
        printPlanets(planets);
    }

    private void printPlanets(List<Planet> planets) {
        for (Planet planet : planets) {
            System.out.println(planet);
        }
    }
}
```

#### Note:
The `Collections` class is different from the `Collection` interface.

[Prev](SortingwithComparable.md) | [Up](../README.md) | [Next](TuningArrayList.md)

