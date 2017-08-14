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
