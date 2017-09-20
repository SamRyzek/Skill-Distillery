## ResultSetMetaData

* To determine the number, types, names, etc. of columns of a `ResultSet`, get the `ResultSet`'s metadata.

  ```java
  ResultSetMetaData rsmd = rs.getMetaData();
  ```

* A `ResultSetMetaData` object's methods return information about the columns of its `ResultSet`.

  ```java
  int getColumnCount()
  String getColumnName(int column)
  String getColumnLabel(int column)
  int getColumnType(int column)
  String getColumnTypeName(int column)
  int getPrecision(int column)
  int getScale(int column)
  int getColumnDisplaySize(int column)
  int isNullable(int column)
  boolean isReadOnly(int column)
  boolean isCurrency(int column)
  ```
  etc...

  * All of these methods may throw SQLException.

* `getColumnType()` returns an int corresponding to a constant defined in `java.sql.Types`.

  * This can be useful in determining which getXXX() method to call.

* `ResultSetMetaData` is valuable when:

  * `execute()` was used to run some arbitrary query.

  * `executeQuery()` was used to run a query statement that was generated at runtime.

<hr>

```java
package examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;

public class ExecuteFormat {

  public static void main(String args[]) {

    String url = "jdbc:mysql://localhost:3306/sdvid";
    String user = "student";
    String pword = "student";
    try (Connection conn = DriverManager.getConnection(url,user,pword);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt
            .executeQuery("SELECT * FROM staff");) {

      ResultSetMetaData rsmd = rs.getMetaData();
      int cols = rsmd.getColumnCount();
      int colWidth[] = new int[cols];

      String resultLine = "";
      for (int col = 1; col <= cols; col++) {
        colWidth[col - 1] = getAppDisplayWidth(rsmd, col);
        resultLine += rPadTrunc(
            rsmd.getColumnName(col), colWidth[col - 1], ' ');
        if (col < cols) {
          resultLine += " ";
        }
      }
      System.out.println(resultLine);

      while (rs.next()) {
        resultLine = "";
        for (int col = 1; col <= cols; col++) {
          resultLine += rPadTrunc(rs.getString(col),
              colWidth[col - 1], ' ');
          if (col < cols) {
            resultLine += " ";
          }
        }
        System.out.println(resultLine);
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static int getAppDisplayWidth(ResultSetMetaData rsmd, int col)
      throws SQLException {

    switch (rsmd.getColumnType(col)) {
    case Types.NUMERIC:
    case Types.INTEGER:
      return 9;
    case Types.TIMESTAMP:
      return 22;
    case Types.DATE:
      return 10;
    case Types.TIME:
      return 8;
    default:
      return rsmd.getColumnDisplaySize(col);
    }
  }

  private static String rPadTrunc(String s, int len, char c) {
    if (s == null) {
      s = "";
    }
    if (len <= s.length()) {
      return s.substring(0, len);
    }
    StringBuilder sb = new StringBuilder(s);
    for (int k = 0; k < (len - s.length()); k++) {
      sb.append(c);
    }
    return sb.toString();
  }

}
```

[Prev](execute.md) | [Up](../README.md) | [Next](executeUpdate.md)
