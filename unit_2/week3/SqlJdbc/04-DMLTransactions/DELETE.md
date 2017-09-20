## The DELETE Statement

* The `DELETE` statement removes rows from a table.
  * You must either own the table or have DELETE privilege.

* The format of the `DELETE` command is:

  DELETE FROM *table_name*
  [WHERE *condition*];

* The `WHERE` clause identifies the rows to be deleted.
  ```sql
  DELETE FROM payment
   WHERE id >= 56273;
  ```
  * The condition can be the same as those found in the `SELECT` statement.
    * ... which is not a bad way to test your condition before executing the `DELETE`!

  * **If no `WHERE` clause is used, all rows in table_name are deleted!**

<hr>

In addition, many databases provide the TRUNCATE statement. TRUNCATE deletes all of the rows in a table. Unlike the DELETE statement, you cannot specify any conditions on which rows are to be deleted.
```sql
TRUNCATE TABLE film_category;
```
TRUNCATE is used instead of the DELETE statement to free space allocated for the table; and, because each deletion is not logged, the TRUNCATE statement is usually faster than DELETE. The TRUNCATE statement cannot be undone (see ROLLBACK) and should, therefore, be used with caution.

[Prev](UPDATE.md) | [Up](../README.md) | [Next](Transactions.md)
