package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Search {
    public static void main(String[] args) {

        try (BufferedReader bufin = 
                new BufferedReader(new FileReader("employee.txt"))) {

            String line;
            while ((line = bufin.readLine()) != null) {
                if (line.indexOf("manager") >= 0) {
                    // matched
                    System.out.println(line);
                }
            }
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}
