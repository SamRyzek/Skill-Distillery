package examples;

public class Planet implements Comparable<Planet> {
    private final String name;
    private final long orbit;
    private final int diameter;

    public Planet(String name, long orbit, int diameter) {
        super();
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
    public int compareTo(Planet other) {
        if (this.orbit < other.orbit) {
            return -1;
        }
        else if (this.orbit > other.orbit) {
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + diameter;
        result = prime * result
                + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (int) (orbit ^ (orbit >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Planet other = (Planet) obj;
        if (diameter != other.diameter)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (orbit != other.orbit)
            return false;
        return true;
    }
}
