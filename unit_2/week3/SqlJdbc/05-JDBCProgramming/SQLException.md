## Error Handling and SQLException

* A runtime error from the DBMS triggers a `SQLException`.

* The `SQLException`'s methods provide the standard DBMS error information:

  * `getErrorCode()` returns the vendor-specific SQLCODE error code.

  * `getMessage()` is overridden by the `SQLException` class to return the vendor-specific error message.

  * `getSQLState()` returns the ISO-standard [SQLSTATE](https://en.wikibooks.org/wiki/Structured_Query_Language/SQLSTATE) value.

* Most methods defined under `java.sql` throw `SQLException`
  * Assume that your JDBC code needs to either catch or declare `SQLException`.

<hr>

```java
package examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HandleSQLException {
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
      // e.printStackTrace();
      System.err.println("SQL Error: " + e.getErrorCode() + ": "+ e.getMessage());
      System.err.println("SQL State: " + e.getSQLState());
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
    HandleSQLException demo = new HandleSQLException();
    demo.runSQL();
  }
}
```

Database programmers rely on a simple mechanism for obtaining error information from the database engine: after every database operation, the DBMS sets an error value that the programmer can check. An error is typically identified by a numeric error code (SQLCODE) and a brief error message. By convention, DBMS error codes are negative numbers; a SQLCODE value of 0 means no error has occured; and a special value, typically (but not always) +100, means there was no error, but no data was found to satisfy the operation.

SQLCODE values are vendor-specific, however, so programmers must learn the specific code values for each product they program against. To relieve this situation, standards organizations introduced the SQLSTATE, a standardized, 5-character string encoding the error condition.

Most DBMSs now implement SQLSTATE, though all still also return their own, vendor-specific, SQLCODE values and messages.

With JDBC, when you call certain methods, the driver automatically checks the SQLSTATE/SQLCODE and throws a `SQLException` when there's an error.

[Prev](TransactionManagement.md) | [Up](../README.md) | [Next](Lab.md)
