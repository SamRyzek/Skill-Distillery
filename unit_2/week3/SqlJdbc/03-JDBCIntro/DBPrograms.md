## Database Programming

* Programmers writing applications that interact with a DBMS typically have four basic steps to complete:  

  1: Create variables for database data.  

  2: Connect to the DBMS.  

  3: Do whatever it is you need to do with the database data.  

  4: Disconnect from the DBMS.  

* If what you need to do with the database data is to retrieve a set of records, the basic steps are:  

  3.1: Declare a cursor — an object associated with a specific DBMS query statement.  

  3.2: Open the cursor — this executes the query statement, and identifies its result set.  

  3.3: Iterate through the records that make up the result set.  

  3.4: Close the cursor.  

* All of these standard database programming tasks are implemented simply in JDBC.

<hr>

### Hands On:

Create a new Java program, `JDBCTest.java`. Import `java.sql.*` so that you can use the JDBC API.  Add a `main()` method, and an instance method to do the work.

```java
package examples;
import java.sql.*;
public class JDBCTest {

  public static void main(String args []) {
    JDBCTest tester = new JDBCTest();
    tester.showStaff();
  }

  public void showStaff() {
  }
}
```

[Prev](JDBC.md) | [Up](../README.md) | [Next](Connection.md)

