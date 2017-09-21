## The EXISTS Operator

* The `EXISTS` operator is used in the `WHERE` clause of a correlated subquery to test for the existence of data; it does not _return_ any data.

  * The outer query relies on the subquery's boolean result to determine whether to include its current row in the resultset.

    WHERE [NOT] EXISTS (_subquery_);

* An `EXISTS` condition is true if its subquery returns at least one row.

* The item in the subquery's `SELECT` list is often the primary key or a *.

  ```sql
  SELECT first_name, last_name
    FROM staff e
   WHERE EXISTS (SELECT *
                   FROM rental r JOIN inventory_item ii
                                   ON r.inventory_id = ii.id
                  WHERE r.customer_id = e.id);
  ```

  * It doesn't matter what you put in the subquery's `SELECT` list since no values from the subquery are used in the parent statement.

* The `EXISTS` operator results in a _semi-join_.

  * A matched row from the containing query appears only once,

<hr>

There is always more than one way to do it in SQL:

```sql
SELECT rental_date, return_date
  FROM rental
 WHERE NOT EXISTS (SELECT *
                     FROM payment
                    WHERE payment.rental_id = rental.id);
```

```sql
SELECT rental_date, return_date
  FROM rental r
 WHERE r.id NOT IN (SELECT rental_id FROM payment);
```

```sql
SELECT r.rental_date, r.return_date
  FROM rental r LEFT OUTER JOIN payment p
                             ON r.id = p.rental_id
 WHERE p.id IS NULL;
```

These are examples of _antijoins_ — queries that return rows from one table for which there are no matching rows in the other table.

Although there is always more than one way to do it, not everything you try will actually work. Consider:

```sql
SELECT r.rental_date, r.return_date
  FROM rental r JOIN payment p
                  ON r.id != p.rental_id;
```

Exactly which rows will be selected by this join condition? (Hint: do NOT try running it!) This results not in an antijoin, but in a Cartesian or CROSS join of rental with payment, with just the matching rows left out.

[Prev](Correlated.md) | [Up](../README.md) | [Next](Aggregates.md)
