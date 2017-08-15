## Labs

1: Create a program that opens a Java file, reads the lines in one at a time, and determines if the line contains only inline comments or is a blank line. Print all the lines that contain any real Java code.  
(Hint: Use `BufferedReader` and `FileReader`:)

```java
BufferedReader in = new BufferedReader(new FileReader(args[0]));
```

2: Generalize `ReadFile.java` so that it searches for any pattern (`arg[0]`) in any file (`arg[1]`). This is a slightly simplified version of the UNIX grep utility. 

3: *pet.txt* is a flat file database consisting of pet data. The fields are delimited by a pipe (`|`), and the records are all on separate lines. Open the file, read the lines, and use the `split()` method to find the data. Then print out the information in a readable format. The first line of the file contains the field headings, so don't print that out! (Hint: You'll need to use a character class in your regular expression or escape the RE.)  

<hr>

[Prev](PatternMatchingandRegularExpressions.md) | [Up](../README.md)

