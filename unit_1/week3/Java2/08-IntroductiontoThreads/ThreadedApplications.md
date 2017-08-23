## Threaded Applications

* Most operating systems allow a single process to have multiple _threads_ of execution.

  * A thread is also called a _lightweight process_, because it is quicker to use multiple threads than to use multiple processes.

* In the same way that processes appear to run at the same time, threads can appear to run at the same time.

  * The processor time given to one process is divided up among its threads.

  * While one thread is waiting for some task to finish, such as printing or disk access, another thread can be using the CPU.

* Every Java program has at least one thread running that is started by the Virtual Machine.

  * This thread is typically called the _main_ or _application_ thread.

  * If additional threads are not explicitly created, your program will behave just like a non-threaded application.

* Additional threads are created and started by the program.

  * The system may change which thread it is running at any time.

  * You can help schedule and coordinate the threads in your application.

* All of the threads in a process can share code and data.

<hr>

ThreadApp.java

```java
package examples;

public class ThreadApp {
  public static void main(String[] args) {
    PrintNumbers2 p1 = new PrintNumbers2(1, 2); // odds
    PrintNumbers2 p2 = new PrintNumbers2(2, 2); // evens
    p1.start();
    p2.start();
  }
}

class PrintNumbers2 extends Thread {
  private int start = 0;
  private int increment = 1;

  public PrintNumbers2(int st, int inc) {
    start = st;
    increment = inc;
  }

  public void print() {
    int i, j;
    for (i = start, j = 0; j < 20; j++, i += increment) {
      System.out.println(i);
    }
  }

  @Override
  public void run() {
    print();
  }

}
```

#### Try It:

Now, compile and run the multi-threaded version. Watch the numbers as they are output. The numbers might appear in different orders on different environments.

[Prev](NonThreadedApplications.md) | [Up](../README.md) | [Next](CreatingThreads.md)

