## Concurrency and Locking

* Databases use locks of various types to coordinate data manipulation, and many other activities, among concurrent sessions.
* When concurrent sessions access the same rows and perform DML statements — INSERTs, UPDATEs, and DELETEs — the database isolates each session's work.
  * This assures one session can't update or delete a row another session has already updated, until the first session does a `COMMIT` (or `ROLLBACK`).

* When a transaction begins manipulating data, it creates an *Exclusive* or *Write* Lock, and associates all inserted, modified, or deleted rows with that lock.
  * Another transaction trying to manipulate any of the rows will find the lock and wait.
  * When the first transaction commits or rolls back, its lock clears, and the next transaction in the queue can lock the rows it needs.

* A deadlock can occur if one transaction requires access to data locked by another in order to complete, while at the same time holding a lock that the other transaction is waiting for.
  * Most databases automatically detect this situation, rolling back statements or transactions to clear the deadlock.

* It's possible to explicitly lock data without performing DML:
  * Lock an entire table:

    ```sql
    LOCK TABLES rental WRITE;
    ```

  * Lock only the rows selected by a query:

    ```sql
    SELECT * FROM staff WHERE store_id = 6 FOR UPDATE;
    ```

  * Locks are freed when the current transaction ends - that is, when you `COMMIT` or `UPDATE`;

<hr>

Locking is one of the more intricate and complicated features of a database, and the internal details vary
from vendor to vendor and product to product.

[Prev](Transactions.md) | [Up](../README.md) | [Next](LoadData.md)
