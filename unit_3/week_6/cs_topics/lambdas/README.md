## Lambdas

### Basics
* We could write a function that tests if a Person object is an adult man as follows

```java
public boolean isAdultMale(Person p) {
  return p.getGender() == Person.Sex.MALE
     && p.getAge() >= 18
     && p.getAge() <= 25;
}
```

* That same function could be represented with lambda syntax.
  * Lambda functions are simply anonymous functions, meaning they are functions defined without a name.

```java
(Person p) -> p.getGender() == Person.Sex.MALE
  && p.getAge() >= 18
  && p.getAge() <= 25
```

* Java lambdas can take zero or more parameters which are embedded in parenthesis and separated from the body by an arrow.
  * Argument list : `(Person p)`
  * Arrow token: `->`
  * Body : `p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25`

* The body is typically a single expression whose result is the lambda's return value.

* We used anonymous functions extensively with javascript.
  * The function passed as an argument to `forEach()` is an anonymous function.

```js
array.forEach(function(item, index, array){
  console.log(item);
});
```

* Java 8 also has a forEach function that executes in the exact same manner as its javascript equivalent.

```java
array.forEach((item,index)->System.out.println(item));
```

### Comparators
* Java comparators can be used to sort data sets.  
* The `Collections.sort()` method takes two arguments, a collection and a comparator function.  
* This comparator function can be represented as a lambda instead of a declared function in your application.

```java
Collections.sort(planets, (a, b) -> {
  int result = 0;
  if (a.getOrbit() > b.getOrbit())
    result = 1;
  else if (a.getOrbit() < b.getOrbit())
    result = -1;
  return result;
});
```

### Predicates
* A predicate is a functional interface that represents a single argument, function that returns a boolean value.
* This functional method associated with a Predicate is `test()`.

```java
Predicate <Person> pred = p -> p.getGender() == Person.Sex.MALE;
```

#### Titanic Exercise
* You are being provided with a dataset of all the passengers that were on the Titanic.
* Additionally logic has been written to read in the data as a CSV, place it into objects and add them to a collection. (Remember parse presidents?).
* We are going to combine our knowledge of predicates and lambdas to sift through a data set and perform some statistical analysis.

##### Resources
[Getting Started with Lambdas](http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html)
