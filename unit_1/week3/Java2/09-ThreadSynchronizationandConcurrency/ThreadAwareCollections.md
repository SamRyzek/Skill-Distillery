## Thread-Aware Collections

* `java.util.concurrent` provides additional versions of standard collection classes that can be accessed in a concurrent context.

  * Most of these classes use the `java.util.concurrent.locks`' locking mechanisms to avoid suffering from the performance bottleneck of the single object lock that synchronized uses.

* `CopyOnWriteArrayList` and `CopyOnWriteArraySet` perform well for read operations by allowing multiple, simultaneous reader threads.

  * Modifying the object involves the changes being written to a new copy of the underlying array that is later copied back into the original.

    * An `Iterator` retrieved before the copy was made will utilize a snapshot of the original array.

    * Any new `Iterators` will be based on the copy.

  * Copying the array is an expensive operation, so only use these classes when you do a lot more reading than writing.

* `ConcurrentHashMap` can be used instead of a synchronized `HashMap` for multi-threaded access to a `Map` without the overhead of synchronization.

  * `ConcurrentHashMap` does not synchronize reads.

    * A read operation will return the most recent update.

  * By default, up to 16 simultaneous writes can occur due to the way that the collection is segmented.

<hr>

States2.java

```java
...
public class States2 {
  public static void main(String[] args) {
    List<String> nonThreadSafeStates = getListOfStatesAndTerritories();
    CopyOnWriteArrayList<String> states = new CopyOnWriteArrayList<>(nonThreadSafeStates);

    removeTerritories(states);
    // Loop through the list, displaying each value
    Iterator<String> it = states.iterator();
    while (it.hasNext()) {
      System.out.print(it.next());
      if (it.hasNext())
        System.out.print(", ");
      else
        System.out.println();
    }
  }

  private static void removeTerritories(List<String> states) {
    new Thread(new Runnable() {
      public void run() {
        for (int i = 0; i < states.size(); i++) {
          String state = states.get(i);
          switch (state) {
            case "AS":
            case "GU":
            case "PR":
            case "VI":
              states.remove(i);
              break;
          }
        }
      }
    }).start();
  }
  ...
}
```

#### Try It:

Compile and run States2.java to use a `CopyOnWriteArrayList`.

[Prev](RaceConditions.md) | [Up](../README.md) | [Next](Executor.md)

