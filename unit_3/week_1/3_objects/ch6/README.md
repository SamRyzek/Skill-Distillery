# `this` in JavaScript Objects
* JavaScript does not have analogous classes to Object Oriented languages.

* JavaScript has *objects* and *functions*. (technically a function is just a special type of object)

* When a function is invoked, `this` is assigned a value. The value it is assigned can vary based on how the function was invoked.

* When dealing with object methods, `this` will be bound to the object which the method is a property of (i.e. *the invoking object*):

```javascript
var dog = {};
dog.name = "Sparky";

// 'dog' is the invoking object, 'this' references 'dog'
dog.sayName = function() {
  return this.name;
}

dog.sayName(); // 'Sparky'
```

* It is important to note that `this` will only be bound to the invoking object if a function is called. Thus, attempting to assign a value to another property in an object literal with `this` will produce `undefined` (or a radically unexpected result). For example:

```javascript
var dog = {
  fname : 'Sparky',
  lname : 'Le Grange',
  fullName : this.fname + " " + this.lname
};

dog.fullName; // undefined undefined
```
  
* In the above example, `this` is actually referencing the global object (in this case `window`), the reason it is `undefined` is because `window` does not have `fname` or `lname` properties. 
  
* Given that the identity of `this` can be confusing, some style guides choose to reassign the value of `this` to a variable name inside of functions for clarity:
  
```js
var dog = {
  fname = 'Sparky',
  lname = 'Le Grange',
  // Method, when invoked will assign `this` as invoking object
  getFullName = function() {
    var thisDog = this;
    return thisDog.fname + " " + thisDog.lname;
  }
}

dog.getFullName(); // Sparky Le Grange
```
  
* When paired with a JavaScript *closure*, JavaScript objects can be used as a good way of encapsulating data. Consider this example, which creates and returns an object representing a person:
  
```js
// You have been using the 'revealing module pattern' as below:
var personFactory = function(fname,lname,email){
  var getFirstName = function() {
    return fname;
  }
  var getLastName = function() {
    return lname;
  }
  var getEmail = function() {
    return email;
  }

  return {
    getFirstName : getFirstName,
    getLastName : getLastName,
    getEmail : getEmail
  }
};

// Alternatively, you could write it like below, simplifying the return:
var personFactory = function(fname,lname,email){
  var person = {};
  person.getFirstName = function() {
    return fname;
  }
  person.getLastName = function() {
    return lname;
  }
  person.getEmail = function() {
    return email;
  }

  return person;
};
```
  
#### Hands On
* Create a variable named `tree`.  
  
* Give `tree` an `age` property, and set it equal to some number.  
  
* Create a method on `tree` named `ageOneYear`, which uses `this` to update the age property on `tree`. Call `ageOneYear` and check the `age` property.  
  
* Create another method on `tree` named `isDead`. `isDead` should set the `age` property to `NaN` if the tree is older than 100. Call `isDead` within `ageOneYear`. Use `this`.  
  
* In a `while` loop, until the tree's age is `NaN`, call `ageOneYear` and print the age to console.
  
##### [Prev](../ch5/README.md) | [Next](objectsAndMethods)


