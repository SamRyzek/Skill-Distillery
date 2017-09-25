# Mapping Options with Association Classes

* We have already modeled the many-to-many relationship between *Film*
and *Store* using inventory_item as the join table.

  * Using the many-to-many you can:

    * Retrieve all films in a store’s inventory.

      * Find all stores that stock a certain film.

* You can also model the one-to-many relationship between *Film* and
*InventoryItem* so that you can:

  * Retrieve the condition of all of the copies of a certain film.

* Similarly, you can model the one-to-many between *Store* and *InventoryItem*

* so that you can:

  * Retrieve the condition of all of the items in a store’s inventory.

* You can choose whether to model one, two, or all three of the above
depending on your needs.

### Hands On:
1: Add a bi-directional, one-to-many relationship between *Film* and *InventoryItem*.

Add a JUnit test in both *FilmTest* and *InventoryItem* test to ensure this association is working.

2: Add another bi-directional, one-to-many relationship between *Store* and *InventoryItem*. Don’t forget to generate get/set methods for each new field.

Add a JUnit test in both *StoreTest* and *InventoryItem* test to ensure this association is working.

[Previous](association_class.md) | [Next](labs.md)
