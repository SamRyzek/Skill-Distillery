package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE2 {
    public static void main(String[] args) {

        String[] words = { "IT", "1265478654", "  3453453   ", "wow",
                "some spaces", "101 dalmations", "agent007", ".",
                "another example" };

        String[] regExs = { "\\d{7,}", "\\s+\\w+\\s+", "..." };

        for (String re : regExs) {
            Pattern p = Pattern.compile(re);

            for (String word : words) {
                Matcher m = p.matcher(word);
                boolean result = m.find();
                System.out.println("Pattern \"" + re + "\"  ->  \""
                        + word + "\": " + result);
            }
        }
    }
}
