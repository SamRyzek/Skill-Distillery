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
