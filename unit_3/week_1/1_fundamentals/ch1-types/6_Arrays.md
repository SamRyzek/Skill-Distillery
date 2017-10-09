# Arrays
* Arrays are list like objects capable of traversal and mutation operations.

* JavaScript arrays are mutable. Neither the length of the array, nor the types of its contents are fixed.

* Array literals are comma separated collections contained within brackets:  

```javascript
var array = [];

var numArray = [1,2,3,4];

var wordArray = ['hello', 'world'];

var miscArray = [1, 'hello', true];
```

* Javascript arrays can contain undefined values if no data is assigned to an index:

```javascript
var arr = [,,];

arr[0] // undefined
arr[1] // undefined
arr[2] // undefined

var someData = [,3,];

someData[0] // undefined
someData[1] // 3
someData[2] // undefined
```

* While you can use the `new` keyword to create a new array, this can have unexpected behavior and is usually avoided in preference of declaring array literals.  

### Creating Arrays
* Array's can be created using the Array object constructor in multiple ways.

1: Call the constructor with no arguments:  

```javascript
var arr = new Array(); // []
```

2: Call the constructor with a single numeric argument (specifying the length of the array of undefined values):  

```javascript
var arr = new Array(10); // [ , , , , , , , , , ]
```

3: Call the constructor with two or more arguments, or a single (non-numeric) value:  

```javascript
var arr = new Array('hello', 10, true); // [ 'hello', 10, true ]

var word = new Array('banana'); // [ 'banana' ]

var bool = new Array(false); // [ false ]

var numericString = new Array('10'); // [ '10' ]
```

* The reason the array constructor is typically avoided is the result of these last two. It is very easy to think that you are creating an array with an initial value of some number (i.e. `new Array(5)`), and instead create a multi-element array of some length filled with `undefined` values.

```javascript
var numArray = [9]; // [ 9 ]

var undefinedArray = new Array(9); // [ , , , , , , , ,  ]

```

* Array elements can be read and written by accessing an element with *subscript notation*:

```javascript
//  Read
var arr = [ 'one', 'two', 'four' ];
arr[0]; // 'one'

// Write
arr[2] = 'three';
arr; // [ 'one', 'two', 'three' ]
```

### Hands On
1. Create an array literal with three strings.
  * Use *subscript notation* to access each of the strings and concatenate them.

2. Create an array literal with three numbers.
  * Use *subscript notation* to access each of the numbers and multiply them.

3. Use the '+' operator to add your array of strings to your array of numbers, what is the result?

4. Access an index which is out of range (i.e. Array[54]), what happens? Is there an error?


##### [Prev](5_Null_Undefined.md) | [Next](Appendix_A.md)
