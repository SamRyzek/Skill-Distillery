## The UPDATE Statement

* Use the `UPDATE` statement to change existing data in a single table.

  UPDATE *table_name*
     SET *column*=*expression* [,*column*=*expression*,...]
  [WHERE *condition*];
  * You must either own the table or have UPDATE privilege.
    ```sql
    UPDATE film
       SET rental_duration = 7,
           rental_rate = 1.99
     WHERE id = 993;
    ```
* The expression may be a subquery that must return only one row.
  ```sql
  UPDATE staff
     SET supervisor_id = (SELECT manager_id
                            FROM store
                           WHERE id = 4)
   WHERE id = 71;
  ```
  * Specify `DEFAULT` to set a value back to the default value specified for this column when the table was created.
    ```sql
    UPDATE film
       SET rating = DEFAULT
     WHERE id = 132;
    ```

    * A NULL will be issued if there is no default for this column.

* The `WHERE` clause identifies the rows to be updated.
  * **If no `WHERE` clause is used, all rows in table_name are updated.**

<hr>

[Prev](INSERT.md) | [Up](../README.md) | [Next](DELETE.md)
