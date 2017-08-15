## Regular Expressions in Java

* In Java, the tools for using REs are found primarily in two classes, both in `java.util.regex`.

  * The `Pattern` class.

  * The `Matcher` class.

* The `Pattern` and `Matcher` classes work together.

  1. The `Pattern` class takes an RE string and compiles it into an internal representation contained in a `Pattern` object.

  2. Next, a `Matcher` object is created by the `Pattern` object.

  3. Finally, strings are sent to the `Matcher` object to see if they match the pattern.

* Here is a snippet that shows a basic example of using these classes:

```java
// Determine if the pattern ERROR occurs in a line 
Pattern p = Pattern.compile("ERROR");
Matcher m = p.matcher("Abort: ERROR 339 has occurred"); 
boolean result = m.find();
```

  * The `m.find()` method searches the string held in the `Matcher` object `m` to see if the pattern `"ERROR"` occurs in the string.

  * If the pattern is found in the string, it is called a *match*.

  * `find()` returns `true` if it finds a match, otherwise `false`.

<hr>

```java
package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE1 {
    public static void main(String[] args) {
        String re = "303";
        String string1 = "(303) 555-1212";
        String string2 = "(720) 555-1212";

        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(string1);

        boolean result = m.find();
        System.out.println("find() is " + result + ".");

        // change the search String
        m.reset(string2);
        result = m.find();
        System.out.println("find() is " + result + ".");
    }
}
```

[Prev](PatternMatchingandRegularExpressions.md) | [Up](../README.md) | [Next](RegularExpressionSyntax.md)

