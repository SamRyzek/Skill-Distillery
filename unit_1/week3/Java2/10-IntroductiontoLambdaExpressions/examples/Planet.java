package examples;

public class Planet {
    private String name;
    private long orbit;
    private int diameter;

    public Planet(String name, long orbit, int diameter) {
        this.name = name;
        this.orbit = orbit;
        this.diameter = diameter;
    }

    public String getName() {
        return name;
    }

    public long getOrbit() {
        return orbit;
    }

    public int getDiameter() {
        return diameter;
    }

    @Override
    public String toString() {
        return name;
    }
}
