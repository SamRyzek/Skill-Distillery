## Quantifiers

* *Quantifiers* match a sequence of a single character, of members of a character class, or of a subexpression.

* `*` is the least specific, matching any number, even zero, of the preceding RE character.

  * `\d*` Matches any sequence of digits, or none at all.

  * `.*` Is the general-purpose, match-anything-at-all RE.

* `+` matches one or more of the preceding RE character.

  * `\d+` Matches a sequence of digits.

* `?` matches either zero or one of the preceding RE character.

* You can specify any quantity of an RE character by using {}.

  * `{n}` - Matches exactly `n` occurrences of the preceding RE character.

    * `\w\d{4}\s` - Matches a word character, followed by exactly four digits, followed by a whitespace character.

  * `{n,}` - Matches n or more occurrences of the preceding RE character.

    * `\w\d{4,}\s` - Matches a word character, followed by at least four digits, followed by a whitespace character.

  * `{n,m}` - Matches at least n but no more than m occurrences of the preceding RE character.

    `\w\d{4,7}\s` - Matches a word character, followed by four, five, six, or seven digits, followed by a whitespace character.

<hr>

Here are some more examples using quantifiers. Because the backslash is the escape character in Java, remember to precede a backslash with another backslash in a literal string.

* `"\\d{2,3}\\s\\w+"`

  * Matches two or three digits, followed by a space character, followed by one or more word characters.

* `"\\d{5,}"`

  * Matches a string that contains at least five digits.

* `"animals?\\s"`

  * Matches "animal " or "animals " — note the trailing space.

```java
package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE2 {
    public static void main(String[] args) {

        String[] words = { "IT", "1265478654", "  3453453   ", "wow",
                "some spaces", "101 dalmations", "agent007", ".",
                "another example" };

        String[] regExs = { "\\d{7,}", "\\s+\\w+\\s+", "..." };

        for (String re : regExs) {
            Pattern p = Pattern.compile(re);

            for (String word : words) {
                Matcher m = p.matcher(word);
                boolean result = m.find();
                System.out.println("Pattern \"" + re + "\"  ->  \""
                        + word + "\": " + result);
            }
        }
    }
}
```

#### Try It:
Before running RE2.java, predict which patterns in the *regExs* array will be found in which strings in the *words* array.

[Prev](PatternMatchingandRegularExpressions.md) | [Up](../README.md) | [Next](Assertions.md)

