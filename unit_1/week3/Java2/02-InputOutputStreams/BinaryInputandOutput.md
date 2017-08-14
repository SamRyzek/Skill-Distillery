## Binary Input and Output

* Classes such as `FileInputStream` and `FileOutputStream` are used for binary I/O, but only provide `read()` and `write()` methods that expect bytes or byte arrays.

  * This is usually too cumbersome to deal with.

* You can create a `DataInputStream` or `DataOutputStream` object to convert Java primitive datatypes into sequences of bytes.

* Create a `DataInputStream` by passing an `InputStream` to its constructor.

```java
FileInputStream finput = new FileInputStream( filename ); 
DataInputStream dinput = new DataInputStream( finput );￼
```

* `DataInputStream` and `DataOutputStream` are typically used in pairs to read and write a binary file, or send and receive binary data through a socket.

<hr>

```java
package examples;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinary {
    public static void main(String[] args) {
        try {
            FileOutputStream fout = new FileOutputStream("test.dat");
            DataOutputStream dout = new DataOutputStream(fout);

            dout.writeInt(12);
            dout.writeDouble(12.5);
            dout.writeBoolean(false);
            dout.writeChar('a');
            dout.writeUTF("A String");

            dout.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
```

```java
package examples;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadBinary {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("test.dat");
            DataInputStream din = new DataInputStream(fin);

            System.out.println(din.readInt());
            System.out.println(din.readDouble());
            System.out.println(din.readBoolean());
            System.out.println(din.readChar());
            System.out.println(din.readUTF());

            din.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
```

[Prev](OverviewofStreams.md) | [Up](../README.md) | [Next](PrintWriterClass.md)

