## Instance Initializers

* You would typically initialize data members of a class with a constructor.

  * An anonymous class cannot provide constructors, since it has no class name.

* Instance initializers allow an anonymous object to be properly initialized.

  * Any class can contain an instance initializer, though they are typically only used for anonymous classes.

* A stand-alone code block inside a class definition is an instance initializer.

  * Multiple instance initializers are allowed; they are run from top to bottom.

  * They run after the superclass constructor, and before the current class' constructor (if it isn't anonymous).

* The initialization of a data member can be performed immediately after the declaration of the variable.

  * This is helpful if a simple assignment won't accomplish the task.

<hr>

Outer4.java

```java
package examples;

// Anonymous Inner Class with instance initializer
public class Outer4 {
  private int outerField;

  public void aMethod() {
    final int localVar = 0;
    Object in = new Object() {
      private int innerField;
      // instance initializer
      {
        innerField = 12;
      }
      public String toString() {
        return "o: " + outerField + " i: " + innerField + " l: " + localVar;
      }
    };
    System.out.println(in);
  }

  public static void main(String[] args) {
    Outer4 out = new Outer4();
    out.aMethod();
  }

}
```

[Prev](InnerClasses.md) | [Up](../README.md) | [Next](Labs.md)

