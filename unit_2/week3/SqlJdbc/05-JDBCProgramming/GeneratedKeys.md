## Retrieving Generated Keys

* When inserting rows in a table with an `AUTO_INCREMENT` primary key, you often want to retrieve the newly-generated key.

* You can tell JDBC to capture these keys when it executes your INSERT.

  * Pass the constant `Statement.RETURN_GENERATED_KEYS` to executeUpdate():

    ```java
    int rowCount = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
    ``` 

* The key or keys (an insert using a subquery might create multiple rows) are returned via a `ResultSet` object:

  * Iterate over this result set as you would with query results:

    ```java
    ResultSet keyList = stmt.getGeneratedKeys();
    while (keyList.next()) {
       int newKey = keyList.getInt(1);
       ...
    ```

<hr>

_GeneratedKeys.java_

```java
package examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GeneratedKeys {
  public void runSQL() {
    String url = "jdbc:mysql://localhost:3306/sdvid";
    String user = "student";
    String pword = "student";
    int storeId = 4;
    // Employees at store 4 were in a movie, now they're actors!
    String sql = "INSERT INTO actor (first_name, last_name) "
                   + " SELECT first_name, last_name FROM staff WHERE store_id=?";
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url, user, pword);
      conn.setAutoCommit(false); // Start transaction
      PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      st.setInt(1, storeId);
      int uc = st.executeUpdate();
      System.out.println(uc + " actor records created.");
      // Now get the auto-generated actor IDs:
      ResultSet keys = st.getGeneratedKeys();
      while (keys.next()) {
        System.out.println("New actor ID: " + keys.getInt(1));
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void main(String args[]) {
    GeneratedKeys demo = new GeneratedKeys();
    demo.runSQL();
  }
}
```

[Prev](executeUpdate.md) | [Up](../README.md) | [Next](TransactionManagement.md)
