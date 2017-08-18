## Duration and Period

* Use the static `Period.between()` method to get the time in days, months, and years between `LocalDates` as a `Period` object.

```java
Period p1 = Period.between(LocalDate.of(2015, 1, 1), LocalDate.now());
```

* Instead of calling the `between()` method, you can use one of several static `of()` methods to create a `Period` directly.

```java
Period sixMonths = Period.ofMonths(6);
```

* Similarly, you can get a `Duration` object to retrieve the amount of time between two `LocalTimes` or `LocalDateTimes` in hours, minutes, and seconds.

```java
Duration d1 = Duration.between(LocalTime.of(12,30,20), LocalTime.of(15,35,21));
```

<hr>

```java
package examples;

import java.time.*;

public class DateDemo {
  public static void main(String[] args) {
    ...
    // Duration and Period
    Period p1 = Period.between(LocalDate.of(2015, 1, 1),
                               LocalDate.now());
    Period p2 = Period.ofMonths(6);
    Duration d1 = Duration.between(LocalTime.of(12,30,20),
                                   LocalTime.of(15,35,21));
    Duration d2 = Duration.between(LocalDateTime.of(2015,1,1,15,35,20),
                                   LocalDateTime.of(2016,1,1,12,30,20));

    System.out.println("\nPeriod and Duration: ");
    System.out.println(p1);
    System.out.println(p2);
    System.out.println(d1);
    System.out.println(d2);
  }
}
```

[Prev](LocalDate.md) | [Up](../README.md) | [Next](DateTimeFormatter.md)

