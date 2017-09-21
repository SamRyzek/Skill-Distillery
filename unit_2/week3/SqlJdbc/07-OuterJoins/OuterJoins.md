## Outer Joins
* An outer join retrieves all rows from one table, plus the matching rows from the second table.

  * The column values for the non-matched rows (which would have come from the second table) will be NULL.

* Standard join syntax specifies which table, the LEFT or RIGHT, will have all of its rows returned.

  ```sql
  SELECT s.id, s.address_id, e.last_name
    FROM store s LEFT OUTER JOIN staff e
                              ON e.id = s.manager_id;
  ```

  * All records from the LEFT table will be returned, with NULLs in columns where information from the RIGHT table was not available.

  * The OUTER keyword is optional.

* FULL [OUTER] JOIN — All matching rows from the two tables, plus rows from each table that have no matching rows in the other.

* If you join another table to an outer joined table, you will also need to outer join the new table.

  ```sql
  SELECT s.id, s.address_id, e.last_name, a.phone
    FROM store s LEFT OUTER JOIN staff e
                              ON e.id = s.manager_id
                 LEFT OUTER JOIN address a
                              ON e.address_id = a.id;
  ```

  * Without the second outer join, you will not be able to match against NULL values in the result set, and the rows will be lost.

    ```sql
    SELECT s.id, s.address_id, e.last_name, a.phone
      FROM store s LEFT OUTER JOIN staff e
                                ON e.id = s.manager_id
                              JOIN address a
                                ON e.address_id = a.id;
    ```

<hr>

When a row in one joined table does not have a matching row in the other table, the row is left out of the result set of an ordinary (INNER) join.

```sql
SELECT emp.first_name, emp.last_name, sup.last_name
  FROM staff emp JOIN staff sup ON emp.supervisor_id = sup.id
 ORDER BY emp.last_name;
```

With an OUTER join, when a row in one joined table does not have a match in the other table, the unmatched row remains in the result set. NULL values are supplied for the columns that would have come from the other table.

```sql
SELECT emp.first_name, emp.last_name, sup.last_name
  FROM staff emp LEFT JOIN staff sup ON emp.supervisor_id = sup.id
 ORDER BY emp.last_name;
```

LEFT and RIGHT refer to the position of the table name in the FROM clause, relative to the JOIN keyword. The LEFT OUTER JOIN above can just as easily be written as a RIGHT OUTER JOIN:

```sql
SELECT emp.first_name, emp.last_name, sup.last_name
  FROM staff sup RIGHT JOIN staff emp ON emp.supervisor_id = sup.id
 ORDER BY emp.last_name;
```

[Prev](README.md) | [Up](../README.md) | [Next](SelfJoins.md)
