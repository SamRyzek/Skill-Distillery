## The SELECT Statement
* SQL data retrievals are done using the SELECT statement.
  * Data retrievals are also called queries.
* A SELECT statement may make use of several clauses, but minimally must include the following two:

  `SELECT` [`DISTINCT`] {*item_list* | `*`}
    `FROM` *table*;

* The SELECT clause specifies which data values will be retrieved, and will be followed by either an item_list or a `*`.
  * `*` represents all the columns in table.

  ```sql
  SELECT * FROM film;
  ```

  * *item_list* is a column, an expression, or a comma-separated list of any combination of these.

  ```sql
  SELECT title, rental_rate, replacement_cost / rental_rate
    FROM film;
  ```

  * The query will return each item in *item_list* under a column heading of the same name.
    * A heading may be overridden with a *column alias*, a word used to replace the default heading.

    ```sql
    SELECT title, rental_rate, replacement_cost / rental_rate AS break_even
      FROM film;
    ```

* Use `DISTINCT` to eliminate duplicate rows from the displayed results.
* The `FROM` clause specifies one or more sources, typically tables, from which to retrieve data.

<hr>
The SELECT statement may query one or many tables. The data that is retrieved may be thought of as a virtual table (i.e., one that exists in memory only until the query completes). This virtual table is also referred to as the query's **result set**.

The SELECT statement can be used to retrieve data from any or all columns from a table. For example, the following SELECT will display a list of everything about every employee in the staff table:

```sql
SELECT *
  FROM staff;
```

The query below will list just the name and store of each employee:

```sql
SELECT first_name, last_name, store_id
  FROM staff;
```

The query below will list each employee's store:

```sql
SELECT store_id
  FROM staff;
```

This query will retrieve each store that has employees.

```sql
SELECT DISTINCT store_id
  FROM staff;
```

#### Note:
Table, column, or alias names containing spaces must be enclosed in quotes.

```sql
SELECT title, rental_rate, replacement_cost / rental_rate AS "Break Even"
  FROM film;
```

[Prev](README.md) | [Up](../README.md) | [Next](WHERE.md)
