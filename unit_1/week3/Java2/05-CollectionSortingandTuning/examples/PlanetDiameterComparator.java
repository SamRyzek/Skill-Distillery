package examples;

import java.util.Comparator;

public class PlanetDiameterComparator implements Comparator<Planet> {
    public int compare(Planet a, Planet b) {
        if (a.getDiameter() < b.getDiameter())
            return -1;
        else if (a.getDiameter() > b.getDiameter())
            return 1;
        else
            return a.getName().compareTo(b.getName());
    }
}