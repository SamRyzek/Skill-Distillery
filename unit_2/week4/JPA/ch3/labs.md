# Labs

1: Create a *Store* entity with the following fields.  

* id (don't forget to add `@GeneratedValue`)

* address (of type *Address*)

Here is the _store_ table for reference:  

```bash
+------------+----------------------+------+-----+---------+----------------+
| Field      | Type                 | Null | Key | Default | Extra          |
+------------+----------------------+------+-----+---------+----------------+
| id         | smallint(5) unsigned | NO   | PRI | NULL    | auto_increment |
| manager_id | int(10) unsigned     | YES  | UNI | NULL    |                |
| address_id | int(10) unsigned     | NO   | UNI | NULL    |                |
+------------+----------------------+------+-----+---------+----------------+
```

2: Add a uni-directional, one-to-one relationship between *Store* and *Address*.  

  * ***NOTE:*** For now don't do anything with the `manager_id`

3: Create a *JUnit* test for *Store* in a class named *StoreTest* within the *test* package.  

  * Query for store with id=1 and ensure that the address's city is "Seattle"

[Previous](one_to_one.md) | [Next](../ch4/README.md)
