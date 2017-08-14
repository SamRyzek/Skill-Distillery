package examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadIt2 {
    public static void main(String[] args) {
        try (BufferedReader bufIn = 
                new BufferedReader(new FileReader("input.txt"))) {

            String line;
            while ((line = bufIn.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}
