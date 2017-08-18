## LocalTime

* `LocalTime` is similar to `LocalDate`, except it stores hour, minute and second values.

  * The static `of()` method is overloaded to pass in just the hour and minute, or, the hour, minute, and second.

  ```java
  LocalTime oneThirty = LocalTime.of(13, 30);
  ```

  * Like `LocalDate`, use the `now()` method to get the current time.

  ```java
  LocalTime rightNow = LocalTime.now();
  ```

* Both `LocalDate` and `LocalTime` are immutable; any method you call that seems to modify the object actually builds a new instance and returns it to you.

```java
LocalTime twoThirty = oneThirty.plusHours(1);
```

* You can also create a combined `LocalDateTime` object either by passing all of the necessary values to its static `of()` method or by using an overload that takes `LocalDate` and `LocalTime` objects.

```java
LocalDateTime ldt = LocalDateTime.of(2016, 12, 1, 10, 30);
LocalDate christmas = LocalDate.of(2016, 12, 25);
LocalTime oneThirty = LocalTime.of(13, 30);
ldt = LocalDateTime.of(christmas, oneThirty);
```

<hr>

```java
package examples;

import java.time.*;

public class DateDemo {
  public static void main(String[] args) {
    ...
    // LocalTime
    LocalTime oneThirty = LocalTime.of(13, 30, 0);
    LocalTime twoThirty = oneThirty.plusHours(1);

    System.out.println("\nLocalTime: ");
    System.out.println(oneThirty);
    System.out.println(twoThirty);

    // LocalDateTime
    LocalDateTime ldt = LocalDateTime.of(christmas, twoThirty);
    LocalDateTime ldt2 = LocalDateTime.of(2016, 12, 1, 10, 30);

    System.out.println("\nLocalDateTime: ");
    System.out.println(ldt);
    System.out.println(ldt2);
    ...
  }
}
```

#### Note

You can also use an `Instant` object to represent a time based on the number of seconds since January 1, 1970. Use the `ofEpochSecond()` method, passing in an `int`, to create an `Instant`.

[Prev](LocalDate.md) | [Up](../README.md) | [Next](DurationandPeriod.md)

