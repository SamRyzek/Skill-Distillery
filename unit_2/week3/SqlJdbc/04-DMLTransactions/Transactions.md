## Transaction Management

* A database transaction groups a series of DML statements into a single logical unit of work.
* At any point in a transaction, you can roll back all of your DML statements.
  ```sql
  ROLLBACK;
  ```
  * All of your changes are discarded and a new transaction may begin.

* None of your changes are visible in the database until you commit your transaction.
  ```sql
  COMMIT;
  ```
  * All your changes are made permanent and a new transaction may begin.

* `COMMIT` as soon as you have successfully completed the statements making up a logical unit of work.
  * Transactions should have tightly-limited scope.

* Some databases operate by default in autocommit mode - each individual `INSERT`, `UPDATE`, or `DELETE` is immediately committed and can't be rolled back.

  * Explicitly begin a multistatement transaction with the `SET TRANSACTION` or `START TRANSACTION` command.

    ```sql
    START TRANSACTION
    ```

<hr>

Transactions help you manage tasks that must succeed as a logical group. To add a new employee the employee must first have an address:

1. Start a transaction:

   ```sql
   START TRANSACTION;
   ```

2. Insert a new addresss and employee records, and set the employee's supervisor to his store manager:  

   ```sql
   INSERT INTO address( address, city, state_province, country_code, phone)
        VALUES ('123 Fake St', 'Denver', 'CO', 'US', '5551234');
   INSERT INTO staff ( first_name, last_name, address_id, store_id, active, username)
        VALUES ( 'Bob', 'Dobbs', LAST_INSERT_ID(), 2, 1, 'bdobbs');
   UPDATE staff SET supervisor_id = (SELECT manager_id FROM store
                                      WHERE store.id = staff.store_id)
    WHERE id = LAST_INSERT_ID();
   ```

3. If all three statements succeed, then commit the work:
   ```sql
   COMMIT;
   ```
   But, if the second `INSERT` or the `UPDATE` statements fail, and we haven't committed yet, then we
   can roll the work back:
   ```sql
   ROLLBACK;
   ```
   Note that if we had committed, then the `ROLLBACK` statement would have no effect.

[Prev](DELETE.md) | [Up](../README.md) | [Next](Concurrency.md)
