## Tuning HashMap and HashSet

* When instantiating a `HashMap` you can provide an initial capacity to the constructor.

  * The capacity of the `HashMap` determines how many "buckets" are stored in the underlying hash table implementation; the default is `16`.

* You can also specify a load factor, as a `float`, in addition to the initial capacity.

  * The *load factor* determines how full the hash table can be before the
capacity is increased.

  * `HashMap` retrievals perform best when most of the buckets contain no more than one object.

    * The higher the capacity, the less the chance of collisions.

  * The default value for load factor is `0.75`.

    * This usually provides a good balance between speed and memory usage.

    * Higher values decrease the memory overhead — you will have less empty buckets, more collisions, and slower retrievals.

* Try to anticipate the total number of entries in the map and add extra capacity to allow for the load factor.

  * A `HashMap` that will hold 500 elements with a load factor of 0.75 should have an initial capacity of at least 667.

* `HashSet` uses the keys of an underlying `HashMap` to store its unique elements.

  * Tuning characteristics of a `HashMap` apply to a `HashSet` as well.

<hr>

#### Hash Table Algorithms
Hash table algorithms typically disperse elements into an underlying array of linked lists. Each array index corresponds to a computed hash for the objects that are added in. If two objects both have the same hash calculated (a collision), they will both be accessible from the same index. This is achieved by creating a linked list of objects that all have the same hash value. Each array position is typically called a bucket.

Hash tables are at their fastest when each bucket contains one object. This allows for maximum retrieval speeds, because accessing an object is equivalent to retrieving an element based on an index.

The more objects that are stored in the same bucket, the slower the overall retrieval performance. Not only is an indexed lookup performed, but also each linked list is iterated over, one element at a time.

Increasing the capacity results in better retrieval performance. The more buckets, the fewer contain more than one object. Lower capacities tend to decrease performance, because there are more chances for collisions.

[Prev](SortingwithComparable.md) | [Up](../README.md) | [Next](Labs.md)

