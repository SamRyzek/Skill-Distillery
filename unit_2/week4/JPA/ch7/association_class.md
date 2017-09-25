# Association Class

* You normally don’t create an entity class for a join table.

  * The film_actor table, for example, is made up of foreign keys which are essential for the many-to-many relationship, but building an entity for this table would not add any additional value to our codebase.

* However, sometimes the join table contains additional data that does not belong with either entity that participates in the many-to-many relationship but instead belongs to the association itself.

  * The inventory_item table, for example, contains a column called media_condition that wouldn’t make sense to place in *Film* or *Store*.

  * If this is the case, you can create an entity for the join table to model the additional data.

  * This new class is sometimes called an association class

### Hands On:
1: Create an `enum` called *MediaCondition* with values of `New`, `Used`,
`Damaged`, `Lost`, and `NA`.

2: Create a new entity called *InventoryItem* which is mapped to the `inventory_item` table. Add fields for the id and the mediaCondition as well as appropriate get and set methods

```
+-----------------+------------------------------------------+------+-----+-------------------+-----------------------------+
| Field           | Type                                     | Null | Key | Default           | Extra                       |
+-----------------+------------------------------------------+------+-----+-------------------+-----------------------------+
| id              | int(10) unsigned                         | NO   | PRI | NULL              | auto_increment              |
| film_id         | int(10) unsigned                         | NO   | MUL | NULL              |                             |
| store_id        | smallint(5) unsigned                     | NO   | MUL | NULL              |                             |
| media_condition | enum('New','Used','Damaged','Lost','NA') | YES  |     | NULL              |                             |
| last_update     | timestamp                                | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |
+-----------------+------------------------------------------+------+-----+-------------------+-----------------------------+
```

3: Build a JUnit test for the *InventoryItem* entity to ensure it is mapped correctly.


[Previous](README.md) | [Next](mapping_options_with_association_classes.md)
