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
