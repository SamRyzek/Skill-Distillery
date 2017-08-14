## Bytes vs. Characters

* We can characterize any Java I/O stream as either a byte stream or a character stream.

* Byte streams always deal with data as streams of 8-bit bytes.

  * Byte streams are referred to in Java as streams, with class names like `InputStream` and `OutputStream`.

  * Any time binary, non-textual data is being manipulated, you will use a stream.

  * An int written with an output stream is written as 4 bytes, not as readable text.

* Character streams use 16-bit Unicode characters.

  * Character streams are referred to in Java as readers and writers, with class names like `FileReader` and `FileWriter`.

  * Any time textual data is being manipulated, you will use a reader or writer.

  * An int written with a writer is written as a sequence of characters; this is a readable format.

* For every input stream there is usually a corresponding reader class; for every output stream there is usually a corresponding writer class.

<hr>

```java
package examples;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Animal {
    private String species;
    private String name;
    private boolean friendly;
    private int weight;

    public Animal(String s, String n, boolean f, int w) {
        species = s;
        name = n;
        friendly = f;
        weight = w;
    }

    public void writeBinary(OutputStream out) throws IOException {
        DataOutputStream dataOut = new DataOutputStream(out);
        dataOut.writeChars(species);
        dataOut.writeChars(name);
        dataOut.writeBoolean(friendly);
        dataOut.writeInt(weight);
    }

    public void writeText(Writer out) {
        PrintWriter printOut = new PrintWriter(out);
        printOut.println(species);
        printOut.println(name);
        printOut.println(friendly);
        printOut.println(weight);
    }

    public static void main(String[] args) {
        Animal scrappy = new Animal("canine", "Scrappy", true, 112);
        Animal hobbes = new Animal("tiger", "Hobbes", true, 425);
        Animal scar = new Animal("lion", "Scar", false, 600);
        try {
            FileOutputStream dat = new FileOutputStream("Animal.dat");
            scrappy.writeBinary(dat);
            hobbes.writeBinary(dat);
            scar.writeBinary(dat);
            dat.close();

            FileWriter txt = new FileWriter("Animal.txt");
            scrappy.writeText(txt);
            hobbes.writeText(txt);
            scar.writeText(txt);
            txt.close();
            System.out.println("New files written to file system");
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

```

[Prev](OverviewofStreams.md) | [Up](../README.md) | [Next](FileObject.md)

