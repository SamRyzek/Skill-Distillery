## Collections

* Collections are objects that hold and manipulate other objects, in a well-defined way.
  
  * You can build your own collection classes or use the ones provided for you in the `java.util` package.

* A collection class can be defined to contain data of type `Object`, and can then hold objects of any given class type, since all objects can be implicitly cast to type `Object`.

```java
package examples;

public class Pair { 
  private Object first; 
  private Object second;
}
```

  * A `Pair` can represent and hold two of anything.

  ```java
  package examples;
  
  public class PairTest {
    public static void main(String[] args) {
      Pair p1 = new Pair("ABC", "XYZ");
      Pair p2 = new Pair(new Integer(1), new Integer(2));
    }
  }
  ```

* Downcasting is necessary to retrieve the original type from the collection.

```java
package examples;

public class PairTest {
  public static void main(String[] args) {
    Pair p1 = new Pair("ABC", "XYZ");
    Pair p2 = new Pair(new Integer(1), new Integer(2));

    String st = (String)p1.getFirstElement(); 
    Integer i = (Integer)p2.getFirstElement();
  }
}
```

  * Downcasting is prone to `ClassCastException`, unless you check the datatype with the `instanceof` operator.

  ```java
  package examples;
  
  public class PairTest {
    public static void main(String[] args) {
      Pair p1 = new Pair("ABC", "XYZ");
      Pair p2 = new Pair(new Integer(1), new Integer(2));
  
      if (p1.getFirstElement() instanceof String) {
        String s = (String)p1.getFirstElement();
      }
      
      if (p2.getFirstElement() instanceof Integer) {
        Integer s = (Integer)p2.getFirstElement();
      }
    }
  }
  ```

<hr>

_Pair.java_
```java
package examples

public class Pair {
  private Object first;
  private Object second;
  public Pair(Object one, Object two) {
    first = one;
    second = two;
  }
  public Object getFirstElement() {
    return first;
  }
  public Object getSecondElement() {
    return second;
  }
  public void setFirstElement(Object obj) {
    first = obj;
  }
  public void setSecondElement(Object obj) {
    second = obj;
  }
}
```

[Prev](README.md) | [Up](../README.md) | [Next](Generics.md)

