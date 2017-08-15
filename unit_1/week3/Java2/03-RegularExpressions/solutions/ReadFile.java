package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java ReadFile filename");
            System.exit(-1);
        }

        // declare the string and matcher.
        String s;
        Matcher m;
        Matcher m2;

        // Prepare the Pattern objects
        // First one finds comments, second one finds blank lines.
        Pattern p = Pattern.compile("^\\s*//");
        Pattern p2 = Pattern.compile("^\\s*$");

        // Reads lines from a file.
        try (BufferedReader in = new BufferedReader(new FileReader(
                args[1]));) {

            while ((s = in.readLine()) != null) {
                m = p.matcher(s);
                m2 = p2.matcher(s);
                if (!m.find() && !m2.find()) {
                    System.out.println(s);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
