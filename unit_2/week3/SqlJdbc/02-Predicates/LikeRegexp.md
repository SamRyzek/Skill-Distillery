## Pattern Matching: LIKE and REGEXP
* The LIKE operator provides pattern matching for character data with two simple wildcards:
  * `%` Matches zero or more characters.
  * `_` Matches exactly one character and is position-dependent.

  ```sql
  SELECT id, title FROM film WHERE title LIKE 'PER%';
  SELECT id, title FROM film WHERE title LIKE '%PER';
  SELECT id, title FROM film WHERE title LIKE '%PER%';
  SELECT first_name, last_name FROM staff WHERE last_name LIKE 'S_____';
  SELECT last_name FROM staff WHERE last_name LIKE '%son';
  ```

* Many database vendors support Regular Expression pattern matching, though the syntax varies.
  * MySQL:

    ```sql
    SELECT first_name, last_name FROM customer
     WHERE last_name REGEXP '[APR].*[ae]rt?son';
    ```

  * Oracle Database:

    ```sql
    SELECT last_name FROM customer
     WHERE REGEXP_LIKE(last_name, '[APR].*[ae]rt?son');
    ```

<hr>
A common use of LIKE is to wrap our search text between two percent-sign wildcards to search the entire column, finding the search string at the beginning, end, or anywhere in between.

```sql
SELECT title, description
  FROM film
 WHERE description LIKE '%thrilling%';
```

### Collation and Case Sensitivity
Ultimately, all text is stored as character codes whose meanings are defined in character sets such as the Unicode code tables, which specify which numeric code means which specific character symbol from some written language.  In addition to these unique character code numbers, a character set uses a corresponding collation.

The collation determines which characters are considered to be equivalent in a given language. For example in the ASCII character set (also known as Unicode Basic Latin), A (capital A) is character code 65 but a (lower case A) is character code 97 - they are two distinct character codes. However, in the English language they are considered the same letter.with the same meaning and pronunciation. If we use a case-sensitive ASCII collation, they would be considered different in terms of sorting and comparison. In a case-insensitive collation of ASCII they would be considered the same in terms of sorting and comparison.

MySQL supports a large number of character sets, with multiple collation options for each (for example, letters may sort differently in Spanish than in Swedish though they share the same character set). You can specify the character set and collation for each text column or for an entire table; the database can have defaults for new tables that don't specify their own.  MySQL by default uses a case-insensitive collation so string comparisons with =, !=, and LIKE are case-insensitive.

To get a case-sensitive search, specify binary (actual character code) collation in the WHERE clause predicate:

```sql
SELECT title, description
  FROM film
 WHERE description LIKE '%thrilling%' COLLATE utf8_bin; -- not found

SELECT title, description
  FROM film
 WHERE description LIKE '%Thrilling%' COLLATE utf8_bin; -- found
```

Alternatively, qualify an operand with BINARY to force a binary (exact character code) comparison:

```sql
SELECT title, description
  FROM film
 WHERE BINARY description LIKE '%thrilling%'; -- not found
```

[Prev](InBetween.md) | [Up](../README.md) | [Next](Functions.md)
