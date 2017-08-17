package solutions;

import java.util.Comparator;
import java.util.Map;

public class AccessLogComparator implements Comparator<String> {
    private Map<String, Integer> visitors;

    public AccessLogComparator(Map<String, Integer> v) {
        visitors = v;
    }

    public int compare(String key1, String key2) {
        Integer firstVal = visitors.get(key1);
        Integer secondVal = visitors.get(key2);

        int retval = secondVal.compareTo(firstVal);

        if (retval != 0) {
            // sort by number of hits
            return retval;
        }
        else {
            // if hits are equal, sort by address
            return key1.compareTo(key2);
        }

        // shorthand syntax
        // return (retval != 0)?retval:key1.compareTo(key2);
    }
}
