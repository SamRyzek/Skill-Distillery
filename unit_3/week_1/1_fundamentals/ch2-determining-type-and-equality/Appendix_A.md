# How JS Performs Type Conversion
### Review of Implicit Type Conversion in Java
* Similar to Java, JavaScript provides a set of global wrapper objects that the interpreter uses to attempt type conversion behind the scenes.
  
* Most languages have type conversion, and most of the time is an extremely beneficial language feature.
  
* For example in Java:
  
```java
public class Test {
  public static void main(String[] args) {

    int num = 8;

    System.out.println(num);

  }
}
```
  
* Above, `num` is a primitive integer type, however, `System.out.println()` needs the string representation fo this value in order to print it. As a primitive, it does not inherit from `Object` and thus, does not have a `toString()` method.
  
* Java's `Integer` wrapper class will promote the primitive `int` to an instance of `Integer` in order to call the `toString()` method on it and print it out. 
  
* The above code could be re-written for clarity as follows:
  
```java
public class Test {
  public static void main(String[] args) {

    Integer num = new Integer(8);

    System.out.println(num.toString());

  }
}
```
  
* While this code is clearer, it is also nearly double the length, and ultimately buys us nothing.
  

### Implicit Type Conversion in JavaScript
* JavaScript's interpreter uses a similar process to coerce data as Java...it simply does it in more situations. This is similar to casting a Java object to a different type, however it does not throw an error, it simply has the potential to produce an unexpected or unwanted result.
  
* For example in JavaScript:
  
* If a multiplication, division, or subtraction operation is being performed: 

  * JS will try to convert the operands into numbers using the `Number` global object:
  
```js
// Our code:
"8" * "9"; // => 72

// Interpreter tries:
Number("8") * Number("9"); // => 72

// When it's not a number:
Number("hello") * Number("9"); // => NaN
```

### Explicit Type Conversion in Java
* Alternatively, it is possible to explicitly perform type conversion in Java using static methods provided by the wrapper classes.
  
```java
public class Test {
  public static void main(String[] args) {

    String age = "29";

    int yearOfBirth = 2016 - Integer.parseInt(age);

    System.out.println(yearOfBirth);

  }
}
```

### Explicit Type Conversion in JavaScript
* JavaScript provides similar static methods, however, these also will not automatically throw an error:
  
```js
var stringAge = "29";
var numAge = Number.parseInt(stringAge); // => 29
typeof numAge; // => "number"

var greeting = "hello";
var numGreeting = Number.parseInt(greeting); // => NaN
typeof numGreeting; // => "number"
```

##### [ToC](README.md) | [Next](1_JSTypeConversions.md)
