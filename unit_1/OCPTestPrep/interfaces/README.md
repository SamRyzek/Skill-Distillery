## Interfaces
* An interface defines methods which an implementing _concrete_ class must create.
* Use the keyword `implements` to make a class use an interface (or interfaces).
* Classes can implement multiple interfaces using a comma-separated list.
* Use `extends` to make an interface extend another interface.
* Interfaces can extend multiple interfaces using a comma-separated list.

In a class definition, `extends` comes before `implements`.

It creates an "IS-A" relationship, meaning a class that implements an interface IS-A instance of that interface. Same for interfaces that extend other interfaces.

### Top-Level Rules

Class Modifier - `public` or (default). `private` and `protected` generate a compiler error.

```
public (or default) abstract (assumed) interface Name {
	public static final int MAX_DEPTH = 5; //final, must be assigned
	int MAX_HEIGHT = 10; //public static final assumed
	public abstract int getDepth();
	int getHeight(); //public abstract assumed
}
```

(see Interface1.java)

Interfaces _cannot_ be marked `static` or `final`.

### Fields
Fields assumed `public static final`
* Must be assigned when declared; no static blocks.
* Are inherited by implementing classes or extending interfaces.

```
Mock Exam 1 - #35

//Consider the following class and interface definitions (in separate files):

public class Sample implements IInt{
	public static void main(String[] args){
		Sample s = new Sample();  //1
		int j = s.thevalue;       //2
		int k = IInt.thevalue;    //3
		int l = thevalue;         //4    
	}
}

public interface IInt{
	int thevalue = 0;
}

//What will happen when the above code is compiled and run?
```
* Watch for attempts at reassignment.

```
//Mock Exam 1 - #18
interface Bozo {
	int type = 0;

	public void jump();
}

public class Type1Bozo implements Bozo {
	public Type1Bozo() {
		type = 1;
	}

	public void jump() {
		System.out.println("jumping..." + type);
	}

	public static void main(String[] args) {
		Bozo b = new Type1Bozo();
		b.jump();
	}
}
```
*	Fields can be shadowed by implementing or extending, but can't be referred to if there is a collision.

(see CollisionTest.java)

### Method Visibility/Access
* Methods marked final? - NO, must be implemented.
*	`protected` or `private` methods? - NO, all `public`
* No such thing as (default) access because assumed `public` when not included

### Implementing Interfaces
* Use the `implements` keyword to implement an interface.
* All abstract methods must be implemented _or_ the class must be marked `abstract`.
* A class can fulfill two interfaces simultaneously

```
interface Tester {
	int doIt();
}

interface Tester2 {
	int doIt();
}

class Implementer implements Tester, Tester2 {
	public int doIt(){
		return -1;
	}
}
```
What about interfaces with similar methods?
```
interface Tester1 {
	int doIt();
}

interface Tester2 {
	double doIt();
}

class TesterImplementer implements Tester1, Tester2 {

}
```
(see Tester1.java)

What if we take out the offending method from class? Then all of interface is not implemented.

Make it abstract and not implement anything? NO.

### Casting to Interface type
* Casting a class reference to an interface means only the interface's methods will be available.
* A non-final class can be cast to _any_ interface.

(see CastingTest.java)

### Default methods
```
public (assumed) default void doThings() {
	//need method body
}
```

* Only declared in an interface
* Must be marked with `default` _and_ provide a body
* Not `static`, `final`, `abstract`
* Not `private` or `protected`

Extending interface or abstract class may redeclare default method abstract, forcing classes to implement.

(see TestDefaultInterfaces.java)

#### Multiple Inheritance
Subclass implementing two interfaces with same default method must override default method. _Not first concrete class_ like other interface rules.
* Could redeclare method as abstract, meaning implementing class must be marked abstract.

(see TestDefaultInterfaces - TestInterfaceDefaultCollisions)

### Static methods
* Interfaces can have `static` methods. They must have a body.
* Not `private` or `protected`.
* Static interface methods are _not_ inherited by the classes implementing the interface (unlike static fields). Therefore, overriding does not happen (so no polymorphism).

* Only difference between interface and class static methods is that you need a reference to the name of the interface if you use it outside the interface.

(see data.DataCheck.java)

* Implementing interfaces with two static methods of the same signature is okay.

(see StaticImplementer.java)
