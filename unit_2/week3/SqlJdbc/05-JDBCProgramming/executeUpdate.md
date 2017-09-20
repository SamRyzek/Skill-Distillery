## Executing SQL Updates

* Use Statement's executeUpdate() method to run SQL statements that do not generate result sets.

  * Data Manipulation Language (DML): INSERT, UPDATE, DELETE.

    ```java
    stmt.executeUpdate("DELETE FROM staff WHERE id = 55");
    ```

  * Data Definition Language (DDL): CREATE, ALTER, DROP, GRANT, REVOKE.

    ```java
    stmt.executeUpdate("GRANT SELECT ON sdvid.staff TO '%'@'localhost'");
    ```

* `executeUpdate()` returns an `int`, the update count, which is one of two values:

  ```java
  int uc;
  uc = stmt.executeUpdate( "UPDATE film "
                           + " SET rental_rate = rental_rate + 1 "
                         + " WHERE language_id = 3");
  ```
  * The number of rows affected by a DML statement.

    * This may validly be 0 if no rows match an UPDATE or DELETE statement's WHERE clause or an INSERT's subquery returns no rows.

  * 0 for DDL or other statements.

* `executeUpdate()` throws an exception if you use it to run a SELECT or other statement that generates a result set.

<hr>

[Prev](ResultSetMetaData.md) | [Up](../README.md) | [Next](GeneratedKeys.md)
