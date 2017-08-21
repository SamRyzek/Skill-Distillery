## Anonymous Classes

* _Anonymous classes_ are a kind of local inner classes that combine the class definition with the object instantiation.

  * They are used in expressions such as method calls or assignments.

* Additional syntax for the `new` operator was introduced to allow for anonymous classes.

```java
new Name( [arguments] ) {
  //class definition
}
```

  * If `Name` is a class name, then the anonymous class `extends` that class and can provide constructor arguments.

  * If `Name` is an interface name, then the anonymous class `implements` that interface.

* Find a consistent, readable indentation style for your anonymous classes.

* Methods of local (including anonymous) classes can only use variables:

  * Declared in the method body.

  * Declared as parameters to the method.

  * Declared as fields of the enclosing class or the inner class.

  * Declared as `final` or effectively final (not changed after initialization) in the local class' enclosing scope - the enclosing method or block.

<hr>

Outer3.java

```java
...
// Anonymous Inner Class
public class Outer3 {
  private int outerField;
  public void aMethod() {
    final int localVar = 0;
    Object in = new Object() { // Assignment statement starts here...
      private int innerField;
      public String toString() {
        return "o: " + outerField + " i: " + innerField + " l: " + localVar;
      }
    }; // <-- Note the semicolon to end the assignment statement.
    System.out.println(in);
  }
  ...
}
```

PrintSortedPlanets3.java

```java
...
public class PrintSortedPlanets3 {
  public void printPlanets() {     // v-- This open parenthesis...
  Set<Planet> planets = new TreeSet<> ( new Comparator<Planet>()
    {
      public int compare(Planet a, Planet b) {
        if (a.getDiameter() < b.getDiameter())
          return -1;
        else if (a.getDiameter() > b.getDiameter())
          return 1;
        else
          return a.getName().compareTo(b.getName());
      }
    } ) ; // ... is closed here.
    ...
  }
  ...
}
```

[Prev](InnerClasses.md) | [Up](../README.md) | [Next](InstanceInitializers.md)

