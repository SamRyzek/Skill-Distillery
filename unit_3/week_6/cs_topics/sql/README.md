## SQL

SQL joins are used to extract a data set across multiple tables with a single query. Tables are eligible for a join statement if they have a related column between them. This is how SQL identifies that the data from the two tables are related.

<img src="https://i.stack.imgur.com/1UKp7.png"/>

For the examples below we will be using the following tables and their respective data.

##### Customer table
```SQL
+----+------------+-----------+
| id | first_name | last_name |
+----+------------+-----------+
|  1 | Andrew     | Conlin    |
|  2 | Rob        | Roselius  |
|  3 | Kris       | Kane      |
|  4 | Steve      | Thompson  |
+----+------------+-----------+
```

##### Order table
```SQL
+----+------------+----------+-------------+
| id | order_date | amount   | customer_id |
+----+------------+----------+-------------+
|  1 | 2017-05-22 |  33.2400 |           1 |
|  2 | 2017-04-12 |  12.9900 |           2 |
|  3 | 2017-04-12 | 123.5600 |           2 |
|  4 | 2017-01-24 |  56.8900 |           3 |
|  5 | 2016-02-28 |  94.1100 |        NULL |
+----+------------+----------+-------------+
```

### Inner JOIN
* Executing an inner join would give us the matching data between the two tables (Customer and Order). Any records that do not contain overlapping data would not be included in the result set.
* Just using the `join` keyword by itself would assume an inner join.

Executing
```SQL
Select first_name, last_name, order_date, amount
FROM customer c
INNER JOIN order o
ON c.id = o.customer_id;
```

would return:
```SQL
+------------+-----------+------------+----------+
| first_name | last_name | order_date | amount   |
+------------+-----------+------------+----------+
| Andrew     | Conlin    | 2017-05-22 |  33.2400 |
| Rob        | Roselius  | 2017-04-12 |  12.9900 |
| Rob        | Roselius  | 2017-04-12 | 123.5600 |
| Kris       | Kane      | 2017-01-24 |  56.8900 |
+------------+-----------+------------+----------+
```

Notice that:
* Order with id 5, which has a null customer_id is not included
* Customer 4, Steve Thompson, is not included because he has not ordered anything yet.

### Left JOIN
* Executing a left join would return the matching data between the two tables (Customer and Order), as well as all the data from the left table (Customer).
* `LEFT JOIN` is shorthand for `LEFT OUTER JOIN`.

Executing
```sql
Select first_name, last_name, order_date, amount
FROM customer c
LEFT JOIN order o
ON c.id = o.customer_id;
```

would return:
```sql
+------------+-----------+------------+----------+
| first_name | last_name | order_date | amount   |
+------------+-----------+------------+----------+
| Andrew     | Conlin    | 2017-05-22 |  33.2400 |
| Rob        | Roselius  | 2017-04-12 |  12.9900 |
| Rob        | Roselius  | 2017-04-12 | 123.5600 |
| Kris       | Kane      | 2017-01-24 |  56.8900 |
| Steve      | Thompson  | NULL       |     NULL |
+------------+-----------+------------+----------+
```

* We received all records from the Customer table, even when there were no orders present for that user.

### Right JOIN
* Executing a right join would return the matching data between the two tables (Customer and Order), as well as all the data from the right table (Order).
* `RIGHT JOIN` is shorthand for `RIGHT OUTER JOIN`.

Executing
```sql
Select first_name, last_name, order_date, amount
FROM customer c
RIGHT JOIN order o
ON c.id = o.customer_id;
```

would return:
```sql
+------------+-----------+------------+----------+
| first_name | last_name | order_date | amount   |
+------------+-----------+------------+----------+
| Andrew     | Conlin    | 2017-05-22 |  33.2400 |
| Rob        | Roselius  | 2017-04-12 |  12.9900 |
| Rob        | Roselius  | 2017-04-12 | 123.5600 |
| Kris       | Kane      | 2017-01-24 |  56.8900 |
| NULL       | NULL      | 2016-02-28 |  94.1100 |
+------------+-----------+------------+----------+
```

* We received all records from the Orders table, even when there wasn't a corresponding customer_id for that order.

### Full JOIN
* Mysql does not have `FULL JOIN` syntax.
* If it did it would return all the corresponding records from both tables.
* We can mimic this behavior by using a `UNION`

Executing
```sql
SELECT first_name, last_name, order_date, amount
FROM customer c
LEFT OUTER JOIN order o
ON c.id = o.customer_id

UNION

SELECT first_name, last_name, order_date, amount
FROM customer c
RIGHT OUTER JOIN order o
ON c.id = o.customer_id
```

would return:
```sql
+------------+-----------+------------+----------+
| first_name | last_name | order_date | amount   |
+------------+-----------+------------+----------+
| Andrew     | Conlin    | 2017-05-22 |  33.2400 |
| Rob        | Roselius  | 2017-04-12 |  12.9900 |
| Rob        | Roselius  | 2017-04-12 | 123.5600 |
| Kris       | Kane      | 2017-01-24 |  56.8900 |
| Steve      | Thompson  | NULL       |     NULL |
| NULL       | NULL      | 2016-02-28 |  94.1100 |
+------------+-----------+------------+----------+
```

* We received all the rows from both Customer and Order tables.
