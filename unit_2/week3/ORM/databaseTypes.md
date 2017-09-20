## Mapping Database Data Types

* Relational databases support a variety of column datatypes, most of which have intuitive analogs in Java.

  ```
  mysql> describe actor;
  +------------+------------------+------+-----+---------+----------------+
  | Field      | Type             | Null | Key | Default | Extra          |
  +------------+------------------+------+-----+---------+----------------+
  | id         | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
  | first_name | varchar(45)      | NO   |     | NULL    |                |
  | last_name  | varchar(45)      | NO   | MUL | NULL    |                |
  +------------+------------------+------+-----+---------+----------------+
  ```

  ```java
  public class Actor {
    private int actorId;
    private String firstName;
    private String lastName;
    ...
  ```

  * With numeric types, choose a Java type that will accomodate the precision constraint of the database type.

    * `INTEGER` column types can be represented as `short`, `int`, or `long`.

    * `DECIMAL`, `FLOAT`, `DOUBLE`, `NUMBER`, etc. can be retrieved to a Java `float` or `double`.

  * The various text types like `CHAR` and `VARCHAR` work nicely as Java `String`s.

    * Note however that a Java `String` is not length-constrained, so an overlong `String` field may be truncated or even rejected when inserted into a length-constrained `VARCHAR` column.

  * For temporal database types (`DATE`, `TIME`, `DATETIME`, `TIMESTAMP`, etc.), JDBC defines the `java.sql.Date`, `java.sql.Time`, and `java.sql.Timestamp` classes.

    * Starting with Java8, these have methods to work with the corresponding `java.time` `LocalDate`, `LocalTime`, `LocalDateTime`, etc. classes.

      * `java.sql.Date.valueOf(LocalDate)`
      * `java.sql.Date.toLocalDate()`
      * `java.sql.Date.toInstant()`
      * `java.sql.Time.toLocalTime()`
      * `java.sql.TimeStame.toLocalDateTime()`
      * ...

    * JDBC has no direct support for database `INTERVAL` types or Java `Duration` or `Period`.

  * Just about any datatype can be retrieved as a `String` or `Object`.

<hr>

Other database datatypes may require more careful consideration for implementation in Java.

* For example, a `CLOB` (Character Large OBject) or `BLOB` (Binary Large OBject) in a database potentially may contain a gigantic value that's not practical to retrieve or store as a Java `String` or `byte[]`.

  * The `java.sql.Clob` and `java.sql.Blob` interfaces define functionality for handling these types using streams.

[Prev](retrieval.md) | [Up](../README.md) | [Next](nestedRetrieval.md)
