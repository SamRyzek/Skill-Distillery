## GROUP BY

* Use `GROUP BY` to evaluate an aggregate function over groups of rows.

  ```sql
  SELECT s.id, a.city, COUNT(*)
    FROM staff e JOIN store s ON e.store_id = s.id
                 JOIN address a ON s.address_id = a.id
   GROUP BY s.id, a.city;
  ```

* The rows are organized into groups in which the values of the grouping column are equal.

  * The aggregate function is then evaluated once for each group.

  * The `SELECT` statement returns a single summary row for each group.

  * Only aggregate functions and the column(s) used in the `GROUP BY` clause are permitted in the `SELECT` clause.

* `HAVING` can be used to eliminate group summary rows based on the value of their aggregations.

  ```sql
  SELECT s.id, a.city, COUNT(*)
    FROM staff e JOIN store s ON e.store_id = s.id
                 JOIN address a ON s.address_id = a.id
   GROUP BY s.id, a.city
  HAVING COUNT(*) > 12;
  ```

<hr>

```sql
SELECT e.first_name, e.last_name, COUNT(*)
  FROM staff e JOIN rental r ON e.id = r.staff_id
 GROUP BY e.first_name, e.last_name;
```

The `GROUP BY` clause comes after any `WHERE` clause.

```sql
SELECT e.first_name, e.last_name, COUNT(*)
  FROM staff e JOIN rental r ON e.id = r.staff_id
 WHERE e.store_id = 2
 GROUP BY e.first_name, e.last_name;
```

* ORDER BY is always the last clause in a query.

```sql
SELECT e.first_name, e.last_name, COUNT(*)
  FROM staff e JOIN rental r ON e.id = r.staff_id
 WHERE e.store_id = 2
 GROUP BY e.first_name, e.last_name
 ORDER BY COUNT(*) DESC;
```

The database software can do this kind of analysis much more efficiently, over potentially very large amounts of data, than you would be able to do be retrieving the raw data and crunching numbers in a spreadsheet or with program code.

```sql
SELECT e.first_name, e.last_name, SUM(amount), AVG(amount)
  FROM staff e JOIN rental r ON e.id = r.staff_id
               JOIN payment p ON r.id = p.rental_id
 WHERE e.store_id = 7 AND r.rental_date > '2015-01-01'
 GROUP BY e.first_name, e.last_name
 ORDER BY AVG(amount);
```

```sql
SELECT s.id, a.city, SUM(amount), AVG(amount)
  FROM payment p JOIN rental r ON p.rental_id = r.id
                 JOIN inventory_item ii ON r.inventory_id = ii.id
                 JOIN store s ON ii.store_id = s.id
                 JOIN address a ON s.address_id = a.id
 GROUP BY s.id, a.city;
```

[Prev](Aggregates.md) | [Up](../README.md) | [Next](Lab.md)
