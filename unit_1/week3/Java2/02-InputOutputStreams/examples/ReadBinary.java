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
