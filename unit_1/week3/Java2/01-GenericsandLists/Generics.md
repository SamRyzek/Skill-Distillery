## Generics

* Java introduced *generics* (also called *parameterized types*) to simplify a developer's code when using collections. 

  * The collection object is passed the datatype of the objects it will store when it is instantiated.

  ```java
  package examples;
  
  public class GenericPairTester {
    public static void main(String[] args) {
      GenericPair<String> pres = new GenericPair<>("George", "Washington");
  
      String first = pres.getFirstElement();
      String last = pres.getSecondElement();
  
      System.out.println(first);
      System.out.println(last);
    }
  }
  ```

  * Using generics, you no longer have to downcast when retrieving elements from a collection.

    * The compiler checks the datatype that you will retrieve, so there is no danger of a `ClassCastException`.

* When declaring a class that will store generics, add a simple identifier within angle brackets to the class declaration.

```java
package examples;

public class GenericPair<T> {
  private T first;
  private T second;

  public GenericPair(T one, T two) {
    first = one;
    second = two;
  }

  // getters and setters
}
```

  * Use the same identifier for the datatypes of fields and parameters that are of the passed-in type.

  ```java
  public T getFirstElement() {}
  ```

  * The identifier is replaced throughout the code with the actual datatype that is specified when the object is used.

  ```java
  GenericPair<String> p1 = new GenericPair<>("A", "B");
  ```

<hr>

[Prev](Collections.md) | [Up](../README.md) | [Next](TheListInterface.md)

