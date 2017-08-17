## Tuning ArrayList

* When an `ArrayList` is instantiated, a Java language array is created to store the list elements.

* The no-arg constructor creates an array of size ten by default.

  * Each time the size of the `ArrayList` exceeds the length of the underlying array, the array must grow.

    1. Memory is allocated for a new array based on the formula: newCapacity = (oldCapacity * 3)/2 + 1.

    2. A `System.arraycopy()` is performed to move the elements to the new array.

    3. The old array is eligible for Garbage Collection.

* Pass an `int` to the `ArrayList` constructor to specify an initial size of the array to minimize the growth.

```java
List<String> states = new ArrayList<>(50);
```

  * You can also use the `ensureCapacity(int)` method to grow the array independent of the constructor.

* The `trimToSize()` method can be used to shrink the underlying array to the actual size of the `ArrayList` in order to conserve memory.

  * A new array is allocated to the size of the `ArrayList` and an `arraycopy()` is performed.

<hr>

```java
package examples;

import java.util.ArrayList;
import java.util.List;

public class Rainfall {
    public static void main(String[] args) {
        List<Float> monthlyRainfall = new ArrayList<>(12);

        monthlyRainfall.add(5.41F);
        monthlyRainfall.add(4.78F);
        monthlyRainfall.add(6.39F);
        monthlyRainfall.add(3.91F);
        monthlyRainfall.add(4.38F);
        monthlyRainfall.add(6.37F);
        monthlyRainfall.add(7.99F);
        monthlyRainfall.add(6.60F);
        monthlyRainfall.add(5.83F);
        monthlyRainfall.add(3.96F);
        monthlyRainfall.add(4.46F);
        monthlyRainfall.add(3.92F);

        float total = 0.0F;
        for (float amount : monthlyRainfall) {
            total += amount;
        }
        System.out.println("Pensacola, FL");
        System.out.printf("Avg monthly rainfall  = %.2f\n",
                total / 12.0);
        System.out.printf("Total yearly rainfall = %.2f\n", total);
    }
}
```

[Prev](SortingwithComparable.md) | [Up](../README.md) | [Next](TuningHashMapandHashSet.md)

