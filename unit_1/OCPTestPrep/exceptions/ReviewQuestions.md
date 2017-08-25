### Review Questions for Students

1: Q: What *must* a `try/catch` block include?

A: It must include at least:
  * a `try`
  * one or more `catch` and/or as many as one `finally`

2: Q: Do you *have* to handle a checked exception in the body of a method? If you don't handle it, what *must* you do?

A: No. You can add a `throws` clause to the method instead.

3: Q: Which objects do *all* exceptions inherit from?

A: `Object`, `Exception`, `Throwable`

4: Q: What is the difference between a checked and an unchecked exception?

A: Checked Exceptions:
  * Must be handled in a method OR the method must declare that it `throws` the exception
  * Are evaluated by the compiler (at compile time)

Unchecked Exceptions:
  * Do not *have* to be handled, or declared
  * Will fail at runtime (not during compilation)

5: Q: If a `catch` has a return, does the `finally` still execute?

A: Yes, `finally` ALWAYS executes (unless there is a `System.exit()`, or a fatal JVM Error)

6: Q: Can a `finally` modify the returned value of a `catch`?

A: Only if the `catch` returns a reference type, if it returns a primitive, the `finally` will still modify the primitive value, but only in the local scope of the method.

7: Q: What order should two unrelated exceptions be caught in? What about two exceptions which share inheritance?

A: It doesn't matter. Most specific to least specific (i.e. child -> parent).

8: Q: Can a `try/catch` rethrow a `caught` exception?

A: Yes! You can do whatever you want with an exception after it has been caught.

9: Q: Do you have to add a `throws` clause to methods with unhandled runtime exceptions?

A: No.

10: Q: Are `Error`s `Exception`s?

A: No, they inherit from `Error`, and `Throwable`, but not `Exception`.

11: Q: Do `Error`s implement `Throwable`?

A: Yes.
