## Creating a SQL Query

* To execute SQL statements, create a `Statement` object.

  * Use `Connection`'s `createStatement()` method to do so.

* The `Statement` interface provides methods for executing SQL queries and updates.

  * The methods we'll use for now take a single String argument: a SQL statement.

* You can reuse a `Statement` object to execute additional SQL statements.

  * SQL executed by a `Statement` object is parsed and compiled by the DBMS on each execution.

  * You can use a single `Statement` object to execute any number of SQL statements at different points in your program.

<hr>

### Hands On:
Declare a `String` variable. This will be the text of the SQL statement. Use `Connection.createStatement()` to create a `Statement` object.

```java
package examples;
import java.sql.*;
public class JDBCTest {
  private static String url = "jdbc:mysql://localhost:3306/sdvid";

  public JDBCTest() throws ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
  }

  public static void main(String args []) throws ClassNotFoundException, SQLException {
    JDBCTest tester = new JDBCTest();
    tester.showStaff();
  }

  public void showStaff() throws SQLException {
    String user = "student";
    String pass = "student";
    Connection conn = DriverManager.getConnection(url,user,pass);
    String sqltxt;
    sqltxt = "SELECT id, first_name, last_name FROM staff";
    Statement stmt = conn.createStatement();
    conn.close();
  }
}
```

[Prev](Connection.md) | [Up](../README.md) | [Next](ResultSet.md)
