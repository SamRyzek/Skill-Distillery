## Getting the Results

* Executing a SQL query (that is, a SQL SELECT statement) produces a result set — a "virtual table" consisting of the rows and column values retrieved by the SELECT statement.

* If you are making a SQL query, use `Statement`'s `executeQuery()` method.

  * `executeQuery()` takes a String argument, the SQL SELECT statement.

  * `executeQuery()` returns a `ResultSet` object.

  * The `ResultSet` object represents the opened cursor for the SQL query.

* Use your `ResultSet` object's `next()` method to retrieve each row, in turn, of the result set.

  * `next()` returns false after the last row has been returned.

* `ResultSet`'s `getString(col)` method returns the `String` value of the column whose name or number (left-to-right, starting with 1, as listed in the SELECT clause) is `col`.

  * Other `ResultSet` `getXXX()` methods return DBMS values as different Java datatypes, performing any necessary conversion.

* The `close()` method of either the ResultSet or its Statement closes the cursor and frees resources.

<hr>

### Hands On:

Use a `while` loop to fetch each row of results, and access the column values in that row.

```java
//...

  public void showStaff() throws SQLException {
    String user = "student";
    String pass = "student";
    Connection conn = DriverManager.getConnection(url,user,pass);
    String sqltxt;
    sqltxt = "SELECT id, first_name, last_name FROM staff";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sqltxt);
    while(rs.next()) {
      System.out.println(rs.getString(1) + " " +
                         rs.getString(2) + " " +
                         rs.getString(3));
    }
    rs.close();
    stmt.close();
    conn.close();
  }

//...
```

[Prev](Statement.md) | [Up](../README.md) | [Next](PreparedStatement.md)
