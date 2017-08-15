package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE6 {
    public static void main(String args[]) {
        String s = "These     are     spaces";

        // grab 1 or more word chars, 1 or more space chars...
        Pattern p = Pattern.compile("(\\w+)(\\s+)(\\w+)");
        Matcher m = p.matcher(s);

        String newString = m.replaceFirst("$3$2$1");

        System.out.println("Group 1: " + m.group(1) + "\nGroup 2: "
                + m.group(2) + "\nGroup 3:" + m.group(3));

        System.out.println("String \"" + s + "\"\nis now: \n\""
                + newString + "\"\n");

        p = Pattern.compile("^((\\w+)(\\s+)(\\w+))$");
        m = p.matcher("Agent 007");

        m.find();
        for (int i = 1; i <= m.groupCount(); i++) {
            System.out.println("Group " + i + ": " + m.group(i));
        }
    }
}
