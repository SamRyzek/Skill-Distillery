## Executor

* Use the `Executor` interface to launch a `Runnable`, rather than instantiate a `Thread` and call `start()` on it.

```java
Executor ex = ...;
ex.execute(new Task1); // Task1 implements Runnable
ex.execute(new Task2); // Task2 implements Runnable
instead of
Thread t1 = new Thread(new Task1);
Thread t2 = new Thread(new Task2);
t1.start();
t2.start();
```

  * `Executor` is an interface that defines a single `execute()` method.

* Use the `Executors` class as a factory for creating `Executor` implementations.

  * `Executors.newFixedThreadPool(int poolSize)` uses a fixed-size pool of threads to run your tasks in.

  ```java
  Executor ex = Executors.newFixedThreadPool(2);
  ex.execute(new Task1);
  ex.execute(new Task2);
  ```

  * Use `Executors.newCachedThreadPool()` to create a pool with as many threads as necessary to run your tasks.

  * In both cases, threads will be reused after they have completed their task.

  * Each method returns a specialized version of `Executor` called `ExecutorService`.

  * An `ExecutorService` waits for more tasks to invoke, so call the methods `shutdown()` or `shutdownNow()` to tell the `ExecutorService` to exit.

    * `shutdown()` will complete any pending tasks before exiting.

    * `shutdownNow()` will immediately end the `ExecutorService`, even if some threads are currently running.

<hr>

ThreadApp5.java

```java
package examples;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadApp5 {
  public static void main(String[] args) {
    ExecutorService ex = Executors.newFixedThreadPool(2);
    ex.execute(new PrintNumbers6(1, 2));
    ex.execute(new PrintNumbers6(2, 2));
    ex.shutdown();
    //ex.shutdownNow();
  }
}
class PrintNumbers6 implements Runnable {
  private int start=0;
  private int increment=1;

  public PrintNumbers6(int st, int inc) {
    start = st;
    increment = inc;
  }

  public void print() {
    int i, j;
    for (i=start, j=0; j<20; j++, i+=increment) {
      System.out.println(Thread.currentThread().getName() + " " + i);
      if (Thread.interrupted()) {
        break;
      }
      Thread.yield();
    }
  }

  public void run() {
    print();
  }

}
```

#### Try It:

Compile and run ThreadApp5.java to use an `Executor`. Try `shutdownNow()` instead of `shutdown()` to see the `Executor` exit immediately. Try to run the code without either `shutdown()` method. What happens?

[Prev](RaceConditions.md) | [Up](../README.md) | [Next](Callable.md)

