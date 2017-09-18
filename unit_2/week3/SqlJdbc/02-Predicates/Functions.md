## SQL Functions
* Use functions built into the server to manipulate data within your statement:
  * In the SELECT list:
    * Fetch only a portion of the film description.

    ```sql
    SELECT title, SUBSTR(description,3,30)
      FROM film;
    ```

  * In the WHERE clause:
    * Find rentals made on Fridays in the month of July.

    ```sql
    SELECT *
      FROM rental
     WHERE MONTH(rental_date) = 7
       AND WEEKDAY(rental_date) = 4;
    ```

* This kind of function is sometimes called a scalar or single-row function.
  * The function takes zero or more arguments and returns a single value
  * The function is executed once for each row processed by the statement.
  * The function doesn't modify the actual data stored in the database.

* Each database vendor has their own list of scalar functions.
  * You must consult your specific database product documentation for names, parameters, behavior, and limitattions of each function.

<hr>

### SQL Functions
Every database product supports its own list of scalar or single-row functions - functions that can be used in SQL statements and which are evaluated for every row.
String Functions:

```sql
SELECT CONCAT(last_name, ', ', first_name) FROM staff;
SELECT last_name, LENGTH(last_name) FROM staff;
SELECT title, LOWER(title) FROM film;
SELECT SUBSTR(last_name, 1, 3) FROM staff;
SELECT title, INSTR(title, ' ') FROM film;
SELECT title, SUBSTR(title, 1, INSTR(title, ' ')) FROM film;
```

Numeric Functions:

```sql
SELECT COS(1);
SELECT 4 * ATAN(1);
SELECT SQRT(2);
SELECT FLOOR(RAND() * 52);
SELECT title, rental_rate, replacement_cost / rental_rate AS rawroi,
       ROUND(replacement_cost / rental_rate) AS roi FROM film;
```

Date and Time Functions:

```sql
SELECT CURDATE(), CURTIME(), NOW();
SELECT rental_date, return_date, DATEDIFF(return_date, rental_date)
  FROM rental;
SELECT amount, MONTH(payment_date) FROM payment;
SELECT DATE_ADD(CURDATE(), INTERVAL 30 DAY);
SELECT DATE_ADD(CURDATE(), INTERVAL 6 MONTH);
SELECT WEEKDAY(DATE_ADD(CURDATE(), INTERVAL 6 MONTH));
```

Comparison and Flow-Control Functions:

```sql
SELECT country_code, country, IFNULL(formal_name,'N/A') FROM country;
SELECT country_code, COALESCE(formal_name,country) FROM country;
SELECT first_name,last_name, STRCMP(first_name,last_name) FROM staff;
```

System and Information Functions:

```sql
SELECT USER();
SELECT DATABASE();
SELECT VERSION();
```

These functions are not standardized, though most vendors support a similar rich set of functions in similar categories. ***You must refer to your particular database product's documentation for function names and usage.***

[Prev](LikeRegexp.md) | [Up](../README.md) | [Next](Lab.md)
