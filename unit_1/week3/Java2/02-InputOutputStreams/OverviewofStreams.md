## Overview of Streams

* All Java I/O is conducted through streams, which are ordered sequences of data.
  
  * A stream is either an input stream, an output stream, or both at the same time.

* Streams aren't just for file I/O; their uses include:
  
  * Communication across sockets.
  
  * I/O to or from a *URL* object, including a servlet.
  
  * Storing and retrieving data based on a `String`, `char[]`, or `byte[]`.
  
  * Reading and writing Large Objects in a database with JDBC.
  
  * Serialization of objects.

* Almost all of the methods in Java's I/O classes throw `java.io.IOException` (or one of its children).

<hr>

```java
package examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadIt {
  public static void main(String[] args) {
    BufferedReader bufIn = null;
    try {
      bufIn = new BufferedReader(new FileReader("input.txt"));

      String line;
      while ((line = bufIn.readLine()) != null) {
        System.out.println(line);
      }
    }
    catch (IOException e) {
      System.err.println(e);
    }
    finally {
      if (bufIn != null) {
        try {
            bufIn.close();
        }
        catch (IOException e) {
            System.err.println(e);
        }
      }
    }
  }
}
```

#### BufferedReader

The `BufferedReader` class allows us to read more efficiently from a device like the hard drive. Along with buffering input, it also provides the ability to read one line at a time. Without a `BufferedReader`, we would have to read a `byte` at a time, or read a set of `byte`s and convert them to a `String` manually.


[Prev](README.md) | [Up](../README.md) | [Next](BytesvsCharacters.md)

