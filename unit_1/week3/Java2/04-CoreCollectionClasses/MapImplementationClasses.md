## Map Implementation Classes

* `HashMap` stores keys and values using an underlying hash algorithm.

  * Because it is based on a hash, `put`s and `get`s operate at constant-time performance.

  * The iteration order of a `HashMap` is not guaranteed.

  * Both keys and values are allowed to be `null`.

  * The legacy class `Hashtable` differs from `HashMap` in two ways:

    * `Hashtable` does not allow `null` keys.

    * `Hashtable`'s methods are `synchronized`, `HashMap`'s are not.

* `LinkedHashMap` adds ordered iteration to `HashMap`.

  * The `keySet()` method will return a `Set` of keys that are in insertion order.

* `TreeMap` implements the `SortedMap` interface.

  * `TreeMap` objects are sorted based upon the key at the time of insertion and removal.

  * `keySet()` returns a `Set` of keys in ascending order.

<hr>

```java
package examples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//import java.util.LinkedHashMap;

public class MapTest {
    public static void main(String args[]) {
        CD cd1 = new CD(1, "The Beatles", "The Beatles 1");
        CD cd2 = new CD(2, "Prince", "The Very Best of Prince");
        CD cd3 = new CD(3, "Garth Brooks", "The Ultimate Hits");

        Map<String, CD> cdCollection = new HashMap<>();
        // Map<String,CD> cdCollection = new LinkedHashMap<>();

        cdCollection.put("B00004ZAV3", cd1);
        cdCollection.put("B00005M989", cd2);
        cdCollection.put("B000UVT3OI", cd3);

        Set<String> s = cdCollection.keySet();
        Iterator<String> it = s.iterator();

        while (it.hasNext()) {
            String key = it.next();
            System.out.print("Key: " + key);
            System.out.println(" Value: " + cdCollection.get(key));
        }
    }
}
```

#### Try It:

Run MapTest.java. What order are the CD's printed in? Why? Rerun MapTest.java using the `LinkedHashMap` collection.

[Prev](TheCollectionsFramework.md) | [Up](../README.md) | [Next](Labs.md)

