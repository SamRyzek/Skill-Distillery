## Correlated Subqueries

* A subquery whose `WHERE` clause refers to a table in the `FROM` clause of a parent query is a correlated subquery.

  * The subquery is correlated to - re-executed with - specific values in each row processed by the parent statement.

    ```sql
    SELECT first_name, last_name
      FROM staff e JOIN rental r
                     ON e.id = r.customer_id
     WHERE e.store_id = (SELECT store_id
                           FROM inventory_item ii
                          WHERE r.inventory_id = ii.id);
    ```

* Subqueries often can be rewritten as joins in `SELECT` statements.

  ```sql
  SELECT first_name, last_name
    FROM staff e JOIN rental r ON e.id = r.customer_id
                 JOIN inventory_item ii ON r.inventory_id = ii.id
   WHERE e.store_id = ii.store_id;
  ```

  * However, subqueries can help you factor a very complex query into manageable pieces.

<hr>

[Prev](Subqueries.md) | [Up](../README.md) | [Next](EXISTS.md)
