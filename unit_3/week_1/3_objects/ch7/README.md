# Revealing Modules

* This lab will illustrate the usefulness of JavaScript *Closures* in providing encapsulation.

* As you know, JavaScript does not have any equivalent access modifiers (public, private, etc) to Java.

* In order to encapsulate data and control access to an object's properties through methods, we have to use a *Closure* and only expose methods we deem necessary.

* There is a common JavaScript design pattern known as the 'Revealing Module Pattern' which can be utilized for this task.

### Creating a *Closure*

* A *Closure* is the *state* of scope created by a function when it is invoked.

* At runtime, the values within the scope of a function are preserved (saved in memory) and can be referenced by a returned object. This is not limited to the properties of the object itself, but also local variables within the scope of the function.

* Example:

```js
var Person = function(n) {
  var obj = {};

  obj.getName = function() {
    return n;
  }

  return obj;
};

var steve = Person('Steve');

steve.getName(); // 'Steve'
steve.n; // undefined
```

* In this way you can accomplish two things:

  1. The modularization of code into logical components with a separation of concerns (not dissimilar to Java classes)

  2. Encapsulate data and create something akin to a `private` access modifier

* The only accessible methods/variables from a module are those that you expose in the returned object.

### Using IIFEs to create Closures
* The above strategy is useful in that the 'Person' module becomes reuseable...

```js
var Person = function(n) {
  var obj = {};

  obj.getName = function() {
    return n;
  }

  return obj;
};

var steve = Person('Steve');
var kris = Person('Kris');
var andrew = Person('Andrew');
var rob = Person('Rob');
```

* However, you do not always need to create reusable objects, sometimes you simply need to create a closure to decrease the number of variables in the global scope (remember anything outside of a function is in the global scope).

* To create a modularized closure you can use an *Immediately Invoked Function Expression (IIFE)*.

```js
var applicationRunner = (function(){
  // code
})()
```

  * the parentheses surrounding the function (`(function(){})`) force the JS interpreter to evaluate the function immediately

  * the parentheses following the function (`(function(){})()`) invoke it (just like you would if you were calling it by name);

  * You can pass arguments to the function in the same way as you would another function:

```js
var bandBuilder = (function(bandMembers){
  // code
})(['David Bowie', 'Slash', 'Missy Elliott']);
```

* This will allow you to create modules with private worker methods, exposing a simple API publicly:

```js
var applicationRunner = (function(){
  var module = {};

  var displayMenu = function() {
    console.log("1: List Fleet");
    console.log("2: Show Fastest Jet");
    console.log("3: Display Furthest Flying Jet");
  };

  var configureInput = function(email, password) {
    console.log("configuring connection...");
    console.log("herding llamas...");
    console.log("submitting credentials email:*****, password:*****");
  };

  var adminPassword = '123CAT';

  var adminEmail = 'admin@admin.com';

  module.run = function() {
    configureInput(adminEmail, adminPassword);
    displayMenu();
  };

  return module;
})()

// run the application
applicationRunner.run();

applicationRunner.adminPassword // undefined
```

##### [Prev](../ch6/README.md) | [Next](../exercises/gameLogic)
