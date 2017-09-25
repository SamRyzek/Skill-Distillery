# Labs

1: Write a method named `int checkFilmInventoryItemsForStoryById(int id, String title) { }`

  * Create a test in *MappingsLabTest* to ensure your method is returning the correct number.

2: Create a bi-directional, many-to-one relationship between *Rental* and *InventoryItem*.

3: Update the test cases for *InventoryItem* and *Rental* to ensure the associations are working correctly.

4: Write a method named `List<Film> getFilmsRentedForCustomerWithId(int id) { }`

  * Create a test in *MappingsLabTest* to ensure your method is returning the films rented by the indicated customer.

  * ***HINT***: Use JPQL and query for the *Rental* by customer id...use the select to specifically pull out the list of films through the inventory item (`SELECT r.item.film`).



[Previous](mapping_options_with_association_classes.md) | [Next](../ch8)
