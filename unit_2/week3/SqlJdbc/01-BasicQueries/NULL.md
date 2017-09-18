## NULL Values
* A null is the absence of a value.
* Null values are not equal to 0, blanks, or empty strings.
* Compare null values with the IS operator.

  ```sql
  SELECT *
    FROM staff
   WHERE supervisor_id IS NULL;
  ```

* The IS operator will result in either true or false.
* To search for any non-null values, use IS NOT NULL.

  ```sql
  SELECT *
    FROM staff
   WHERE supervisor_id IS NOT NULL;
  ```

* NULL is not the same as a "false" value, but it isn't a "true" value, either.
* NULL means "unknown;" any operation with a NULL (other than IS or IS NOT) yields a NULL.

  ```sql
  SELECT *
    FROM staff
   WHERE supervisor_id = NULL;
  ```

* This will never be true, even for rows with null values in the supervisor_id column!

<hr>
Retrieve all employees with a known email address:

```sql
SELECT last_name, first_name, username, email
  FROM staff
 WHERE email IS NOT NULL;
```

Retrieve all customers with without email addresses:

```sql
SELECT last_name, first_name, email
  FROM customer
 WHERE email IS NULL
    OR email = '';
```

### VARCHAR, VARCHAR2, and NULL
The SQL standards specify that for character-varying data an empty string, '', is a distinct, non-null value and should not be treated as a NULL. For example, if a customer declines to provide an email address, we would store empty string ('') in their email column; but if we simply don't yet know what their email is, or whether they have one at all, we would store NULL. We should then get different results for the following two queries:

```sql
SELECT * FROM customer WHERE email = '';
SELECT * FROM customer WHERE email IS NULL;
```

Oracle's character-varying datatype does not comply with this, so Oracle named it VARCHAR2 instead of VARCHAR. Oracle VARCHAR2 treats empty string and NULL identically. Oracle reserves the word VARCHAR for a future implementation that complies with the SQL standards. However, it has never implemented this, so you use only VARCHAR2 with Oracle.

[Prev](WHERE.md) | [Up](../README.md) | [Next](Expressions.md)
