package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: java JGrep pattern filename");
            System.exit(-1);
        }

        Pattern p = Pattern.compile(args[0]); // Compile the RE
        Matcher m = p.matcher(""); // Create matcher object

        try (BufferedReader in = new BufferedReader(new FileReader(
                args[1]));) {

            String s;
            while ((s = in.readLine()) != null) {
                m.reset(s); // Load a new string into the matcher
                if (m.find() == true) {
                    System.out.println(s);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
