## ORM - Object-Relational Mapping

* In software development, Object-Relational Mapping is code that translates the entities (tables/rows) and attributes (columns) of a relational database schema to the objects and fields of an OO language application, and vice versa.

  * This may happen when writing new OO classes for an existing database schema.

  * Or, you may need to develop a new database schema to persist the state of objects of your existing OO classes.

* An important part of ORM is matching database column names to Java object field names.

  * Because most RDBMS have case-insensitive table and column names, database designers tend to use underscores to separate words in identifiers.

  * Typical Java ORM code maps these *snake_case* database column names to the corresponding *camelCase* Java field names

    ```sql
    CREATE TABLE actor (
      id INTEGER,
      first_name VARCHAR(45),
      last_name VARCHAR(45),
      ...
    ```
  
    ```java
    public class Actor {
      private int id;
      private String firstName;
      private String lastName;
      ...
    ```

* To reliably interact with the database, Java classes should have a field representing the corresponding table's primary key.

  * This key will be critical for database C.R.U.D. operations.

* One direct approach to Java ORM includes writing DAO implementation code that uses JDBC query results to assemble application objects, and to store an object use its fields as values in appropriate SQL INSERTs, UPDATEs, and DELETEs.

<hr>

[Up](../README.md) | [Next](retrieval.md)
