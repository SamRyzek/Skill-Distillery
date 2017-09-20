## Transaction Management

* A DBMS can log all DML operations in a session as part of a transaction.

  * At your request, the DBMS will either:

    * Commit the entire transaction, making your operations permanent and visible to other users.

    * Rollback the entire transaction, completely undoing all DML operations.

  * When you commit or rollback a transaction, a new transaction can begin.

* The default behavior of a `Connection` object is to automatically commit after executing each statement.

  * In this case, each statement is a single, independent transaction.

* To turn off autocommit mode, use `setAutoCommit(false)`.

  * You can then use the `commit()` or `rollback()` methods of your `Connection` object to manage your transactions.

  * The `getAutoCommit()` method of your `Connection` object returns true when autocommit mode is on.

<hr>

```java
package examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transactions {
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
      PreparedStatement st = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
      st.setInt(1, storeId);
      int uc = st.executeUpdate();
      System.out.println(uc + " actor records created.");
      ResultSet keys = st.getGeneratedKeys();
      String sql2 = "INSERT INTO film_actor (film_id, actor_id) " + " VALUES (?,?)";
      PreparedStatement stmt2 = conn.prepareStatement(sql2);
      int filmId = 859;
      stmt2.setInt(1, filmId); // They were all in this film
      while (keys.next()) {
        int actorId = keys.getInt(1);
        System.out.println("New actor ID: " + actorId);
        stmt2.setInt(2, actorId);
        uc = stmt2.executeUpdate();
        if (uc == 1) {
          System.out.println("Actor " + actorId + " added to film " + filmId);
        }
      }
      // If we made it this far, no exception occurred.
      conn.commit(); // Commit the transaction
    }
    catch (SQLException e) {
      // Something went wrong.
      System.err.println("Error during inserts.");
      e.printStackTrace();
      // Need to rollback, which also throws SQLException.
      if (conn != null) {
        try {
          conn.rollback();
        }
        catch (SQLException e1) {
          System.err.println("Error rolling back.");
          e1.printStackTrace();
        }
      }
    }
  }

  public static void main(String args[]) {
    Transactions demo = new Transactions();
    demo.runSQL();
  }
}
```

In most cases, autocommit is not desirable — you don't have the ability to check errors and warnings and program appropriately, or to treat multiple individual statements as parts of a single transaction, or to set transaction savepoints (if your DBMS supports them).

#### Transaction Side Effects

* Some DBMSs, notably Oracle, automatically commit the current transaction any time you execute a DDL statement.
* Committing or rolling back the current transaction frees all locks.
* Committing the current transaction frees the update locks associated with an updatable cursor, thus forcing the cursor closed.

[Prev](GeneratedKeys.md) | [Up](../README.md) | [Next](SQLException.md)
