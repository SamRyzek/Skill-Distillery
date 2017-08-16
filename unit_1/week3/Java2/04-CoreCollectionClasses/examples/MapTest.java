package examples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//import java.util.LinkedHashMap;

public class MapTest {
    public static void main(String args[]) {
        CD cd1 = new CD(1, "The Beatles", "The Beatles 1");
        CD cd2 = new CD(2, "Prince", "The Very Best of Prince");
        CD cd3 = new CD(3, "Garth Brooks", "The Ultimate Hits");

        Map<String, CD> cdCollection = new HashMap<>();
        // Map<String,CD> cdCollection = new LinkedHashMap<>();

        cdCollection.put("B00004ZAV3", cd1);
        cdCollection.put("B00005M989", cd2);
        cdCollection.put("B000UVT3OI", cd3);

        Set<String> s = cdCollection.keySet();
        Iterator<String> it = s.iterator();

        while (it.hasNext()) {
            String key = it.next();
            System.out.print("Key: " + key);
            System.out.println(" Value: " + cdCollection.get(key));
        }
    }
}