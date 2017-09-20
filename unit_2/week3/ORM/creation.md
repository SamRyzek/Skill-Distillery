## Creating Database Entities from Java Objects

* To persist a new entity from a Java object, map its fields into an INSERT statement.

  * Use `Statement.RETURN_GENERATED_KEYS` and `getGeneratedKeys()` to retrieve database-generated AUTO_INCREMENT primary keys for the new record.

  * If you are inserting child records, use a transaction.

  ```java
  public Actor addActor(Actor actor) {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url, user, pass);
      conn.setAutoCommit(false); // START TRANSACTION
      String sql = "INSERT INTO actor (first_name, last_name) "
                       + " VALUES (?,?)";
      PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, actor.getFirstName());
      stmt.setString(2, actor.getLastName());
      int updateCount = stmt.executeUpdate();
      if (updateCount == 1) {
        ResultSet keys = stmt.getGeneratedKeys();
        if (keys.next()) {
          int newActorId = keys.getInt(1);
          actor.setId(newActorId);
          if (actor.getFilms() != null && actor.getFilms().size() > 0) {
            sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
            stmt = conn.prepareStatement(sql);
            for (Film film : actor.getFilms()) {
              stmt.setInt(1, film.getId());
              stmt.setInt(2, newActorId);
              updateCount = stmt.executeUpdate();
            }
          }
        }
      } else {
        actor = null;
      }
      conn.commit(); // COMMIT TRANSACTION
    } catch (SQLException sqle) {
      sqle.printStackTrace();
      if (conn != null) {
        try { conn.rollback(); }
        catch (SQLException sqle2) {
          System.err.println("Error trying to rollback");
        }
      }
      throw new RuntimeException("Error inserting actor " + actor);
    }
    return actor;
  }
  ```

<hr>

[Prev](Lab-QueryORM.md) | [Up](../README.md) | [Next](updating.md)
