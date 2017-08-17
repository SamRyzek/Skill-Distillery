## Sorting with Comparator

* Use `Comparable` if you can easily modify the source code for the objects you wish to sort.

  * If you don't have access to the source code, you can instead create a subclass of `java.util.Comparator` to specify the sorting behavior.

  ```java
  public class StringComparator implements Comparator<String> { }
  ```

  * You may also choose to write a `Comparator` in situations where you'd like to provide an alternative implementation for an existing `Comparable`.

* The class that implements the `Comparator` interface must define the `compare()` method.

```java
public int compare(String a, String b) { }
```

  * The method takes two parameters representing the two objects that need to be compared against each other and returns an `int`.

  * The method defines whether the first object is greater than, less than, or equal to the second object.

    * Returns a positive integer for greater than, a negative integer for less than, and zero for equal.

* When working with a `TreeSet` or a `TreeMap`, you can provide an additional argument to the constructor to specify the `Comparator` to be used for sorting.

```java
Comparator<String> comp = new StringComparator();
Set<String> set = new TreeSet<>(comp);
```

<hr>

```java
package examples;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {
    public int compare(String a, String b) {
        return a.toUpperCase().compareTo(b.toUpperCase());
    }
}
```

```java
package examples;

import java.util.Set;
import java.util.TreeSet;

public class SortStrings {

    public static void main(String[] args) {
        Set<String> students = new TreeSet<>();
        //  Set<String> students = new TreeSet<>(new StringComparator());
        students.add("James");
        students.add("Jack");
        students.add("joseph");
        students.add("Jim");
        students.add("Juan");


        for (String student : students) {
            System.out.println(student);
        }
    }
}
```

#### Try It:
Run SortStrings.java to see the names sorted in alphabetical order. Notice how lowercase letters sort after uppercase letters. Modify the code to use the `StringComparator` and run it again to see case- insensitive sorting.

[Prev](SortingwithComparable.md) | [Up](../README.md) | [Next](SortingListsandArrays.md)

