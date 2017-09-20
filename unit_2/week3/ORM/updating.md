## Updates

* Updating persists the current state of an object to its corresponding database record.

* This may involve updating or replacing related records in child tables.

  * Use a transaction to ensure the entire update is atomic.

  ```java
  public boolean saveActor(Actor actor) {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url, user, pass);
      conn.setAutoCommit(false); // START TRANSACTION
      String sql = "UPDATE actor SET first_name=?, last_name=? "
                 + " WHERE id=?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, actor.getFirstName());
      stmt.setString(2, actor.getLastName());
      stmt.setInt(3, actor.getId());
      int updateCount = stmt.executeUpdate();
      if (updateCount == 1) {
        // Replace actor's film list
        sql = "DELETE FROM film_actor WHERE actor_id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, actor.getId());
        updateCount = stmt.executeUpdate();
        sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
        stmt = conn.prepareStatement(sql);
        for (Film film : actor.getFilms()) {
          stmt.setInt(1, film.getId());
          stmt.setInt(2, actor.getId());
          updateCount = stmt.executeUpdate();
        }
        conn.commit();           // COMMIT TRANSACTION
      }
    } catch (SQLException sqle) {
      sqle.printStackTrace();
      if (conn != null) {
        try { conn.rollback(); } // ROLLBACK TRANSACTION ON ERROR
        catch (SQLException sqle2) {
          System.err.println("Error trying to rollback");
        }
      }
      return false;
    }
    return true;
  }
  ```

<hr>

[Prev](creation.md) | [Up](../README.md) | [Next](deleting.md)
