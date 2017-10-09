# Object Methods
* **Any** value may be assigned to an object property, including a *function*.

* Object methods can be created by assigning a function to a property when an object literal is created:

```javascript
var dog = {
  speak : function() {
    return "woof woof";
  }
}
```

* Methods can be assigned with dot notation:

```javascript
var dog = {};

dog.speak = function() {
  return "woof woof";
}
```

* Subscript notation can also be used:

```javascript
var dog = {};

dog['speak'] = function() {
  return "woof woof";
}
```

### Hands On
* JS Object methods are similar to Java instance methods. Just as you would create a new instance of a class in Java and invoke one if its methods, you can do the same with JS objects. The core difference is that unlike Java, you are not required to create a class definition to create an instance of an object. What's more, you can assign functions to the object and store them in properties dynamically.

```js
var myObj = {};
myObj.makeArray = function(...args) {
  return args;
}

console.log(myObj.makeArray(1,5,2,34,1,67));
```

* Create a new object `var myMath` which has methods like `add(num1,num2)`, `subtract(num1,num2)`, `multiply(num1,num2)` and `divide(num1,num2)`, which return the computed value of each operation.

##### [Prev](../ch4/README.md) | [Next](../ch6/README.md)
