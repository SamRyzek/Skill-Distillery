### Defining Functions
* Function declarations begin with the `function` keyword and are followed by three other components:
  1. An identifier (...or name), which becomes a variable which the newly defined function object is stored in. The identifier is required in a named function declaration, but can be excluded for anonymous functions, and function expression definitions (more on these later).
  2. A pair of parentheses (`()`). These store a comma seperated list of named function parameters.
  3. A pair of curly braces (`{}`). This is the body of the function and stores one or more JavaScript statements which will be executed when the function is invoked.
  
```javascript

// function declaration
function greet(name) {
  return 'Hello ' + name;
}

// function invocation
greet('Kris'); // 'Hello Kris'
```
  
* Declaring a named function with the `function` keyword creates a variable in the current scope. For example:
  
```js
function foo(){}
```
  
* `foo` is now a variable in the current scope. The value of the `foo` variable is `function(){}`.
  
* Alternatively, you can explicitly store a function into a variable:
  
```js
var bar;

bar = function foo(){};
```
  
* The variable `bar` now contains the function `function(){}` as a value.
  
##### [ToC](README.md) | [Next](2_parameters.md)
