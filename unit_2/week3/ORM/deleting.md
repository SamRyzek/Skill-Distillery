## Deletes

* Deletions must take into account dependent rows in child tables (foreign keys referencing the record to be deleted.)

  * The foreign key in the database may be defined to automatically ON DELETE CASCADE - delete the child records to allow the parent to be deleted.

  * If not, you may have to code it yourself.

  ```java
  public boolean deleteActor(Actor actor) {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url, user, pass);
      conn.setAutoCommit(false); // START TRANSACTION
      String sql = "DELETE FROM film_actor WHERE actor_id = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, actor.getId());
      int updateCount = stmt.executeUpdate();
      sql = "DELETE FROM actor WHERE id = ?";
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, actor.getId());
      updateCount = stmt.executeUpdate();
      conn.commit();             // COMMIT TRANSACTION
    }
    catch (SQLException sqle) {
      sqle.printStackTrace();
      if (conn != null) {
        try { conn.rollback(); }
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

[Prev](updating.md) | [Up](../README.md) | [Next](Lab-DMLORM.md)
