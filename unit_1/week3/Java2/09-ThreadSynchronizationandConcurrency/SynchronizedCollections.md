## Synchronized Collections

* Collections, such as `ArrayList` and `HashMap`, were written in a non threadsafe manner for performance purposes.

  * The legacy classes `Vector` and `Hashtable` are thread-safe, but performance suffers because their methods are synchronized.

  * Collections' `synchronizedCollection()`, `synchronizedList()`, and `synchronizedMap()` methods convert a non-synchronized collection into a synchronized version of it.

* Even with the synchronized version of a collection, it may not be sufficiently safe.

  * Iteration, for example, may need additional synchronization since the size of the list can change if another thread is concurrently removing items from the list.

  ```java
  synchronized(list) {
    for (int i=0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
  ```

  * Use a `synchronized` block to lock the list itself while iterating.

<hr>

States.java

```java
...
public class States {
  public static void main(String[] args) {
    List<String> nonThreadSafeStates = getListOfStatesAndTerritories();

    List<String> states = Collections.synchronizedList(nonThreadSafeStates);

    removeTerritories(states);

    // Loop through the list, displaying each value
    synchronized (states) {
    Iterator<String> it = states.iterator();
    while (it.hasNext()) {
      System.out.print(it.next());
      if (it.hasNext())
        System.out.print(", ");
      else
        System.out.println();
      }
    }
  }

  private static void removeTerritories(List<String> states) {
    new Thread(new Runnable() {
      public void run() {
        synchronized (states) {
          for (int i = 0; i < states.size(); i++) {
            String state = states.get(i);
            switch (state) {
              case "AS": case "GU": case "PR": case "VI":
                states.remove(i);
                break;
            }
          }
        }
      }
    }).start();
  }
  ...
}
```

#### Try It:

Run States.java with and without the synchronized blocks to see why the additional synchronization is necessary even though the list itself is synchronized.

[Prev](RaceConditions.md) | [Up](../README.md) | [Next](ThreadAwareCollections.md)

