## Reading and Writing Objects

* You can read and write an object to a stream using the `ObjectInputStream` and `ObjectOutputStream` classes.

  * These classes contain `readObject()` and `writeObject()` methods, respectively.

    * The object is written in a binary format and is called a serialized object.

    * The `readObject()` method throws `ClassNotFoundException` if it cannot find the class definition (.class file) for the serialized object.

  * Any object that you send to the `readObject()` or `writeObject()` method needs to implement the `Serializable` interface.

  ```java
  public class Book implements Serializable {}
  ```

    * There are no methods defined in this interface — you simply say implements `Serializable` and you're done!

  * These classes contain additional methods that are used for customizing the serialization process.

* Objects can be saved in files, written to a database, or sent across a socket or pipe — all using the `ObjectInputStream` and `ObjectOutputStream` classes.

<hr>

```java
package examples;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private int yearPublished;
    private int numPages;

    public Book(String t, String a, int y, int n) {
        title = t;
        author = a;
        yearPublished = y;
        numPages = n;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + ", published "
                + yearPublished + ", " + numPages + " pages.";
    }
}
```

```java
package examples;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteBook {
    public static void main(String[] args) {
        Book b = new Book("Animal Farm", "George Orwell", 1945, 144);
        try {
            FileOutputStream fout = new FileOutputStream("Book.ser");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(b);
            out.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
```

```java
package examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadBook {
    public static void main(String[] args) {
        Object o = null;
        try {
            FileInputStream fin = new FileInputStream("Book.ser");
            ObjectInputStream in = new ObjectInputStream(fin);
            try {
                o = in.readObject();
            }
            catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
            in.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(o);
    }
}
```

[Prev](OverviewofStreams.md) | [Up](../README.md) | [Next](ClosingStreams.md)

