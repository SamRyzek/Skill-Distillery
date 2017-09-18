## Choosing Rows with the WHERE Clause
* Use the WHERE clause when only a subset of all the rows in a table is required.

`SELECT` {*item_list* | `*`}
  `FROM` *table*
[`WHERE` *conditions*];

  * The `WHERE` clause is evaluated once for each row in table.
  * *conditions* will be one or more expressions that will evaluate to either true, false, or neither (null).
  * If the WHERE clause evaluates to true, then the current row is returned in the result set.

* Operators that may be used in the WHERE clause include:
  * `=` equal to
  * `!=`, `^=`, `<>` not equal to
  * `>`, `<` greater than, less than
  * `>=`, `<=` greater than or equal to, less than or equal to

* Any character string values in conditions must be enclosed in single quotes.
  * Database data inside single quotes is usually case sensitive.

<hr>
Retrieve all information for each employee at store 7:

```sql
SELECT *
  FROM staff
 WHERE store_id = 7;
```

Retrieve first and last name, salary, and hire date for employees in Massachusetts:

```sql
SELECT id, title, length, rental_rate, replacement_cost
  FROM film
 WHERE release_year = 1990;
```

Despite well-established standards, database products vary in certain low-level details of syntax. In ANSI standard SQL, doublequotes enclose identifiers - table, column, or alias names - only, and string literals must be enclosed in single-quotes. Oracle Database enforces this, but MySQL treats single, double, and back quotes interchangably (unless a standards-compliance mode is enabled.)

Similarly, standard SQL comments have two forms:
* C-style block comments:

  ```sql
  SELECT id
         , title
         , length
         /* , rental_rate
         , replacement_cost */
    FROM film WHERE release_year = 1990;
  ```

* To-end-of-line comments:

  ```sql
  SELECT last_name, supervisor_id, -- no supervisor_id for store mgrs
         store_id
    FROM staff;
  ```

However, MySQL requires at least one space to follow the `-- `, and also supports `#` as a to-end-of-line comment starter.  Best practice is always to code to the established standards.


[Prev](SELECT.md) | [Up](../README.md) | [Next](NULL.md)
