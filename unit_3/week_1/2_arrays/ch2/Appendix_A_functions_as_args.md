# Appendix A : Functions as Arguments

***Consider this code block***:

```js
var nums = [1,2,3,4,5];

function printSquare(number, index, array) {
  console.log(number * number);
};

nums.forEach = function() {
  for (var i = 0 ; i < this.length ; i++) {
    printSquare(this[i], i , this);
  }
};

nums.forEach();

```

* The above function (`nums.forEach`) will use the function `printSquare` to print out the squared value of the current value being iterated over in the array.

* This `forEach` method is not very useful as it is bound to use one specific function implementation (`printSquare`).

### Dynamically Altering Behavior by Providing Functions as Arguments

* In the following example, instead of always using the same function, we will use a function provided when the `forEach` method is invoked. This will make our method much more dynamic and allow the end user to specify how it be implemented.

```js
var nums = [1,2,3,4,5];

nums.forEach = function(func) {
  for (var i = 0 ; i < this.length ; i++) {
    func(this[i], i , this);
  }
};

function printSquare (number, index, array) {
  console.log(number * number);
}

function printSum (number, index, array) {
  console.log(number + number);
}

function isEven (number, index, array) {
  console.log(number % 2 === 0);
}

nums.forEach(printSquare);
nums.forEach(printSum);
nums.forEach(isEven);
```


#### Continue to [`shift`, `unshift`](2_ShiftUnshift.md)
