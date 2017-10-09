### Function Expressions
* JavaScript functions can be stored as values. This is important: **JAVASCRIPT FUNCTIONS CAN BE STORED AS VALUES**. Below is an example of how this can be accomplished with a declared function:
  
```javascript
function square(num) {
  return num*num;
}

var exponential = square;

square(5); // 25
exponential(5); // 25

```
  
* A function can be referenced by name and stored within a variable. This will pass the entire function declaration as a value.
  
* **NOTE**: invoking the function will store the return value of the function in the variable...not the function itself.
  
```javascript
function sayHello() {
  return 'Hello!';
}

var greet = sayHello(); // 'Hello!'

var greetFunc = sayHello; // function sayHello() { return 'Hello!' }

greetFunc(); // 'Hello!'
```
  
* The advantage to storing a function into a variable (creating a function expression), is that it explicitly assigns the function to a variable (`var`) in the current scope. This prevents the function definition from polluting the namespace of a higher scope. In practical terms, assigning values to variables with the `var` keyword will isolate the scope of that variable to the script file you are importing in a browser, preventing collisions with variables in other dependencies.

### Assigning a function expression an Anonymous function

* Functions without names are called *Anonymous Functions*

```js
function (x,y) {
  // implementation
}
```

* On their own *Anonymous Functions* are not very useful as they cannot be invoked.

* *Anonymous Functions* can be assigned to variables, in which case they become function expressions and can be invoked by the variable name.

```js
var doMultiplyValues = function(x,y) {
  return x * y;
}

doMultiplyValues(1,2); // 2
```

  
##### [Prev](2_parameters.md) | [Next](4_scope.md)
