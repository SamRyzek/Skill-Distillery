## Regular Expressions
### Text Searching with Power
Regular Expressions allow us to efficiently apply a _pattern_ to any amount of _source text_ and:
* Determine if the text matches the pattern.
* Determine in how many places the text matches the pattern.
* Retrieve the matched portion of the text.
  *  Retrieve matched sub-patterns.
* Replace the matched portions with new text.

### Patterns
The pattern specificed by a Regular Expression - a.k.a. RegEx or RE - consists of _literal text_ to search for as well as RE _metacharacters_ representing pattern components and features.  REs are by design compact, terse, and very precise.

You can find a number of online Regular Expression testers, and there are many command-line tools (```grep```, ```sed```, ```awk```, etc.) that process Regular Expressions.

Let's experiment with these using http://regex101.com/  

#### Options
* Global (```g```): By default, once a match is found the regex stops processing; the _global_ option continues processing the RE over the rest of the input text.
* Multiline (```m```): By default, ```^``` matches the very beginning of the input text, and ```$``` the very end; if the input text is actually multiple lines (text with embedded newlines), the _multiline_ option causes ```^``` to match the beginning and ```$``` to match the end of each embedded line.
* Case-insensitive (```i```): RE pattern matching is case-sensitive, unless you use the _case-insensitive_ option.

#### Literals and Wild Cards
* An ordinary letter or digit is interpreted literally (except when part of certain particular RE components... coming up)
* ```.``` is a wildcard that matches any single character other than the newline `\n`.
* A pair of square brackets containing a sequence of characters matches an occurence of any of those characters.
  * These are called _character classes_:
    *  ```[aeiou]``` - match any vowel
    *  ```[0123456789]``` - match any digit
    *  ```[a-z]``` - match any lowercase letter.
      * In square brackets, a hyphen between to characters means a range; for a literal hyphen, include it next to either the opening or closing bracket
        * ```[a-z-]``` - match any lowercase letter or hyphen character;
    * A leading ```^``` inside the brackets inverts the meaning of the match:
      * ```[^0123456789]``` - match anything EXCEPT a digit
  * Special character-class shorthands include:
    * ```\w``` - match a "word" character (characters you'd use in a variable name): same as ```[a-zA-Z0-9_]```
      * ```\W``` - match anything EXCEPT a word character.
    * ```\d``` - match a digit character: same as ```[0123456789]``` or ```[0-9]```
      * ```\D``` - match anything EXCEPT a digit.
    * ```\s``` - match a white-space character: space, tab, carriage return, newline, etc
      * ```\S``` - match character EXCEPT white space
* A character that would otherwise be an RE metacharacter can be escaped with a backslash:
  * ```\[``` - match an actual opening square bracket
  * ```\.``` - match an actual dot character
  * ```\(``` - match an actual parenthesis

#### Assertions
Also called _anchors_ or even _zero-width assertions_, these specify a _position_ in the source text, not any text itself.
* ```^``` - match the beginning of the source text.
* ```$``` - match the end of the source text.
* ```\b``` - match a boundary between word and non-word characters.

#### Quantifier
A quantifier specifies the number of occurances of the item that precedes it:
* ```*``` - a sequence of zero or more if the item
  * ```^\d*``` - match text beginning with a sequence of digits, or with no digits at all.
A quantifier specifies the number of occurances of the item that precedes it:
* ```+``` - a sequence of one or more if the item
  * ```^\d+``` - match text beginning with a sequence at least one digit.
* ```?``` - either zero or one of the item
  * ```foo\d?``` - match "foo", possibly followed by a digit.
* ```{}``` - specify exact, minimum, or minimum and maximum occurances of the item
  * ```\w{4}``` - match a sequence of four word characters.
  * ```\w{4,}``` - match a sequence of at least four word characters.
  * ```\w{4,7}``` - match a sequence of at least four but no more than seven word characters.

#### Grouping and Alternatives
* ```|``` - match one of a list of pipe-separated alternatives
  * ```this|that|the other``` - match "this" or "that" or "the other"
* Parenthesis define _groups_, which allow:
  * Subexpressions: ```th(is|at|e other)```
  * Capture: ```\((d\{3})\) (\d\d\d-\d\d\d\d)``` - match a phone number of the form ```(303) 555-1234```, and remember the area code and phone number after the match.  Captured groups are numbered left-to-right (starting with 1) as you count the opening parentheses.
    * Area code will be in ```$1```
    * Phone number will be in ```$2```


### Regular Expressions in Programs
In many programming languages, a regular expression pattern is inclosed in slashes, /_pattern_/, the way a string is enclosed in quotes or a block is enclosed in braces, and automatically handled as a regex.

Javascript:
```javascript
Var myRE = /^\d{3}\D/; // Match lines starting with 3-digit number
```

Other languages including *Java* and *SQL* require you to pass the regex pattern as a String argument to a function or method.  Because backslash escape sequences already have special meanings in String literals, you need to double the backslashes of your RE metacharaters.
  
Java:
```java
Pattern p = Pattern.compile("^\\d{3}\\D");
```
