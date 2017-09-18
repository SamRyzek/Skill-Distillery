## IN and BETWEEN

* Use the IN (or NOT IN) operator to compare a column against several possible values.

  ```sql
  SELECT title, release_year, rating
    FROM film
   WHERE rating IN ('G', 'PG');
  ```

  * IN is equivalent to ORing several equality comparisons together.

    ```sql
    SELECT title, release_year, rating
      FROM film
     WHERE rating = 'G'
        OR rating = 'PG';
    ```

* Use the BETWEEN operator to compare a column against a range of inclusive values.

  ```sql
  SELECT title, release_year, rating
    FROM film
   WHERE release_year BETWEEN 1983 AND 1986;
  ```

  * The AND is part of the BETWEEN operator.
  * Make sure that lower value appears before the higher one:

    ```sql
    SELECT id, last_name, first_name
      FROM staff
     WHERE first_name BETWEEN 'A' AND 'E';
    ```

<hr>

Retrieve a list of Colorado addresses not in the 80202, 80205, or 80206 zip codes:
```sql
SELECT *
  FROM address
 WHERE postal_code NOT IN ('80202', '80205', '80206')
   AND state_province = 'Colorado';
```

List payments since 2016 Q1 between $5 and $8::
```sql
SELECT *
  FROM payment
 WHERE payment_date BETWEEN '2016-01-01' AND '2016-04-01'
   AND amount BETWEEN 5 AND 8;
```


[Prev](README.md) | [Up](../README.md) | [Next](LikeRegexp.md)
