# Function Closures
* Closures are functions that encapsulate variables in an enclosing scope. 
  
> "...these functions 'remember' the environment in which they were created" - Mozilla Developer Network
  
* We will begin with a simple example, creating a reusable counter:
  
```js
var counterFactory = function() {
  var counter = 0;
  return function() {
    return counter += 1;
  }
};

var count = counterFactory();

count(); // 1
count(); // 2
count(); // 3
count(); // 4
count(); // 5
```
  
* `counterFactory` returns a function which is then stored in `count`.
  
* As the `count` function was defined in and returned from an invoked function, it still has access to the variables and values within that function (in this case `counter`). 
  
* When `count` is invoked, it reads/writes to the value of `counter` in the originating functions scope.
  
* If `counterFactory` is used to create another function, it will create a new scope, not shared by `count`:
  
```js
var counterFactory = function() {
  var counter = 0;
  return function() {
    return counter += 1;
  }
};

var count = counterFactory();

var add = counterFactory();

count(); // 1
count(); // 2
count(); // 3
count(); // 4
count(); // 5

add(); // 1

count(); // 6
```
  
* Closures are excellent at encapsulating variables and protecting access to data. 
  
* JavaScript has no *access modifiers* analagous to Java's (`private`, `protected`, `public`), however, data can be made private with closures.
  
```js
var employeeFactory = function() {
  var name = "Grace Hopper";

  var getName = function() {
    return name;
  }

  return {
    getName : getName
  }
}

var employee = employeeFactory();
employee.getName(); // Grace Hopper
employee.name; // undefined
```
  
* Now you have something that is more familiar, only the function exposed in the returned object can be accessed.
  
* Closures allow you to encapsulate a tremendous amount of functionality into a single function scope, without polluting the global scope.
  
* You could dynamically assign the employee name when `employeeFactory` is invoked as so:
  
```js
var employeeFactory = function(name) {
  var name = name;

  var getName = function() {
    return name;
  }

  return {
    getName : getName
  }
}

var employee = employeeFactory("Alan Turing");
employee.getName(); // Alan Turing
employee.name; // undefined
```
  
* You could add in additional getters and setters, as well as a display function:
  
```js
var idFactory = function() {
  var counter = 1000;
  return function() {
    return counter += 1;
  }
};

var idGenerator = idFactory();

var employeeFactory = function(id, name) {
  var id = id;
  var name = name;

  var getName = function() {
    return name;
  }

  var setName = function(n) {
    name = n;
  }

  var display = function() {
    return "id: " + id + ", name: " + name;
  };

  return {
    getName : getName,
    setName : setName,
    display : display
  }
}

var employee1 = employeeFactory(idGenerator(),"Martin Fowler");
employee1.display();
// id: 1001, name: Martin Fowler

var employee2 = employeeFactory(idGenerator(),"Grace Hopper");
employee2.display();
// id: 1002, name: Grace Hopper

employee1.setName("Jim Jeffers");
employee1.display();
// id: 1001, name: Jim Jeffers
```  
  
### Hands On:
* Create a `movieFactory` function expression which takes three parameters, `title`, `year`, `runtime`.  
  
* Create setters, getters, and a display function.  
  
* Expose the setters, getters, and the display function in the returned object.  
  
* Create 4 movies using the factory. Call display on each of them.  
  
* Use the setters on one of the objects to change the `title`, `year` and `runtime`. Call the display function again.  
  
  
##### [Prev](7_scope.md) | [Next](9_labs)
