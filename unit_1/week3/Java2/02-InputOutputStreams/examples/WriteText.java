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
