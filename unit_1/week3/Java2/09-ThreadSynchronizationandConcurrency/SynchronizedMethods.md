## Synchronized Methods

* To avoid race conditions, mark any methods that modify the invoking object's fields as synchronized.

```java
public synchronized void deposit(double amount) {…}
```

* The Virtual Machine maintains a single "lock" and "key" for each object.

  * In order to enter a synchronized block of code, a thread must lock the object and hold the key.

    * If a thread encounters a locked section of code, then it blocks until the key is available.

  * Upon exiting a synchronized block of code, the thread unlocks the object and returns the key.

* Only one thread at a time may be in any synchronized block within an object.

  * Synchronization is applied at the object level, not at the class level.

* Many threads can run in un-synchronized, unlocked sections of code simultaneously.

<hr>

AccountSynchronized.java

```java
package examples;

public class AccountSynchronized {
  private double balance;

  public AccountSynchronized(double initialBalance) {
    balance = initialBalance;
  }

  public synchronized void deposit(double amount) {
    double tempBalance = balance;
    tempBalance = tempBalance + amount;
    balance = tempBalance;
  }

  public synchronized void withdraw(double amount) {
    balance -= amount;
  }

  public double getBalance() {
    return balance;
  }
}
```

AccountTester2.java
```java
...
public class AccountTester2 extends Thread {
  ...
  public static void main(String[] args) {
    AccountSynchronized account = new AccountSynchronized(0.0);
    AccountTester2 tester1 = new AccountTester2(account, 2);
    AccountTester2 tester2 = new AccountTester2(account, 3);
    tester1.start();
    tester2.start();
    ...
    System.out.println("End balance is: " + account.getBalance());
  }
}
```

#### Try It:

Compile and run AccountTester2.java.

[Prev](RaceConditions.md) | [Up](../README.md) | [Next](Deadlocks.md)

