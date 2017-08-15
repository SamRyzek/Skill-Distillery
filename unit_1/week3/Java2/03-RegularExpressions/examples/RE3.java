package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE3 {
    public static void main(String[] args) {
        String s = "This is a test.";
        Pattern p = Pattern.compile("\\bis\\b");
        Matcher m = p.matcher(s);

        boolean result = m.find();

        if (result) {
            System.out.println("Found \"\\bis\\b\" at index "
                    + m.start() + " for string \"" + s + "\"");
        }
        else {
            System.out.println("No match.");
        }
    }
}
