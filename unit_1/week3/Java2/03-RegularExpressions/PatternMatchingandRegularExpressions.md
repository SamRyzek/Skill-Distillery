## Pattern Matching and Regular Expressions

* Pattern matching is a method of determining if a specified text pattern occurs in a string.

* A *Regular Expression* (RE) is a specification of a text pattern.

* An RE is used to search for occurrences of the pattern in strings.

* Example (the following are all characters, not numbers):

  * Regular expression: `"ERROR"`

  * A string: `"Operation 235: SUCCESS"`

  * Another string: `"Operation 236: ERROR"`

> Question: Does the pattern ERROR occur in the first string? 
> Question: Does the pattern ERROR occur in the second string?

* A common use of REs is to identify all lines in a text file that contain a certain pattern, then have your program perform an operation on those lines.

  * Extract all lines in a file that have the area code `303`.

  * Display all lines in a file that contain the pattern `ERROR`.

  * Check to see if a file has any blank lines in it.

  * In a file, change all area codes from the format `(nnn)` to `nnn-`.

  * In a memo, change all occurrences of `Mrs` or `Miss` to `Ms`.

* The strings, or lines of text, that are searched by REs may come from files, HTML forms, sockets, database queries, the command line, etc.

* REs themselves are strings of text.

<hr>

[Prev](README.md) | [Up](../README.md) | [Next](RegularExpressionsinJava.md)

