## Capturing Groups

* Your RE can remember what it grabbed and use it for future reference.

* Use parentheses () in the pattern to denote a captured group.

```java
Pattern p = Pattern.compile("(\\w+)(\\s+)(\\w+)");
```

  * The matched string from each group is stored in the `Matcher` object.

  * Subsequent replacement and append methods can refer to the first matched string as `$1`, the second as `$2`, etc.

  * Retrieve the string for the corresponding group with the `group(int i)` method.

* You may also nest groups.

```java
Pattern p = Pattern.compile("^((\\w+)(\\s+)(\\w+))$");
```

  * The outermost group will be given the lowest group number.

* `groupCount()` returns the number of capturing groups in the RE.

<hr>

```java
package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE6 {
    public static void main(String args[]) {
        String s = "These     are     spaces";

        // grab 1 or more word chars, 1 or more space chars...
        Pattern p = Pattern.compile("(\\w+)(\\s+)(\\w+)");
        Matcher m = p.matcher(s);

        String newString = m.replaceFirst("$3$2$1");

        System.out.println("Group 1: " + m.group(1) + "\nGroup 2: "
                + m.group(2) + "\nGroup 3:" + m.group(3));

        System.out.println("String \"" + s + "\"\nis now: \n\""
                + newString + "\"\n");

        p = Pattern.compile("^((\\w+)(\\s+)(\\w+))$");
        m = p.matcher("Agent 007");

        m.find();
        for (int i = 1; i <= m.groupCount(); i++) {
            System.out.println("Group " + i + ": " + m.group(i));
        }
    }
}

```

#### Try It:
Run RE6.java to work with groups.

#### Note:
To match an open parenthesis, use "\(". To match a close parenthesis, use "\)"

[Prev](PatternMatchingandRegularExpressions.md) | [Up](../README.md) | [Next](Labs.md)

