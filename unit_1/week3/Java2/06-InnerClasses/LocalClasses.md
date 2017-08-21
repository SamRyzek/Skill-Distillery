## Local Classes

* A class defined within a method or constructor is a _local class_.

* A local class has some interesting features:

  * It is visible only within the code block in which it is defined, just like a local variable.

  * It can only use `final` method parameters or final local variables that are within the same scope.

    * This includes _effectively final_ parameters and variables - those not declared `final` but whose values are never changed after initialization.

* A local class has access to fields and methods of the enclosing class, just like a member class does.

  * When declared in a static block, local inner classes can access only the static fields and methods of the enclosing class.

* Local classes cannot be declared `public`, `protected`, or `private`, since they are not members of a class.

* Local classes are commonly used to implement event listeners and other interfaces.

  * The use of the class can be written right after the definition of the class, making the code more readable.

<hr>

Outer2.java

```java
...
// Local Inner Class
public class Outer2 {
  private int outerField;
  public void aMethod() {
    final int localVar = 0;
    class Inner {
      private int innerField;
      public String toString() {
        return "o: " + outerField + " i: " + innerField + " l: " + localVar;
      }
    }
    Inner in = new Inner();
    System.out.println(in);
  }
  ...
}
```

PrintSortedPlanets2.java

```java
...
public class PrintSortedPlanets2 {
  public void printPlanets() {
    class PlanetComparator implements Comparator<Planet> {
      public int compare(Planet a, Planet b) {
        if (a.getDiameter() < b.getDiameter())
          return -1;
        else if (a.getDiameter() > b.getDiameter())
          return 1;
        else
          return a.getName().compareTo(b.getName());
      }
    }
    Set<Planet> planets = new TreeSet<>(new PlanetComparator());
    ...
  }
  ...
}
```

[Prev](InnerClasses.md) | [Up](../README.md) | [Next](AnonymousClasses.md)

