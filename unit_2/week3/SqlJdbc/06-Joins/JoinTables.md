## Join Tables

* Joins often use tables whose columns aren't included in the results.

  * Use joins to link rows from tables that don't have a direct connection.

    * Use address to connect customer to country:

      ```sql
      SELECT c.first_name, c.last_name, co.country
      FROM customer c JOIN address a
                        ON c.address_id = a.id
                      JOIN country co
                        ON a.country_code = co.country_code
       ORDER BY c.last_name;
      ```

* An _associative table_ (also called _association table_ or just _join table_) is often used to resolve many-to-many relationships.

  * A film has many actors, and an actor appears in many films; `film_actor` associates these two entities.

    ```sql
    SELECT a.first_name, a.last_name, f.title
      FROM actor a JOIN film_actor fa ON a.id = fa.actor_id
                   JOIN film f ON fa.film_id = f.id
     ORDER BY f.title;
    ```

* There is no limit to the number of tables that can be joined together.

  * Each table joined into the query will have its own join criteria, matching its data to data from any of the previously listed tables.

    ```sql
    SELECT a.first_name, a.last_name, f.title, l.name
      FROM actor a JOIN film_actor fa ON a.id = fa.actor_id
                   JOIN film f ON fa.film_id = f.id
                   JOIN language l ON f.language_id = l.id
     ORDER BY f.title;
    ```

<hr>

You will need to carefully decide which tables are joined to which other tables in your query. In this first query, the `address` table is joined with the `staff` table and the `staff` table to the `store` table. We are retrieving a list of all managers with their home phone numbers.

```sql
SELECT e.first_name, e.last_name, a.phone
  FROM staff e JOIN store s ON e.id = s.manager_id
               JOIN address a ON e.address_id = a.id
 ORDER BY last_name;
```

This next query involves the same three tables, but they are joined together differently. We are joining the `address` table to the `store` table and the `store` table to the `staff` table. We are retrieving a list of managers with their store's phone numbers.

```sql
SELECT e.first_name, e.last_name, a.phone
  FROM staff e JOIN store s ON e.id = s.manager_id
               JOIN address a ON s.address_id = a.id
 ORDER BY last_name;
```

These two queries retrieve very different result sets.

[Prev](JoinConditions.md) | [Up](../README.md) | [Next](Lab.md)
