## Inner Classes

* Inner classes were established in Java 1.1 as classes defined within other classes.

  * This syntax allows for quick and easy creation of classes for specific purposes.

* The class that contains the inner class is called the enclosing class or the enclosing instance (depending on the type of inner class).

* The enclosing class provides a namespace for its inner classes.

  * Two enclosing classes can each have an inner class with exactly the same name.

* Inner classes have some restrictions:

  * They cannot contain any static declarations.

  * They cannot have the same name as any containing class (unlike fields and constructors).

* There are three types of inner classes:

  * _Member_ classes.
  * _Local_ classes.
  * _Anonymous_ classes.

<hr>

The Java compiler compiles inner classes as normal classes, changing their names to ensure uniqueness and indicate scope, and usually adding some code to them to make them work as described.

The only thing that you, as a programmer, might notice are some strange .class files. Suppose that you have a .java file with a class called Outer that has an inner class called Inner. The compiler will create an Outer.class file and an Outer$Inner.class file. Don't use this name in your code at all. The compiler takes care of everything!

```java
PrintSortedPlanets.java
...
// Enclosing class:
public class PrintSortedPlanets {

  public void printPlanets() {
    Set<Planet> planets = new TreeSet<>(new PlanetComparator());
    planets.add(new Planet("Mercury", 57_910_000, 4_880));
    planets.add(new Planet("Venus", 108_200_000, 12_103));
    planets.add(new Planet("Earth", 149_600_000, 12_756));
    ...
    for (Planet planet : planets) {
      System.out.println(planet);
    }
  }

  // Inner class:
  private class PlanetComparator implements Comparator<Planet> {
    public int compare(Planet a, Planet b) {
      if (a.getDiameter() < b.getDiameter())
        return -1;
      else if (a.getDiameter() > b.getDiameter())
        return 1;
      else
        return a.getName().compareTo(b.getName());
    }
  }

  public static void main(String[] args) {
    PrintSortedPlanets p = new PrintSortedPlanets();
    p.printPlanets();
  }

}
```


[Prev](README.md) | [Up](../README.md) | [Next](MemberClasses.md)

