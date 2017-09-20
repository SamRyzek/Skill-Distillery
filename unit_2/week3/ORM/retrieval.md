## Retrieval with JDBC

* Using SQL/JDBC to retrieve a database record (entity) as a Java object may involve no more than creating the object and setting its state using database column values.

  ```java
  public Actor getActorById(int actorId) {
    Actor actor = null;
    //...
    String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1,actorId);
    ResultSet actorResult = stmt.executeQuery();
    if (actorResult.next()) {
      actor = new Actor(); // Create the object
      // Here is our mapping of query columns to our object fields:
      actor.setId(actorResult.getInt(1));
      actor.setFirstName(actorResult.getString(2));
      actor.setLastName(actorResult.getString(3));
    }
    //...
    return actor;
  }
  ```

<hr>

[Prev](README.md) | [Up](../README.md) | [Next](databaseTypes.md)
