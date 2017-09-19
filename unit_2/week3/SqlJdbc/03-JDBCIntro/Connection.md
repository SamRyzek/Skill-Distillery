## Connecting to the Database

* To connect your Java program to the database invoke the `DriverManager.getConnection()` static method.

  * `getConnection()` takes a String argument (the URL for a connection) and returns a Connection object.

    ```java
    String URL = "jdbc:mysql://localhost:3306/sdvid";
    Connection conn = DriverManager.getConnection(URL);
    ```

  * Authentication information (username, password) may be embedded in the URL, or may be passed as separate arguments to `getConnection()`.

* `DriverManager` will load any available `Driver` implementations and ask each to connect to the URL.

  * To make sure your desired Driver class is loaded use Class.forName().

    ```java
    Class.forName("vendorpackage.Driver");
    ```

    * `Class.forName()` throws `ClassNotFoundException`.

    * When it loads, the driver will register itself with the `DriverManager`.

<hr>

### Hands On:
Use the constructor to make sure our database driver loads and registers with the `DriverManager`. `Class.forName()` throws `ClassNotFoundException`, so we'll declare both the constructor and `main()` as throwing it.

We will use methods that throw `SQLException`. For now, rather than catching it, just declare `main()` as throwing it as well. Declare a `String` field named URL and initialize it with the correct connection URL for your classroom database. Use the URL to obtain a connection from the `DriverManager`.

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

  public void showStaff() {
    String user = "student";
    String pass = "student";
    Connection conn = DriverManager.getConnection(url,user,pass);
    conn.close();
  }
}
```

Note:
This code uses the MySQL Connector Java driver. Other drivers will require different URL strings, and may require a username and password to get the connection. Your instructor will provide the specific connection URL for your environment as well as instructions for starting the database.

[Prev](DBPrograms.md) | [Up](../README.md) | [Next](Statement.md)
