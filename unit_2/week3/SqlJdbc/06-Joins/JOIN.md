## Selecting from Multiple Tables
* To retrieve data from more than one table in the same SELECT statement, the tables are joined together.

  * Specify the tables in the FROM clause using the INNER JOIN keywords.

  * Use the ON clause with a join condition to specify how the rows in the second table should match the original rows.

    ```sql
    SELECT address, city, country
    FROM address INNER JOIN country
    ON address.country_code = country.country_code;
    ```

  * The word INNER is optional.

* If you reference a column whose name appears in more than one table, you must precede the column name with the table name, called a qualified reference.

  ```sql
  SELECT country.country_code, city, ...
  ```

  * Using a table alias can save you some typing.

    ```sql
    SELECT c.country_code, a.address, a.city, c.country
    FROM address a JOIN country c
    ON a.country_code = c.country_code;
    ```

* If the join clause involves only columns with the same name, you may use the USING clause, omitting the explicit join condition:

  ```sql
  SELECT country_code, a.address, a.city, c.country
  FROM address a JOIN country c USING (country_code);
  ```

  * With USING, the table name or alias cannot be used to qualify the column name, as the join columns are rolled together into a single column.

<hr>
When you join two tables, the result set consists of all of the rows that matched the join condition (and any other conditions). All rows that do not have a corresponding row in the other table are thrown out. This is called an _inner join.

The following query will return information only for stores with managers - no other stores from the stores table will have a matching id in the staff table.

```
SELECT s.id, s.address_id, e.last_name
FROM store s JOIN staff e ON e.id = s.manager_id;
```

Joins often illustrate one-to-many relationships in your database schema. For example, one store might have many employees:

```
SELECT s.id, s.address_id, e.first_name, e.last_name
FROM store s JOIN staff e ON s.id = e.store_id;
```

CROSS JOIN — A join done without any join conditions. Every row in the first table is matched with
every row in the second table. This is also called a Cartesian product.

```
SELECT s.id, s.address_id, e.first_name, e.last_name
FROM store s CROSS JOIN staff e;
```

This cross join will show the combination of every employee with every store - this is seldom useful

[Prev](README.md) | [Up](../README.md) | [Next](JoinConditions.md)
