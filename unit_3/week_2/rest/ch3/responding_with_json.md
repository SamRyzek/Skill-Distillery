# Data Transfer with Rest Services

* What makes Web Services so effective is the transfer of data from the server to the client.

* In the paradigm of Client(Browser) / Server you will typically transfer your data in the form of JSON (Javascript Object Notation).

* JSON is directly convertible to a JavaScript object, because of this, it lends itself to use on the client side.

* Spring MVC combined with the Jackson (com.fasterxml.jackson.core) libraries allow us to directly convert a POJO (Plain Old Java Object) to a JSON representation for use on the client side. We can also go back to a POJO from JSON by using an `ObjectMapper`.

### `build.gradle` dependencies
* Add these two jars to your build.gradle:

```groovy
compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version: '2.8.5'
compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.8.5'
```

* These two 'jackson jars' provide us with the ability to convert POJOs to JSON, and JSON to POJOs.

### What is JSON?
* JSON is short for 'JavaScript Object Notation'.

* Objects created in Java are accessed using JSON on the client via the *response* object. For example say we have a class `Person` like the one seen below.

```java
Public class Person{
  private String fname;
  private String lname;
  private int age;

  // constructor
  // gets and sets
}
```

* If we were to instantiate an instance of this class in Java:

```java
Person p = new Person("Andrew", "Conlin", 25);
```

* Our person could then be represented in JSON as follows:

```json
{
  "fname": "Andrew", "lname": "Conlin", "age": 25
}
```

* Moving forward our web apps will not use Model and Views to route to specific JSP pages or to access data. We instead use XMLHTTPRequest/AJAX to asynchronously *request* resources from the server. The server will then send a *response* with the JSON representation of the data.

[Previous](README.md) | [Next](jsonBasics.md)
