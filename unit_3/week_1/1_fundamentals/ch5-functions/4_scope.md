### Variable Scope
* Variables declared outside of functions are said to be in the 'global scope'. Variables within functions are said to have 'local scope'.

```javascript
var scope = 'Global';

function checkscope() {
  var scope = 'Local';
  return scope;
}

scope; // 'Global'
checkscope(); // 'Local'
```

* If you fail to declare a variable with the `var` keyword, you could be overwriting the value of a variable in the global scope.

```javascript
var scope = 'Global';

function checkscope2() {
  scope = 'Local';
  return scope;
}

scope; // 'Global'

checkscope2(); // 'Local' --> reassigns scope variable to new value
scope; // 'Local'

```

* JavaScript's `var` does **not** have block scope like Java. Instead JavaScript uses *Function Scope*: variables are visible within the function in which they are defined.

```javascript
function example() {
  k = 1; // assign a value to some variable k (which will be declared below)
  if (k) { // 1 is truthy, so enter the conditional block
    for (var k; k < 10 ; k++) { // declare k (but don't initialize it here)
      console.log(k); // prints 1..9
    }
    console.log(k); // outside of for loop, k is still 10
  }
  console.log(k); // outside of conditional, k is still 10
}
```

* This can be confusing as it means that variables are visible even before they are declared, a behavior known as *hoisting*. This means that all variables within a function are 'hoisted' to the top of the function scope when the function is interpreted.

```js
function example2() {
  var k; // JavaScript hoists the variable declaration to the top of the function's scope
  k = 1;
  if (k) {
    for (k; k < 10 ; k++) { // this is how JS evaluates this line (because it hoisted the declaration with 'var')
      console.log(k);
    }
    console.log(k);
  }
  console.log(k);
}
```


##### [Prev](3_expressions.md) | [Next](5_labs)
