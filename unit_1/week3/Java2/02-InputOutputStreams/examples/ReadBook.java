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
