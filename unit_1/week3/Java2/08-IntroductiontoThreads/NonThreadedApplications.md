## Non-Threaded Applications

* Normally, when you call a method, you wait until the method completes before continuing your code.

  * The sequential completion of tasks is a fundamental part of computer programming.

* An application runs in a single process.

  * Modern operating systems allow users to have multiple processes running at the same time.

  * Each process has its own code and data space.

  * The operating system allocates processor time to each process.

<hr>

NonThread.java

```java
package examples;

public class NonThread {
  public static void main(String[] args) {
    PrintNumbers p1 = new PrintNumbers(1, 2); // odds
    PrintNumbers p2 = new PrintNumbers(2, 2); // evens
    p1.print();
    p2.print();
  }
}

class PrintNumbers {
  private int start = 0;
  private int increment = 1;

  public PrintNumbers(int st, int inc) {
    start = st;
    increment = inc;
  }

  public void print() {
    int i, j;
    for (i = start, j = 0; j < 20; j++, i += increment) {
      System.out.println(i);
    }
  }

}
```

#### Try It:

Compile and run the above application. Watch the numbers as they are output.


[Prev](README.md) | [Up](../README.md) | [Next](ThreadedApplications.md)

