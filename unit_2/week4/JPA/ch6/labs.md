# Labs

1. Create a new file in the *client* package named "ManyToManyLab.java".

Write a method `public List<Film> getFilmsForActorsWithId(int id){ }`

Return the list of films associated with that actor.

Write a test to ensure your new method is working in a new test file named "ManyTest.java"

***NOTE***: The list of films is lazily initialized by default, instead of eagerly fetching the list, use a `JOIN FETCH`.

2. Create a new entity and JUnit test for the _category_ table.

```
+-------+----------------------+------+-----+---------+----------------+
| Field | Type                 | Null | Key | Default | Extra          |
+-------+----------------------+------+-----+---------+----------------+
| id    | smallint(5) unsigned | NO   | PRI | NULL    | auto_increment |
| name  | varchar(25)          | NO   |     | NULL    |                |
+-------+----------------------+------+-----+---------+----------------+
```

3. Add a bi-directional, many-to-many relationship between *Film* and *Category*. Use *film_category* as the join table. Be sure to write the get/set.

4. Update your test cases for *Category* and *Film* to exercise the new relationship.

5. In "ManyToManyLab.java" write a method (`getNumberOfFilmsForCategoryWithName(String name)`) that lists how many *Film*s contain a *Category* the provided category. 

***Note:*** You can call `.size()` on the result from the query to solve this, don't bother using a `COUNT`, this is giving you additional experience with `JOIN FETCH` in JPQL, not writing SQL aggregate queries.

Write a test to ensure your new method is working in "ManyTest.java"

6. Add a bi-directional, many-to-many relationship between *Film* and *Store*. Use `inventory_item` as the join table. Again, make sure to write get/set methods.

7. Update your test cases for *Store* and *Film* based on the new relationship.

8. In "ManyToManyLab.java" write a method (`getInventoryForStoreWithId(int id)`) that returns a list of all of the *Film*s that are stocked at *Store* #1.

Write a test to ensure your new method is working in "ManyTest.java"

[Previous](eager_and_lazy_loading.md) | [Next](../ch7/README.md)
