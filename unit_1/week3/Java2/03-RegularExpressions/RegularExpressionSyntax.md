## Regular Expression Syntax

* REs provide a comprehensive syntax for specifying patterns of text.

* The most simple REs are literals, which are searched for by direct string comparison.

  * The RE `"A"` will match each of the following strings:

  ```java
  "An apple a day ..."
  "We skied Aspen for several days."
  ```

  * The RE `"bro"` will match each of these strings:

  ```java
  "Bottles were broken all over the place."
  "I called her sis, and him bro."
  "I called my sister sis, and my brother bro."
  ```

* REs can also contain special characters, or *metacharacters*, that have special meaning.

* The `^` metacharacter means a pattern must start at the beginning of the string.

  * The RE `"^A"` matches the first string but not the second:

  ```java
  "An apple a day ..."
  "We skied Aspen for several days."
  ```

* The period metacharacter matches any single character.

  * The RE `"12."` matches any three-character sequence starting with `"12"`:

  ```java
  "125"
  "As simple as 123"
  "The address is 7412 Main Street." What matches! 
  "Today I turned 12" Why does this not match?
  ```

<hr>

```java
package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RETest {
    public static void main(String[] args) {
        Pattern p = Pattern.compile(args[1]);
        Matcher m = p.matcher(args[0]);

        // Search args[0] for pattern in args[1]
        boolean result = m.find();
        System.out.println("find() is " + result + ".");
    }
}
```

#### Try It:
The program *RETest.java* lets you experiment with different RE patterns and different strings.

Run it with the string to be searched in `args[0]` and the RE in `args[1]`:


```java
java RETest hello e
java RETest Aspen "^A"
java RETest "The A is not first" "^A"
```

[Prev](PatternMatchingandRegularExpressions.md) | [Up](../README.md) | [Next](SpecialCharacters.md)

