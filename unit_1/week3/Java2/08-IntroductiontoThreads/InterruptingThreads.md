## Interrupting Threads

* `join()` and `sleep()` are `Thread` methods that do not return immediately.

  * You may need to "wake up" a `Thread` that is in the middle of one of these methods.

    * Perhaps this `Thread` is waiting for something that is never going to happen!

* Calling `interrupt()` on a `Thread` will cause its `join()` or `sleep()` method to throw an `InterruptedException`.

  * You must handle or declare the `InterruptedException` when using these `Thread` methods.

* If the thread is not currently blocked, an "interrupted" flag will be set for that thread.

  * You can determine if a `Thread` was interrupted by calling `isInterrupted()`.

  ```java
  if (thatThread.isInterrupted())
  // someone tried to interrupt thatThread
  ```

  * Test the currently-running `Thread` with the `interrupted()` static method.

  ```java
  if (Thread.interrupted())
  // someone tried to interrupt me,
  // since I am the currently running Thread
  ```

<hr>

[Prev](NonThreadedApplications.md) | [Up](../README.md) | [Next](RunnableInterface.md)

