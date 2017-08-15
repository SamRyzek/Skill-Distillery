## The Pattern Class

* Use `Pattern.compile(String regex)` or `Pattern.compile(String regex, int flags)` to create a pattern object.

  * Some of the flags are:

  |Flag|Usage|
  |---|---|
  |CASE_INSENSITIVE|Allowscase-insensitivematching.|
  |COMMENTS|Allows white space and comments in a pattern.|
  |MULTILINE|Searches for patterns in a multiline string.|

  * The following will match "CAT", "Cat", "cat", etc. . .

```java
Pattern p = Pattern.compile("cat",Pattern.CASE_INSENSITIVE);
```

* The `flags()` method returns which flags are set for a pattern.

```java
int fl = p.flags();
```

* The `pattern()` method returns the regular expression.

```java
String re = p.pattern();
```

* You may split a string with the `split(CharSequence c)` method.

```java
Pattern p = Pattern.compile("[|]"); 
String[] words = p.split("This|is|a|test.");￼
```

* For a single-use pattern:

```java
boolean b=Pattern.matches("a*b", "aaaab");
```

* This works like the `matches()` method in the `Matcher` class.

<hr>

```java
package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE4 {
    public static void main(String args[]) {
        String s = "TEXT IN ALL CAPS";

        // Pattern p = Pattern.compile("all");
        Pattern p = Pattern.compile("all", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);

        boolean result = m.find();
        System.out.println("*** Case sensitive test***");
        System.out.println("\"" + p.pattern() + "\" matches \"" + s
                + "\" --> " + result);

        s = "Perhaps,this,is,a,flatfile,database";
        p = Pattern.compile(",");
        String[] words = p.split(s);

        System.out.println("*** Split test ***");
        for (String word : words) {
            System.out.println(word);
        }
    }
}

```

#### Try It:
Run RE4.java to try a case-insensitive search and to split a string.

[Prev](PatternMatchingandRegularExpressions.md) | [Up](../README.md) | [Next](TheMatcherClass.md)

