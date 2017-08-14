## File Object

* You can use a `File` object to represent the path and filename of a given file.

```java
File f = new File("./input.txt");
```

  * The file's length, full directory location, and associated information can be retrieved from the `File` object.

    * `getName()`

    * `getCanonicalPath()`

    * `length()`

  * The platform-specific path separator can also be used for more generic naming of paths.

```java
File f = new File("." + File.separator + "input.txt");
```

  * A `File` does not need to represent a file stream that is currently open.

<hr>

```java
package examples;

import java.io.File;
import java.io.IOException;

public class FileInfo {
    public static void main(String[] args) {
        File f = new File("input.txt");
        System.out.printf("The length of %s is %d bytes.%n",
                f.getName(), f.length());

        try {
            System.out.printf("%s has a full path of %s.%n",
                    f.getName(), f.getCanonicalPath());
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}

```

[Prev](OverviewofStreams.md) | [Up](../README.md) | [Next](BinaryInputandOutput.md)

