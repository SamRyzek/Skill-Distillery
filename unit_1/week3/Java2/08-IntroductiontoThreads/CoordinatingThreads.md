## Coordinating Threads

* `Thread.yield()` causes the currently-executing thread to give up its time slice.

  * The thread remains in a runnable state.

  * Another runnable thread can start executing.

* `Thread.sleep(long milliseconds)` causes the currently-executing thread to block for the specified number of milliseconds.

  * Once the time has elapsed, the thread returns to the runnable state.

    * It is returned to the thread queue and may be run at any time.

* Block the current thread until the death of another by joining the other thread:

```java
otherThread.join();
```

  * The currently-executing thread is blocked until `otherThread` completes its `run()` method.

  * You can pass a `long` to the `join()` method to limit the block to a specified number of milliseconds.

    * If the other thread doesn't complete by that time, the current thread will become runnable again.

<hr>

ThreadApp3.java

```java
package examples;

public class ThreadApp3 {
  public static void main(String[] args) {
    PrintNumbers4 p1 = new PrintNumbers4(1, 2); // odds
    PrintNumbers4 p2 = new PrintNumbers4(2, 2); // evens
    p1.setName("Odds");
    p2.setName("Evens");
    p1.start();
    p2.start();
  }
}

class PrintNumbers4 extends Thread {
  private int start = 0;
  private int increment = 1;

  public PrintNumbers4(int st, int inc) {
    start = st;
    increment = inc;
  }

  public void print() {
    int i, j;
    for (i = start, j = 0; j < 20; j++, i += increment) {
      System.out.println(this.getName() + " " + i);
      Thread.yield();
    }
  }

  @Override
  public void run() {
    print();
  }

}
```

[Prev](NonThreadedApplications.md) | [Up](../README.md) | [Next](InterruptingThreads.md)

