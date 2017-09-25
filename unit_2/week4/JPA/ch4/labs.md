# Labs
For each of the following labs, update the appropriate JUnit test cases based on the new relationships.


1: Add the appropriate annotations to describe a uni-directional, many-to-one relationship between *Staff* and *Address*.

* *Staff* should store a field of type *Address*, but *Address* does not store a collection of *Staff*.

* Don’t forget to add get and set methods.

2: Create a uni-directional, many-to-one relationship between *Rental* and *Staff*.

* Use your solution to #1 as a guide.

3: Add the appropriate annotations to describe a bi-directional, many-to-one relationship between *Rental* and *Customer*.

* Don’t forget to add get/set methods.

4: Like #3, create a bi-directional, many-to-one relationship between *Customer* and *Store*.

5: Similar to #3 and #4, add code to describe a bi-directional, many-to-one relationship between *Staff* and *Store*.

6: Finally, build a uni-directional, one-to-one relationship between *Store* and *Staff* so that the *Store* knows its manager.

[Previous](bi_many_to_one.md) | [Next](../ch5/README.md)
