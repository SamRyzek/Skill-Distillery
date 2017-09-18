## Creating Some Order
* Data is not physically stored in a table in any specified order.
  * Unless the table is an Index-Organized Table (IOT), records are usually appended to the end of the table, or placed in free space left from previous DELETEs.

* The SELECT statement's ORDER BY clause is the only way to enforce sequencing on the result set.
* The ORDER BY clause may be included in the SELECT statement:

  SELECT {*item_list* | \*} FROM *table* [ORDER BY *column* [ASC | DESC],...];

  * *column* can either be the name or the numeric position of the column in the item_list.

* The result set is sorted by the first column name in the ORDER BY clause.
  * If there are duplicate values in the first sort column, the sort is repeated on the second column in the list, and so on.
  * The rows may be sorted in ascending (the default) or descending order.
  * ASC and DESC may be applied independently to each column.
  * NULL values will be sorted after all non-NULL values in ASC order (and before all non-NULLs when you use DESC).

<hr>
Retreive a list of employees sorted by store from highest to lowest, and by last name within each store from lowest to highest:

```sql
SELECT id, first_name, last_name, store_id
  FROM staff
 ORDER BY store_id DESC, last_name ASC;
```

Sort using select item number instead of column name:

```sql
SELECT id, first_name, last_name, store_id
  FROM staff
 ORDER BY 4 DESC, 3 ASC;
```

[Prev](Expressions.md) | [Up](../README.md) | [Next](Lab.md)
