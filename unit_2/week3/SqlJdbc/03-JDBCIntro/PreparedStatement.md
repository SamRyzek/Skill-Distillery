## PreparedStatement and Statement Parameters

* You can execute a prepared statement multiple times with different values for where clause predicates or DML SET or VALUES clause parameters.

  * Use `Connection`’s `prepareStatement()` method to instantiate a `PreparedStatement` object.

  * When creating the statement, use a question mark, `?`, as a placeholder (also known as a _bind variable_) for a runtime parameter.

    ```java
    PreparedStatement pst;
    pst = conn.prepareStatement( "SELECT formal_name FROM country WHERE country_code = ?");
    ```

  * Use a `PreparedStatement`'s set_XXX_() methods, where _XXX_ is the Java datatype (the JDBC driver implicitly converts to the appropriate JDBC datatype).

    ```java
    String cCode = "IS";
    PreparedStatement pst;
    pst = conn.prepareStatement( "SELECT formal_name FROM country WHERE country_code = ?");
    pst.setString(1, cCode);
    ResultSet rs = pst.executeQuery();
    ```

    * The set_XXX_() methods take the index of the placeholder `?`, from left-to-right starting at 1, as the first argument.

    * String parameters do not need to be SQL single-quoted.

      ```java
      PreparedStatement pst2;
      pst2 = conn.prepareStatement( "SELECT formal_name FROM country "
                                  + " WHERE country_code LIKE ? OR country LIKE ?");
      pst2.setString(1, "U_");
      pst2.setString(2, "United%");
      ```

* A `PreparedStatement`’s SQL syntax is pre-parsed and compiled by the DBMS only once for repeated execution.

  * A `Statement`’s execute methods - `execute(sqlstr)`, `executeQuery(sqlstr)`, `executeUpdate(sqlstr)` - cause the DBMS to parse, compile, and execute the SQL syntax each time.

    * This can potentially lead to _SQL injection_ vulnerabilities, where maliciously constructed user input can be parsed as SQL syntax and executed.

      ```java
      String cCode = "foo'; DELETE FROM payment; -- ";  // Try to inject a DELETE statement
      String sql = "SELECT formal_name FROM country WHERE country_code = '" + cCode + "'";
      ```

  * Using `PreparedStatement` and bind variables is safer and more efficient than just concatenating user-provided data into a SQL string.

<hr>

### Hands On:

Modify `main()` to read in store numbers and pass them to the method:

  ```java
  public static void main(String args []) throws ClassNotFoundException, SQLException {
    JDBCTest tester = new JDBCTest();
    //tester.showStaff();
    Scanner input = new Scanner(System.in);
    int storeId = 0;
    do {
      System.out.print("Enter a store ID (0 to quit): ");
      storeId = input.nextInt();
      tester.showStaff(storeId);
    } while (storeId != 0);
  }
  ```

Modify `showStaff()` to take a store ID as a parameter, and use it with a `PreparedStatement`:

  ```java
  public void showStaff(int storeId) throws SQLException {
    String user = "student";
    String pass = "student";
    Connection conn = DriverManager.getConnection(URL, user, pass);
    // String sql = "SELECT id, first_name, last_name FROM staff";
    // Statement stmt = conn.createStatement();
    // ResultSet rs = stmt.executeQuery(sql);

    String sql = "SELECT id, first_name, last_name FROM staff WHERE store_id = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, storeId);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
    //...
  ```

[Prev](ResultSet.md) | [Up](../README.md) | [Next](JDBCTypes.md)
