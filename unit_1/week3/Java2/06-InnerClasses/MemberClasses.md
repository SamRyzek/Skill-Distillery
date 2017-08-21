## Member Classes

* A class defined within an enclosing class, but without the static keyword, is a _member class_.

  * It is defined at the same level as other fields and methods that are members of the class.

* Every instance of the member class has an internal reference to the enclosing object.

  * A method in the member class can use its own data and the data in the enclosing instance (including private fields), implicitly, without any special syntax.

* Member class methods can explicitly refer to the enclosing instance's fields using the enclosing class name along with this.

```java
int i = Outer.this.outerField;
```

  * This syntax is only necessary for explicit access to shadowed fields or methods.

* You must specify an enclosing instance when creating a member instance from another class.

```java
Outer out = new Outer();
Outer.Inner in = out.new Inner();
```

* A member class may be declared as private, for use within its enclosing class, or as protected, public, or default, depending on how it will be used.

<hr>

Outer.java

```java
...
// Member Inner Class
public class Outer {
  private int outerField;

  public void aMethod() {
    Inner in = new Inner();
    System.out.println(in);
  }

  class Inner {
    private int innerField;
    public String toString() {
      // explicit access to outerField
      //return "o: " + Outer.this.outerField + " i: "+ innerField;
      // implicit access to outerField
      return "o: " + outerField + " i: " + innerField;
    }
  }

  public static void main(String[] args) {
    Outer out = new Outer();
    out.aMethod();
  }
}
```

TestInner.java

```java
...
// Use a Member Inner Class
public class TestInner {
  public static void main(String[] args) {
    Outer out = new Outer();
    Outer.Inner in = out.new Inner();
    System.out.println(in);
  }
}
```

[Prev](InnerClasses.md) | [Up](../README.md) | [Next](LocalClasses.md)

