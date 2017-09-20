## The INSERT Statement

* Use the INSERT statement to add new rows of data to a table.

  INSERT INTO *table_name* [(*column1*,*column2*,...)] {VALUES (*value1*,*value2*,...) | SELECT *col1*, *col2*, ... FROM ...}
  * Use column_name_list to specify the columns for which you will be providing values.
  * You must own the table or have INSERT privilege on the table.

* To add a single row to the table, use the VALUES clause.
  ```sql
  INSERT INTO actor (id, first_name, last_name)
       VALUES (201, 'Troy', 'McClure');
  ```
  * The order and number of values must match the column list.
  * Use the `NULL` or `DEFAULT` keywords in place of a value to insert a null (if the column permits nulls), or allow a column to be populated with its default value.

* To add zero or more rows at once by copying data from existing rows, use a subquery.
  ```sql
  INSERT INTO film_actor (actor_id, film_id)
       SELECT 201, id FROM film WHERE title LIKE '%LOSE%';
  ```
  * The subquery's SELECT list can include column values, expressions, and literals.
    * You can generate rows in which some column values come from existing records, while others are provided by the statement itself.

* Most databases support an integer column of type IDENTITY, SERIAL, AUTOINCREMENT etc. for generating primary key values automatically.
  ```sql
  INSERT INTO address (address, city, state_province, phone)
       VALUES ('123 Fake St.', 'Roswell','NM','5551234');
  ```
  * Consult vendor documentation for how to find the generated key.
  ```sql
  SELECT LAST_INSERT_ID();
  ```

<hr>

You can enter a new project into the projects table with the following:

```sql
INSERT INTO address
     VALUES (730, '123 Fake St.', NULL, 'Roswell', 'New Mexico', NULL, NULL, '5551234');
```
This format of the INSERT command requires that the number and exact order of all columns in the address table be known, and match the VALUES list in correct order. If the table definition should change, this statement would become invalid. A more reliable (and maintainable) format is to specify the order and names of the columns that are being populated:
```sql
INSERT INTO address (id, address, address2, city, state_province, postal_code, country_code, phone)
     VALUES (730, '123 Fake St.', NULL, 'Roswell', 'New Mexico', NULL, NULL, '5551234');
```
You can omit columns, which will be automatically assigned the specified default or (if allowed) null value.
```sql
INSERT INTO address (id, address, city, state_province, phone)
     VALUES (730, '123 Fake St.', 'Roswell', 'New Mexico', '5551234');
```
Databases vary as to whether you can provide an explicit value for an automatically incremented primary key column; if you can, your value must not duplicate an existing one (which is true for any primary key column.) You can always leave such a column out of the INSERT statement:
```sql
INSERT INTO address (address, city, state_province, phone)
     VALUES ('123 Fake St.', 'Roswell','New Mexico','5551234');
```
Databases that allow auto-increment key columns usually provide a means to determine the most recentlygenerated
value - for example, MySQL's `LAST_INSERT_ID()` function:
```sql
SELECT last_insert_id();
```
A subquery can be used to easily populate rows from other data in the database. To add another employee to the database with the same address and store information as an existing employee:
```sql
INSERT INTO staff (first_name, last_name, address_id, store_id, active, username)
           SELECT 'Suzi', 'Chiarelli', address_id, store_id, 1, 'schiarelli'
             FROM employees
            WHERE id=68;
```

[Prev](README.md) | [Up](../README.md) | [Next](UPDATE.md)
