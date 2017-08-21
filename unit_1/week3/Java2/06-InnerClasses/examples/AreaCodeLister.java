package examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AreaCodeLister {
    private Map<String, String> areaCodes;
    private Map<String, String> abbreviations;

    public AreaCodeLister() {
        populateAreaCodes();
        populateAbbreviations();
        print();
    }

    private void populateAreaCodes() {
        areaCodes = new HashMap<>();

        try (BufferedReader in = new BufferedReader(new FileReader(
                "areacodes.txt"))) {

            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                // Add code to parse out the area code and abbreviation 
                // from each line.  Then add them to the areaCodes Map.
            }
        }
        catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }

    private void populateAbbreviations() {
        abbreviations = new HashMap<>();

        try (BufferedReader in = new BufferedReader(new FileReader(
                "abbreviations.txt"))) {

            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                // Add code to parse out the state and abbreviation 
                // from each line.  Then add them to the abbreviations
                // Map.
            }
        }
        catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }

    private void print() {
        // Add code to display the area code and the full state name
        // associated with it.
    }

    public static void main(String[] args) {
        new AreaCodeLister();
    }
}
