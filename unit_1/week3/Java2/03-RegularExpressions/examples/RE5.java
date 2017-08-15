package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE5 {
  public static void main(String args[]) {
    String s = "My dog likes to eat. My dog's name is Fred.";

    Pattern p = Pattern.compile("[dD]og");
    Matcher m = p.matcher(s);

    String newString = m.replaceFirst("cat");
    System.out.println("** replaceFirst() example ***\nString \"" +
      s + "\"\n is now: \n\"" + newString + "\"");

    newString = m.replaceAll("cat");
    System.out.println("\n** replaceAll() example ***\nString \"" +
      s + "\"\n is now: \n\"" + newString + "\"");
  }
}
