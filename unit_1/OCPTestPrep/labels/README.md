## Labels, `break`, and `continue`

### Labels
* A *label* is an identifier followed by a colon, `:`.

  ```
  someLabel:
  ```

* A label must occur before a statement or a block.

  ```
  someLabel: doSomething(); // pretty much useless

  otherLabel:
  {
    doSomething();
    doSomethingElse();
  }

  yetAnotherLabel:
  for (int i=0; i<42; i++) {
    doSomething();
    doSomethingElse();
  }
  ```

  * The statement or block becomes a *labeled statement*.

  * **The scope of the label is the *labeled statement*.**

### `break`

* The `break` statement can occur in:

  * Any loop.

  * A `switch`.

  * A labeled block.

* Two forms of `break`:

  * Unlabeled: `break;`

    * Can occur only in a loop or a `switch`.

    * Breaks out of the innermost containing loop or `switch`.

  * Labeled: `break someLabel;`

    * Breaks out of the labeled loop or block.

### `continue`

* The `continue` statement can occur __only in a loop__:

  * Jumps to the top of the loop, skipping the remaining loop body.

    * For a `while` or `do`, the loop's test condition is evaluated - while(_condition_).

    * For a `for`, the loop's increment expression is evaluated - for(;;_updateStatement_), then the test condition - for(;_condition_;) is evaluated as usual.

* Two forms of `continue`:

  * Unlabeled: `continue;`

    * Continues the innermost containing loop.

  * Labeled: `continue someLabel;`

    * Continues the labeled containing loop.

### Label Scope

* With labeled break or continue, the label must be in scope - that is, the labeled loop or block _must_ enclose the break or continue statement.

  * This makes labeling a standalone statement pretty much useless.
