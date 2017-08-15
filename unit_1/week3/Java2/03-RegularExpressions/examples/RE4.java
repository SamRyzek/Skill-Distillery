package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE4 {
    public static void main(String args[]) {
        String s = "TEXT IN ALL CAPS";

        // Pattern p = Pattern.compile("all");
        Pattern p = Pattern.compile("all", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);

        boolean result = m.find();
        System.out.println("*** Case sensitive test***");
        System.out.println("\"" + p.pattern() + "\" matches \"" + s
                + "\" --> " + result);

        s = "Perhaps,this,is,a,flatfile,database";
        p = Pattern.compile(",");
        String[] words = p.split(s);

        System.out.println("*** Split test ***");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
