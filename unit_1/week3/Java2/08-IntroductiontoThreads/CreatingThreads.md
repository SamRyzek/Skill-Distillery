## Creating Threads

* Define your own threads by extending `java.lang.Thread` and overriding its `run()` method.

  * The `run()` method defines the life-cycle of the thread.

  * When the end of the `run()` method is reached, the thread is finished (or dead).

* Send a `start()` message to a `Thread` object to activate it.

  * Once a thread has been started, the VM is able to call its `run()` method, whenever it has processor time.

  * The `run()` method is called directly by the VM; you never call `run()` directly.

* You can give a `Thread` a name when constructed, or with the `setName()` method.

  ```java
  thread.setName("MainThread");
  ```

  * `Thread` names are used for display purposes, and can be retrieved and used with the getName() method.

  * If you do not give a `Thread` a name, a unique name is generated and given to it.

<hr>

ThreadApp2.java

```java
package examples;

public class ThreadApp2 {
  public static void main(String[] args) {
    PrintNumbers3 p1 = new PrintNumbers3(1, 2); // odds
    PrintNumbers3 p2 = new PrintNumbers3(2, 2); // evens
    p1.setName("Odds");
    p2.setName("Evens");
    p1.start();
    p2.start();
  }
}

class PrintNumbers3 extends Thread {
  private int start = 0;
  private int increment = 1;

  public PrintNumbers3(int st, int inc) {
    start = st;
    increment = inc;
  }

  public void print() {
    int i, j;
    for (i = start, j = 0; j < 20; j++, i += increment) {
      System.out.println(this.getName() + " " + i);
    }
  }

  @Override
  public void run() {
    print();
  }

}
```

[Prev](NonThreadedApplications.md) | [Up](../README.md) | [Next](ThreadStates.md)

