## Finishing Up

* Typically, the open cursor associated with a `ResultSet` object consumes DBMS resources (locks, shared memory, temporary table space, etc.).

* `Connection` and `Statement` objects also hold DBMS and local resources.

* When a `Connection`, `Statement`, or `ResultSet` object goes out of scope, it is subject to Garbage Collection.

  * Garbage Collection should free the resources associated with a Java database object, but . . .

  * Don't count on Garbage Collection: free cursor and other resources explicitly when your program is finished with them.

  * Each interface provides a `close()` method to do this.

* When a `Statement` is closed, any `ResultSet`s associated with it are automatically closed.

* Closing a `Connection` normally disconnects you from the database.

* For simple database operations you can use try-with-resources syntax to automatically close your `Connection`, `Statement`, and/or `ResultSet`.

  * Embed the declarations of the `Closeable` resources within a set of parenthesis after the try keyword.

    ```java
    try (Connection c = DriverManager.getConnection(URL);
         PreparedStatement stmt = c.prepareStatement(sqltxt);
         ResultSet rs = stmt.executeQuery();) {
      ...
    }
    ```

  * Omit the explicit calls to the `close()` methods on these resources.

<hr>

```java
  //...
  try {
    conn = DriverManager.getConnection(URL, user, pword);
    stmt = conn.prepareStatement(sqltxt);
    rs = stmt.executeQuery();
    while (rs.next()) {
      System.out.println(rs.getString(1) + " "
                        + rs.getString(2) + " " + rs.getString(3));
    }
    rs.close();
    stmt.close();
  }
  catch (SQLException e) {
    System.err.println(e);
  }
  finally {
    try {
      if (rs != null) { rs.close(); }
      if (stmt != null) { stmt.close(); }
      if (conn != null) { conn.close(); }
    }
    catch (SQLException sqle) {
      System.err.println(sqle);
    }
  }
  //...
```
Like most I/O and networking classes, these JDBC objects implement the `AutoClosable` interface which means they have a `void close()` method. In "try-with-resources" syntax you instantiate `AutoClosable` objects in the try statement; Java will automatically invoke their `close()` methods when the block completes:

```java
  //...
  try (Connection conn=DriverManager.getConnection(URL,user,pword);
        PreparedStatement stmt = conn.prepareStatement(sqltxt);
        ResultSet rs = stmt.executeQuery(); ) {
    while (rs.next()) {
      System.out.println(rs.getString(1) + " "
                          + rs.getString(2) + " " + rs.getString(3));
    }
  }
  catch (SQLException e) {
    System.err.println(e);
  }
  //...
```

[Prev](JDBCTypes.md) | [Up](../README.md) | [Next](Lab.md)
