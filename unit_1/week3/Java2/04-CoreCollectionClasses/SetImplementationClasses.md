## Set Implementation Classes

* `HashSet` is a general-purpose implementation of the `Set` interface.

  * A `HashSet` contains unique objects whose order is not guaranteed.

  * The `hashCode()` and `equals()` methods work in combination to ensure that only unique objects are in the set.

    * Your `hashCode()` method should return a unique hashcode, however you define "unique."

* `TreeSet` implements the `SortedSet` interface.

  * `TreeSet` extends the functionality of `HashSet` by sorting elements as they are added to and removed from the set.

* `LinkedHashSet` is a `HashSet` that implements the `Set` interface.

  * `LinkedHashSet` guarantees that the order of iteration will be insertion-order.

    * `HashSet` makes no guarantees about order.

    * `TreeSet` sorts on each insertion and removal: an expensive operation.

<hr>

```java
package examples;

public class CD {
    private int id;
    private String artist;
    private String title;

    public CD(int i, String a, String t) {
        id = i;
        artist = a;
        title = t;
    }

    @Override
    public String toString() {
        return "CD [id=" + id + ", artist=" + artist + ", title="
                + title + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((artist == null) ? 0 : artist.hashCode());
        result = prime * result + id;
        result = prime * result
                + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CD other = (CD) obj;
        if (artist == null) {
            if (other.artist != null)
                return false;
        }
        else if (!artist.equals(other.artist))
            return false;
        if (id != other.id)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        }
        else if (!title.equals(other.title))
            return false;
        return true;
    }
}
```

```java
package examples;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
//import java.util.LinkedHashSet;

public class SetTest {
    public static void main(String args[]) {
        CD cd1 = new CD(1, "The Beatles", "The Beatles 1");
        CD cd2 = new CD(2, "Prince", "The Very Best of Prince");
        CD cd3 = new CD(3, "Garth Brooks", "The Ultimate Hits");
        CD cd4 = new CD(3, "Garth Brooks", "The Ultimate Hits");

        Set<CD> cdCollection = new HashSet<>();
        // Set<CD> cdCollection = new LinkedHashSet<>();

        cdCollection.add(cd1);
        cdCollection.add(cd2);
        cdCollection.add(cd3);
        cdCollection.add(cd4);

        Iterator<CD> it = cdCollection.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
```

[Prev](TheCollectionsFramework.md) | [Up](../README.md) | [Next](TheMapInterface.md)

