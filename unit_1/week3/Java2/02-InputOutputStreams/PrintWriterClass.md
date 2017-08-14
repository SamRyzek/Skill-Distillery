## PrintWriter Class

* Use a `PrintWriter` object when you need to output data as text.

  * This data may be primitive types, or objects from your own classes.

* You can construct a `PrintWriter` from either an `OutputStream` or another `Writer`.

```java
FileWriter fw = new FileWriter("test.txt"); 
PrintWriter pw = new PrintWriter(fw);￼
```

* `PrintWriter` provides several forms of `print()` and `println()` that take each of the primitive types and convert them to `String`s before printing them.

```java
pout.print( appDimensions.width);
```

  * `print()` and `println()` also have versions that take `Object`, and call `toString()` on that object.

  ```java
  System.out.println(user1); //calls user1.toString()
  ```

  * Use `PrintWriter`'s `printf()` method for formatted output.

* The `PrintStream` class has all of the same methods, but works with binary data instead of character data.

  * `System.out` and `System.err` are `PrintStream` objects.

<hr>

```java
package examples;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteText {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("test.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println(12);
            pw.printf("%1$.2f %n", 12.5);
            pw.println(false);
            pw.println('a');
            pw.println("A String");

            pw.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
```

```java
package examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadText {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("test.txt");
            BufferedReader buf = new BufferedReader(fr);

            String line;
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }

            buf.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
```

[Prev](OverviewofStreams.md) | [Up](../README.md) | [Next](ReadingandWritingObjects.md)

