## Deadlocks

* If making your code synchronized prevents race conditions, then why not synchronize all threaded code?

  * Code running in `synchronized` blocks is slower.

    * `synchronized` code is single-threaded.

  * Excessively marking code as synchronized may lead to deadlocks.

    * A deadlock occurs when one thread, which has locked Object A, wants to call a `synchronized` method on Object B.

    * However, Object B has already been locked by another thread that is currently waiting to acquire the key for Object A.

    * Neither thread can proceed until the other releases its lock.

* All it takes is two objects and two threads to have a deadlock.

* Minimize the amount of `synchronized` code to prevent deadlocks.

* Design your code to avoid deadlock conditions.

<hr>

DeadLockExample.java
```java
...
public class DeadLockExample {
  public static ClassA a;
  public static ClassB b;
  public static void main(String[] args) {
    a = new ClassA();
    b = new ClassB();
    a.start();
    b.start();
  }
}
class ClassA extends Thread {
  public synchronized void method1() {
    System.out.println(this.getName() + " acquired A's lock");
    Thread.yield(); // force deadlock
    System.out.println(this.getName() + " calling B's method");
    DeadLockExample.b.method4();
    System.out.println(this.getName() + " released A's lock");
  }
  public synchronized void method2() { }
  public void run() {
    this.method1();
  }
}
class ClassB extends Thread {
  public synchronized void method3() {
    System.out.println(this.getName() + " acquired B's lock");
    System.out.println(this.getName() + " calling A's method");
    DeadLockExample.a.method2();
    System.out.println(this.getName() + " released B's lock");
  }
  public synchronized void method4() { }
  public void run() {
    this.method3();
  }
}
```

#### Try It:

Compile and run DeadLockExample.java to cause a deadlock. At a command prompt, run the `jstack` command followed by the process id of your Java program to see a thread dump and find the deadlock.

[Prev](RaceConditions.md) | [Up](../README.md) | [Next](SynchronizedBlocks.md)

