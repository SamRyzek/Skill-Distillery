package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RETest {
    public static void main(String[] args) {
        Pattern p = Pattern.compile(args[1]);
        Matcher m = p.matcher(args[0]);

        // Search args[0] for pattern in args[1]
        boolean result = m.find();
        System.out.println("find() is " + result + ".");
    }
}
