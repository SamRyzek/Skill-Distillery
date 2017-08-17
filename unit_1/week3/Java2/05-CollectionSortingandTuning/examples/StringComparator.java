package examples;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {
    public int compare(String a, String b) {
        return a.toUpperCase().compareTo(b.toUpperCase());
    }
}