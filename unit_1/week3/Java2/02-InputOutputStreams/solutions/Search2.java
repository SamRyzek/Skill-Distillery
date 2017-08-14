package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Search2 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java Search2 {pattern} {file}");
            System.exit(1);
        }

        String pattern = args[0];
        String filename = args[1];

        try (BufferedReader bufin = 
                new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = bufin.readLine()) != null) {
                if (line.indexOf(pattern) >= 0) {
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