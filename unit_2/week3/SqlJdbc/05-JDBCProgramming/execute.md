## Executing Ad Hoc SQL

* `Statement`'s `execute()` method is the most general way to execute SQL.

* `execute()` executes any arbitrary SQL string.

  * It may generate either a result set, an update count, a combination of any number of either, or even no results at all; for example:

    * A statement built dynamically at runtime, which you can't restrict to either a query or an update.

    * A stored procedure yielding multiple result sets or update counts (if the DBMS supports this).

* `execute()` returns a boolean.

  * `true` if the statement generated an initial result set.

  * `false` if the statement generated either an initial update count or no results at all.

* Use `getResultSet()` and `getUpdateCount()` to retrieve the actual results of the statement.

  * `getResultSet()` returns a `ResultSet` object if one is available, otherwise null.

  * `getUpdateCount()` returns an int: 0 or greater for DML or DDL, -1 if no update count is available.

<hr>

After an `execute()`, your `Statement` object has either a `ResultSet`, an update count, or neither. In addition, after you are finished with that result (either the `ResultSet` or the update count), there may be another result to retrieve and process. If you have no idea what to expect, you can still process all of your results:

_ExecuteExample.java_

```java
package examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteExample {
  public static void main(String args[]) {
    String url = "jdbc:mysql://localhost:3306/sdvid";
    String user = "student";
    String pword = "student";
    String sqlstring = readInSQLStatement();
    System.out.println("Executing SQL statement:\n" + sqlstring
        + "\n");
    try (Connection conn = DriverManager.getConnection(url,user,pword);
        Statement stmt = conn.createStatement();) {

      boolean haveResultSet = stmt.execute(sqlstring);
      if (haveResultSet) {
        ResultSet rs = stmt.getResultSet();
        ResultSetMetaData rsmd = rs.getMetaData();
        int cols = rsmd.getColumnCount();
        for (int col = 1; col <= cols; col++)
          System.out.print(rsmd.getColumnName(col) + "\t");
        System.out.println("");
        while (rs.next()) {
          for (int col = 1; col <= cols; col++) {
            System.out.print(rs.getString(col) + "\t");
          }
          System.out.println("");
        }
        rs.close();
      }
      else { // No result set.
        int uc = stmt.getUpdateCount();
        System.out.println(uc + " row(s) updated.");
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e.getErrorCode() + " " + e.getMessage());
    }
  }

  private static String readInSQLStatement() {
    String buf;
    StringBuilder sqlstring = new StringBuilder();
    try (BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));) {

      System.out.println("Enter a SQL statement. "
          + "To finish, enter 'q'");

      while ((buf = br.readLine()) != null) {
        if (buf.equals("q")) {
          break;
        }
        sqlstring.append(buf + " ");
      }
    }
    catch (IOException ioe) {
      ioe.printStackTrace();
      System.exit(1);
    }
    return sqlstring.toString();
  }
}
```

### Try It:
Run _ExecuteExample.java_. Enter a SELECT, INSERT, UPDATE, or DELETE SQL statement when prompted.

[Prev](README.md) | [Up](../README.md) | [Next](ResultSetMetaData.md)
