## Race Conditions

* Threads share code and data space.

  * Two threads running in the same object can both modify the same field.

    * The timing of context switches may result in one thread being suspended in the middle of modifying a field.

    * Meanwhile another thread may modify the same field.

    * When the first thread runs again, it may be working with old data.

    * This behavior is called a race condition.

* Each thread maintains its own stack.

  * Local variables are not susceptible to race conditions.

* Beware: context switches can occur in the middle of a statement.

  * A single Java source code statement can be made up of multiple byte code instructions.

<hr>

Account.java

```java
...
public class Account {
  private double balance;
  public Account(double initialBalance) {
    balance = initialBalance;
  }
  public void deposit(double amount) {
    double tempBalance = balance;
    tempBalance = tempBalance + amount;
    balance = tempBalance;
  }
  ...
}
```

AccountTester.java

```java
...
public class AccountTester extends Thread {
  private Account theAccount = null;
  private double depositAmount = 0.0;
  ...

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      theAccount.deposit(depositAmount);
    }
  }

  public static void main(String[] args) {
    Account account = new Account(0.0);
    AccountTester tester1 = new AccountTester(account, 2);
    AccountTester tester2 = new AccountTester(account, 3);
    tester1.start();
    tester2.start();
    ...
    System.out.println("End balance is: " + account.getBalance());
  }
}
```

#### Try It:

Compile and run AccountTester.java to see a race condition. If the end balance is 5,000, then run it again.

[Prev](README.md) | [Up](../README.md) | [Next](SynchronizedMethods.md)

