## The Matcher Class

* The `find()` method searches for a substring that matches the pattern.

  * Successive calls to `find()` will start searching at the next character after the last character of the previous match.

  * The `reset()` method sets the starting search position to the first character in the string.

  * The `reset(String s)` replaces the search text.

* The `matches()` method is like the `find()`, but infers a beginning `^` and ending `$` anchor on the pattern.

* The `lookingAt()` method is like `find()`, except it infers a beginning anchor `^`.

* The *Matcher* class has methods that return data about a previous match.

  * `start()` returns the start index of the previous match.

  * `end()` returns the index of the last character matched, plus one.

  * `group()` returns the string which was previously matched by the pattern.

* `replaceFirst(String s)` replaces the first matched pattern with `s`.

* `replaceAll(String s)` replaces all occurrences of the pattern with `s`.

<hr>

```java
package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE5 {
  public static void main(String args[]) {
    String s = "My dog likes to eat. My dog's name is Fred.";

    Pattern p = Pattern.compile("[dD]og");
    Matcher m = p.matcher(s);

    String newString = m.replaceFirst("cat");
    System.out.println("** replaceFirst() example ***\nString \"" +
      s + "\"\n is now: \n\"" + newString + "\"");

    newString = m.replaceAll("cat");
    System.out.println("\n** replaceAll() example ***\nString \"" +
      s + "\"\n is now: \n\"" + newString + "\"");
  }
}

```

#### Try It:
Run RE5.java to use the `replaceFirst()` and `replaceAll()` methods.

[Prev](PatternMatchingandRegularExpressions.md) | [Up](../README.md) | [Next](CapturingGroups.md)

