## Runnable Interface

* It is not always possible to extend the `java.lang.Thread` class.

  * Suppose you are subclassing `JPanel` for a GUI application.

* Instead, you can implement the `java.lang.Runnable` interface.

  * The `Runnable` interface has a `run()` method, just like a `Thread`.

* Your `Runnable` class must be associated with an active `Thread` using these steps:

  1. Implement the `Runnable` interface:

  ```java
  class PrintNumbers5 implements Runnable
  ```

  2. Write the `run()` method to define the life-cycle of your thread:

  ```java
  public void run() {
    // do some neat stuff
  }
  ```

  3. Add a `Thread` field to your class:

  ```java
  private Thread theThread;
  ```

  4. Initialize the thread with your `Runnable` object:

  ```java
  theThread = new Thread(this);
  ```

  5. Start the thread:

  ```java
  theThread.start();
  ```

* When the `Thread` is started, the `Thread`'s `run()` method will call the `Runnable` object's `run()` method automatically.

<hr>

ThreadApp4.java

```java
package examples;

public class ThreadApp4 {
  public static void main(String[] args) {
    PrintNumbers5 p1 = new PrintNumbers5(1, 2); // odds
    PrintNumbers5 p2 = new PrintNumbers5(2, 2); // evens
    p1.setThreadName("Odds");
    p2.setThreadName("Evens");
    p1.startThread();
    p2.startThread();
  }
}

class PrintNumbers5 implements Runnable {
  private int start = 0;
  private int increment = 1;
  private Thread theThread = null;

  public PrintNumbers5(int st, int inc) {
    start = st;
    increment = inc;
    theThread = new Thread(this);
  }

  public void print() {
    int i, j;
    for (i = start, j = 0; j < 20; j++, i += increment) {
      System.out.println(theThread.getName() + " " + i);
      Thread.yield();
    }
  }

  public void run() {
    print();
  }

  public void startThread() {
    theThread.start();
  }

  public void setThreadName(String name) {
    theThread.setName(name);
  }

}
```

[Prev](NonThreadedApplications.md) | [Up](../README.md) | [Next](Labs.md)

