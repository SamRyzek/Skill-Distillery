## Polymorphism

* Means in many forms  

```java
Animal a = new Animal();
Animal b = new Bird();
```

|   | Variable Type | Object Type|
|---|:-------------:|:----------:|
| a | Animal        | Animal     |
| b | Animal        | Bird       |

* Polymorphism (method overriding) cares about the object type.

* Only 'virtual' methods can be overridden:  
  * non-final  
  * non-static  
  * non-private methods are virtual.  

```java
a.speak();
b.speak();
```

*  Variable shadowing cares about the variable type

```java
System.out.println(a.name);
System.out.println(b.name);
```

* Variables bind at compile time, methods bind at runtime   
* Compiler cares about the variable type, too. To get around this, use casting.

```java
b.fly();          // compiler will not allow this
((Bird)b).fly();
((Bird)a).fly();  //Class cast exception!
```
