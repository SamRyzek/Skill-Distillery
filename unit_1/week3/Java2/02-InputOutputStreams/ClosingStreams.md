## Closing Streams

* Upon opening a stream, your program may acquire resources such as file handles or sockets.

  * You must remember to close your stream to release these resources.

  ```java
  FileReader fr= new FileReader("input.txt"); 
  BufferedReader bReader = new BufferedReader(fr); 
  // ...
  bReader.close();
  ```

* Use a finally block to ensure that a stream is closed whether or not an exception has occurred.

  * Since the `close()` method itself may throw an exception, your code may end up unwieldy with a try/catch block embedded within a finally block.

* Any object that implements the `java.lang.AutoCloseable` interface can take advantage of the _try-with-resources_ syntax introduced in Java 7.

  * A stream declared within parenthesis after the try keyword will automatically be closed for you whether or not an exception occurs.

  ```java
  try (BufferedReader bufIn = new BufferedReader( 
    new FileReader("input.txt"))) { 
    // ...
  }
  ```

  * Any catch or finally blocks associated with a _try-with-resources_ statement will run after the resources are closed.

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

```java
package examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadIt2 {
    public static void main(String[] args) {
        try (BufferedReader bufIn = 
                new BufferedReader(new FileReader("input.txt"))) {

            String line;
            while ((line = bufIn.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}
```

[Prev](ReadingandWritingObjects.md) | [Up](../README.md) | [Next](Labs.md)

