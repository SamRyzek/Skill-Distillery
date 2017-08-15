## Special Characters

* In an RE, a . matches any single character (except a newline).

* You can narrow things down by using other special characters.

* `\w` - (*word* character) matches any character in the set **A-Z**, **a-z**, **0-9**, or **_**.

  * `\W` - matches any simple character not in that set.

* `\s` - (*whitespace* character) matches a newline, carriage return, formfeed, tab, or space character.

  * `\S` - matches any non-space character.

* `\d` - (*digit* character) matces a digit, **0-9**.

  * `\D` - matches any non-digit character.

* The above are *character classes*; the generalized form of an RE character class is a list of characters in brackets, [].

  * `[A-Za-z_0-9]` is the same as `\w`.

  * `[\n\r\f\t ]` is the same as `\s`.

  * `[0-9]` is the same as `\d`.

  * If the first character after the opening `[` is a caret, `^`, then the character class matches any character not listed.

    * `[^A-Za-z_0-9]` is the same as `\W` — any character other than these.

    * `[^AEIOU]` matches any simple character that isn't a capital vowel.

<hr>

***Perl RE special characters used in Java***  

|Character|Usage|
|---|---|
|`.` | Matches any character except newline|
|`[a-z0-9]` | Matches any single character of set |
|`[^a-z0-9]` |Matches any single character not in set|
|`\d` |Matches a digit, same as `[0-9]`|
|`\D` |Matches a non-digit, same as `[^0-9]`|
|`\w` |Matches an alphanumeric (word) character `[a-zA-Z0-9_]` |
|`\W` |Matches a non-word character `[^a-zA-Z0-9_]`|
|`\s` |Matches a whitespace char (space, tab, newline . . .) |
|`\S` |Matches a non-whitespace character|
|`\n` |Matches a newline|
|`\r` |Matches a return|
|`\t` |Matches a tab|
|`\f` |Matches a formfeed|
|`\b` |Matches a backspace (inside [] only)|
|`\.` |Matches period
|`\*` |Matches asterisk
|`\|` |Matches pipe|
|`\0` |Matches a null character|
|`\000` |Also matches a null character|
|`\0nn` |Matches an ASCII character of that octal value|
|`\xnn` |Matches an ASCII character of that hexadecimal value |
|`\cX` |Matches an ASCII control character `<ctrl>`X|
|`\metachar` |Matches the character itself (`\|`, `\.`, `\*` ...)|

[Prev](PatternMatchingandRegularExpressions.md) | [Up](../README.md) | [Next](Quantifiers.md)

