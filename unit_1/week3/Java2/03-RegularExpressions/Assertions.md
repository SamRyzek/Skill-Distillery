## Assertions

* Assertions anchor a pattern to a specific location in a string.

* `^` and `$` anchor a pattern to the beginning or ending, respectively, of a string.

  * `^s\d` Matches a line starting with `s` followed by a digit.

  * `sh$` Matches a line ending with `sh`.

* `\b` anchors a pattern to a word boundary.

  * A *word boundary* is simply a position with a word character (`\w`) on one side but not on the other.

  * `\B` matches a position other than a word boundary — a position with word characters (`\w`) on either side or with non-word characters (`\W`) on either side.

<hr>

* Here are some examples that use assertions:

* `"^\\d+$"`

  * Matches a string that contains only digits.

* `"^...$"`

  * Matches a string with exactly three characters.

* `"\\.$"`

  * Matches a string that ends with a period.

* `"\\bis\\b"`

  * Matches a string that contains the word is.

```java
package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE3 {
    public static void main(String[] args) {
        String s = "This is a test.";
        Pattern p = Pattern.compile("\\bis\\b");
        Matcher m = p.matcher(s);

        boolean result = m.find();

        if (result) {
            System.out.println("Found \"\\bis\\b\" at index "
                    + m.start() + " for string \"" + s + "\"");
        }
        else {
            System.out.println("No match.");
        }
    }
}

```

#### Try It:
Run *RE3.java* to find the word `is`.

[Prev](PatternMatchingandRegularExpressions.md) | [Up](../README.md) | [Next](ThePatternClass.md)

