## Compound Expressions
* Use logical operators to group conditions in a WHERE clause.
* NOT will negate the condition following it.
* AND will result in true if both conditions are true for a row.
* OR will result in true if either condition is true for a row.
* The logical operators are evaluated based on precedence: NOT has the highest precedence, then AND, and then OR.
* If a WHERE clause contains both an AND and an OR, the AND will always be evaluated first.

  ```sql
  SELECT id, first_name, last_name
    FROM staff
   WHERE first_name = 'Dave'
      OR first_name = 'Diane'
     AND last_name = 'Martindale';
  ```

* This query will find Diane Martindale, as well as anyone with the first name of Dave.
* Use parentheses to override the precedence of these operators.

  ```sql
  SELECT id, first_name, last_name
    FROM staff
   WHERE ( first_name = 'Dave'
        OR first_name = 'Diane' )
       AND last_name = 'Martindale';
  ```

* This query will find people with a last_name of Martindale and a first_name of either Dave or Diane.

<hr>

We don't delete their staff record when an employee leaves, since we record rentals and payments they've processed. Instead we mark their staff record as inactive.

```sql
SELECT *
  FROM staff
 WHERE active = 1
   AND ( supervisor_id = 118
      OR supervisor_id = 114 );
```

[Prev](NULL.md) | [Up](../README.md) | [Next](ORDERBY.md)

