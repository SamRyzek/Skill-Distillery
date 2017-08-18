## DateTimeFormatter

* `LocalDate` and `LocalTime` both override the `toString()` method, so presentation is easy.

* You can, however, use the `DateTimeFormatter` to customize the output.

  * Pass a format string to the static `ofPattern()` method.

  ```java
  DateTimeFormatter formatter =
  DateTimeFormatter.ofPattern("MM/dd/yyyy");
  System.out.println(formatter.format(LocalDate.now()));
  ```

* The `DateTimeFormatter` is also useful to help with parsing a `String` to a `LocalDate` or `LocalTime`.

```java
LocalDate dt = LocalDate.parse("12/22/2016", formatter);
```

<hr>

```java
package examples;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
  private String name;
  private LocalDate birthDate;
 
  // Use a String in the constructor for the convenience of the caller:
  public Person(String name, String birthDate) {
    this.name = name;
    DateTimeFormatter formatter =
    DateTimeFormatter.ofPattern("MM/dd/yyyy");
    this.birthDate =
    LocalDate.parse(birthDate, formatter);
  }

  public String toString() {
    DateTimeFormatter formatter =
    DateTimeFormatter.ofPattern("MM-dd-yyyy");
    return "Name: " + name + ", birth date: " +
    formatter.format(birthDate);
  }

  public static void main(String[] args) {
    Person p = new Person("John Doe", "12/22/2016");
    System.out.println(p);
  }
}
```

Try It:

Run `Person.java` to see a `String` parsed into a `LocalDate` in the constructor and then the `LocalDate` converted back to a `String` in the `toString()` method.

[Prev](DurationandPeriod.md) | [Up](../README.md) | [Next](Labs.md)

