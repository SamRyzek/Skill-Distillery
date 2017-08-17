package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShowHits {
    private Map<String, Integer> visitors;

    public ShowHits() {
        visitors = new HashMap<>();
        populateMap();
        printMap();
    }

    private void populateMap() {
        String line = null;

        try (BufferedReader in = new BufferedReader(new FileReader(
                "access_log"))) {

            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(" ");
                String key = tokens[0];

                if (visitors.containsKey(key)) {
                    int oldValue = visitors.get(key);
                    visitors.put(key, ++oldValue);
                }
                else {
                    // first time for this visitor
                    visitors.put(key, 1);
                }
            }
        }
        catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }

    private void printMap() {
        for (String key : visitors.keySet()) {
            System.out.println(visitors.get(key) + "\t\t" + key);
        }
    }

    public static void main(String[] args) {
        new ShowHits();
    }
}
