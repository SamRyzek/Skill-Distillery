## Join Conditions
* A _join condition_ is a predicate (in the ON or WHERE clause) that relates columns from two tables.

  * A predicate that references only one table is a _filter condition_ or _filter predicate_.

* Though you can join tables using any columns with compatible data types, parent/child relationships are often used in the join criteria.

  ```sql
  SELECT e.last_name, e.first_name, a.city, a.state_province
    FROM staff e JOIN address a ON e.address_id = a.id -- Join condition
   WHERE e.id = 59;  -- Filter predicate
  ```

  * This relationship is implemented with a foreign key.

* The join condition can also be complex, involving multiple columns.

  ```sql
  SELECT e.id, e.first_name, e.last_name, c.first_name
    FROM staff e JOIN customer c ON e.last_name = c.last_name
                                AND e.address_id = c.address_id;
  ```

* All fields from a table can be selected.

  ```sql
  SELECT e.id, e.first_name, e.last_name, c.*
    FROM staff e JOIN customer c ON e.last_name = c.last_name
                                AND e.address_id = c.address_id;
  ```

<hr>

Joining the same tables using different join conditions will retrieve very different result sets.

This query retrieves the names of the store managers.

```sql
SELECT s.id, a.city, e.id, e.first_name, e.last_name
  FROM staff e JOIN store s ON e.id = s.manager_id
               JOIN address a ON s.address_id = a.id
 ORDER BY city;
```

This query retrieves the names and store locations of all employees.

```sql
SELECT s.id, a.city, e.id, e.first_name, e.last_name
  FROM staff e JOIN store s ON e.store_id = s.id
               JOIN address a ON s.address_id = a.id
 ORDER BY city;
```

#### Note:
The examples in this chapter use the ANSI standard syntax for joins, in which you list join conditions in the FROM clause and filter predicates in the WHERE clause:

```sql
SELECT c.country_code, a.address, a.city, c.country
  FROM address a JOIN country c ON a.country_code = c.country_code
 WHERE c.country LIKE 'U%';
```

However, you might see older join syntax, which is still valid SQL, in which the join conditions are mingled with filter predicates in the WHERE clause:

```sql
SELECT c.country_code, a.address, a.city, c.country
  FROM address a, country c
WHERE c.country LIKE 'U%'
  AND a.country_code = c.country_code;
```

[Prev](JoinTables.md) | [Up](../README.md) | [Next](Lab.md)
