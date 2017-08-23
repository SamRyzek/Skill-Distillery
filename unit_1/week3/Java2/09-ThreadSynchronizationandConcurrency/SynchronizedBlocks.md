## Synchronized Blocks

* You should minimize the amount of synchronized code to avoid deadlocks.

* Marking a method synchronized locks the invoking object for the duration of the method call.

```java
public synchronized void deposit(double amount) {…}
```

* You can also use the `synchronized` keyword to synchronize a block of code.

```java
synchronized (this) {
  // code to synchronize
}
```

  * The object you pass in the parentheses is the one whose lock is held.

<hr>

AccountSynchronized2.java

```java
package examples;

public class AccountSynchronized2 {
  private double balance;

  public AccountSynchronized2(double initialBalance) {
    balance = initialBalance;
  }

  public void deposit(double amount) {
    synchronized (this) {
      balance += amount;
    }
  }

  public void withdraw(double amount) {
    synchronized (this) {
      balance -= amount;
    }
  }

  public double getBalance() {
    return balance;
  }
}
```

If you have studied concurrency before, then the terminology you may be used to is mutex instead of lock, monitor for the object that we are locking, and critical section for the portion of code that is wrapped by the synchronized block.

[Prev](RaceConditions.md) | [Up](../README.md) | [Next](SynchronizedCollections.md)

