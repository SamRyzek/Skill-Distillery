## Subqueries

* A _subquery_ is a `SELECT` that appears as part of another SQL statement.

  * In the `WHERE` clause of another `SELECT` statement - this is called a _nested subquery_.

  * In the `FROM` clause of another `SELECT` statement - this is called an _inline view_.

    * The result of the subquery is treated as though it were another table; you can even give the subquery a table alias.

  * As an expression in a `SELECT`, `VALUES`, or `SET` clause.

* A subquery must return the correct number and type of columns and rows.

  * A single-row subquery returns exactly one record, while a multi-row subquery might return more than one record.

  * Operators such as = and != must be given a _scalar subquery_: a single-row subquery with just one column.

    ```sql
    SELECT first_name, last_name, username
      FROM staff
     WHERE id = (SELECT manager_id
                   FROM store
                  WHERE id = 4);
    ```

  * Operators such as `IN` allow a multi-row subquery, one that can return any number of rows (but still with a single column of the correct type).

    ```sql
    SELECT first_name, last_name, username
      FROM staff
     WHERE id IN (SELECT manager_id FROM store);
    ```

<hr>

Show the address of the manager of employee #111:

```sql
SELECT address, city, state_province, postal_code, country_code
  FROM address
 WHERE id = (SELECT supervisor_id
               FROM staff
              WHERE id = 111);
```

Show the address of the employees supervised by the manager of store #2:

```sql
SELECT address, city, state_province, postal_code, country_code
  FROM address a JOIN staff e ON a.id = e.address_id
 WHERE e.supervisor_id = (SELECT manager_id
                            FROM store
                           WHERE id = 2);
```

#### Subquery vs Join

When the query is only returning column values from a single table, you can use a subquery in the WHERE clause to help limit the result set.

```sql
SELECT first_name, last_name
  FROM staff
 WHERE id IN (SELECT customer_id FROM rental);
```

When the query returns column values from multiple tables, you will have to use a JOIN so that all of the table data is available in the main query.

```sql
SELECT first_name, last_name, rental_date
  FROM staff c JOIN rental r
                 ON c.id = r.customer_id;
```

[Prev](README.md) | [Up](../README.md) | [Next](Correlated.md)
