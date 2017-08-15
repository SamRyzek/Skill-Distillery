package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE1 {
    public static void main(String[] args) {
        String re = "303";
        String string1 = "(303) 555-1212";
        String string2 = "(720) 555-1212";

        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(string1);

        boolean result = m.find();
        System.out.println("find() is " + result + ".");

        // change the search String
        m.reset(string2);
        result = m.find();
        System.out.println("find() is " + result + ".");
    }
}
