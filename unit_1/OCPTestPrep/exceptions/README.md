# Exceptions Notes
### Overview
Mastering Java exception handling requires proficiency in:

  * The fundamental Java language rules for exception handling.

  * Exception class inheritance.

  * [The `java.lang.Throwable` class hierarchy](https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html).

    * This includes well-known exception class names under, for example, java.lang and java.io.
  

### Important Points
#### Java language rules for exception handling

  * `try/catch` syntax:

    * 1 `try` block

    * If the try block includes an exception-throwing statement, 1 or more `catch` blocks

    * 0 or 1 `finally` block

    * `finally` ALWAYS executes

      * Even if `catch` has a return statement

      * Unless!! `System.exit()` or a fatal jvm error

    * If both `catch` and `finally` return, the `catch`'s return will be evaluated, but not returned, the `finally` will return the value.

      * if `catch` returns (and `finally` does not), the finally can modify the value of a reference variable, but not of a primitive.

  * You can rethrow a `caught` exception, however, if it is a checked exception you will either need to handle it or add a `throws` clause to the method

  * You can nest try/catch blocks

* Checked vs Unchecked Exceptions

  * Checked exceptions must either be handled or declared by the method as `throws`

  * Unchecked exceptions do not *have* to be handled or declared, but they can be.
  
#### Exception inheritance

* `catch` blocks must be ordered such that the most specific exception is caught first

  * Otherwise subsequent `catch` blocks for subclasses will be unreachable and compilation will fail

#### java.lang.Throwable class hierarchy ([Diagram](Exceptions.png))

* `Throwable`

  * The ancestor of all `Error` and `Exception` classes.

  * Has a `message` attribute and a constructor taking a `String message`.

  * `toString()` returns "_classname_: _message_".

  * Has a snapshot of its thread's exception stack.

    * `Throwable.printStackTrace()` prints this to `System.err` by default.
    
* `Error`

  * `Error` subclasses `Throwable` -> NOT `Exception`

  * Errors can be caught, but usually nothing can be done and they are not considered the programmer's responsibility.

  * Example `Error` descendants:

    * `java.io.IOError`

    * `java.lang.VirtualMachineError`

      * `java.lang.InternalError`

      * `java.lang.OutOfMemoryError`

      * `java.lang.StackOverflowError`

      * `java.lang.UnknownError`
      
* `Exception`

  * `Exception` subclasses `Throwable`

  * All `Exception`s other than descendants of `RuntimeException` are **checked exceptions**

  * A method containting a statement which can throw a checked expression must either:

    * Declare that it throws that same exception.

    * Enclose the statement in a `try`/`catch` block catching the exception or _one of its ancestors_.

  * Well-known checked exceptions:

    * `java.io.IOException`

      * `java.io.FileNotFoundException`

      * `java.io.ObjectStreamException`

        * `java.lang.NotSerializableException`

      * `java.net.SocketException`
      
* `RuntimeException`

  * `RuntimeException` subclasses `Exception`

  * Descendants of `RuntimeException` need not be declared or caught.

  * Example `RuntimeException` descendants:

    * `java.lang.NullPointerException`

    * `java.lang.IndexOutOfBoundsException`

      * `java.lang.ArrayIndexOutOfBoundsException`

      * `java.lang.StringIndexOutOfBoundsException`    

    * `java.lang.IllegalArgumentException`

      * `java.lang.NumberFormatException`

    * `java.lang.IllegalStateException`

    * `java.lang.ClassCastException`

    * `java.lang.SecurityException`

