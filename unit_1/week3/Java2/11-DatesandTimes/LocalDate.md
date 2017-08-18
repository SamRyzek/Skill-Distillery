## LocalDate

* Java 8 introduced the `java.time` package as an alternative to the much maligned `Date` and `Calendar` classes from the `java.util` package.

* Use a `LocalDate` to represent a month/day/year combination.

  * Create a `LocalDate` object with the static `of()` method passing in the year, month and day.

    * Use 1 for January, 12 for December.

    ```java
    LocalDate christmas = LocalDate.of(2016, 12, 25);
    ```

    * Or, pass the month value using the `Month` enumeration.

    ```java
    LocalDate mayDay = LocalDate.of(2016, Month.MAY, 1);
    ```

  * If you want a `LocalDate` object that represents the current date, call the static `now()` method, instead.

  ```java
  LocalDate today = LocalDate.now();
  ```

  * Call various `get...()` methods to retrieve properties of your date.

  ```java
  Month month = today.getMonth();
  int day = today.getDayOfMonth();
  int year = today.getYear();
  ```

<hr>

DateDemo.java
```java
package examples;

import java.time.*;

public class DateDemo {

  public static void main(String[] args) {
    // LocalDate
    LocalDate christmas = LocalDate.of(2016, 12, 25);
    LocalDate mayDay = LocalDate.of(2016, Month.MAY, 1);
    LocalDate today = LocalDate.now();

    System.out.println("\nLocalDate: ");
    System.out.println(christmas);
    System.out.println(mayDay);
    System.out.println(today);
    ...
  }
}
```

[Prev](README.md) | [Up](../README.md) | [Next](LocalTime.md)

