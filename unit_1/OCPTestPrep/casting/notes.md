## CASTING

* If a class shares an IS­A relationship with another class or interface, their variables can be cast to each other’s type
* Casts execute from right to left
* The compiler will prevent you from casting to a datatype that is not in your
inheritance hierarchy.  

```java
Animal a = new Animal();
String s = (String)a;  // Compiler error
```

* The compiler will allow you to cast a non-final class to any interface type
```java
Animal a = new Animal();
Comparable c = (Comparable) a;

String s = "Not Runnable";
Runnable r = (Runnable) s; // Compiler error - String is a final class.
```

* You will get a ClassCastException if the object does not implement the interface
that you cast it to.


* You can always store a subclass into a variable of type superclass - casting is allowed, but not necessary.
```java
Bird b = new Bird();
Animal a = b;  // it is ok to cast: Animal a = (Animal) b;
```

* The opposite is not true:
```java
Animal a = new Animal();
Bird b = (Bird)a;  // Runtime ClassCastException
```

* Once you cast an object up on the hierarchy, you must cast it back down before
you store it to a variable whose type is lower in the hierarchy.

```java
Bird b = new Bird();
Animal a = (Animal) b;
b = a;  // Compiler error
b = (Bird) a; // OK
```
