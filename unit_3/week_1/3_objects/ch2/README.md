# Creating JS Objects
* JavaScript has a similar object constructor to Object Oriented languages, as such, you can create a new instance of a JS object with the `new` keyword:

```javascript
var obj = new Object();
```

* JavaScript object programming commonly simplifies object creation by using the *object literal syntax*:

```javascript
var literalObj = {};
```

### Hands On
* JS Objects are composed of *key-value* pairs, similar to a Java `HashMap`.

* A newly created instance of `HashMap` does not have any keys or values, it is an empty collection. This is roughly equivalent to a newly defined JavaScript object literal (`{}`).

```java
public static void main(String[] args) {
  Map<String, String> dog = new HashMap<>();
}
```

```js
var dog = {};
```

* Create a new object in a variable named `person`.  

* Create an array in a variable named `people`, `push()` your person object into people.


##### [Prev](../ch1/README.md) | [Next](../ch3/README.md)
