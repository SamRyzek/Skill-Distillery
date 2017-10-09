/*
### Introduction / Goals
This lab will give you experience dealing with JS Array methods, 
as well as isolating scope within functions in your application.  
  
Remember, unlike Java, JavaScript is function scoped, meaning that 
anything outside of a function is in the global scope (this is super bad).  
  
Each of the following exercises will have you perform an operation 
within a function (isolating the scope of the operation), and none 
of these operations should update the value of the original 'startingArray'.

0 : 'startingArray' ...
*/

var startingArray = [
  1,2,3,4,NaN,6,7,8,9,NaN,NaN,12,13,14
];

/*
1 : Modify `ex1` ...  
  
Use `splice` and `forEach` to remove all occurences of `NaN` from the `startingArray`, 
replace each with the next number in the sequence (e.g: `[4,NaN]` would become 
`[4,5]`).  
  
Ensure that you do not modify the actual values of `startingArray`, return a new 
array. (***HINT:*** You will need to create a new array with the values of the 
one provided as an argument).

*/

var ex1 = function(arr) {
/******************* Your Solution *******************/
  var newArray = arr.slice();

  newArray.forEach(function(n, idx, ary) {
    if (isNaN(n)) {
      ary.splice(idx,1,ary[idx-1] + 1);
    }
  })
  return newArray;
/*****************************************************/
};
console.log(ex1(startingArray));
console.log(startingArray)

/*
2 : Modify `ex2` ...  
  
Use `map`, return a new array, convert all of the `NaN` values to `0`.

*/

var ex2 = function(arr) {
/******************* Your Solution *******************/
  return arr.map(function(x) {
    if (isNaN(x)) {
       return x = 0;
    }
    return x;
  });
/*****************************************************/
};
console.log(ex2(startingArray))

/*
3 : Modify `ex3` ...  
  
Use `filter`, return a new array which is a subset of the `startingArray` and 
does not contain any NaN values.
*/

var ex3 = function(arr) {
/******************* Your Solution *******************/
  return arr.filter(function(x) {
    return !isNaN(x);
  });
/*****************************************************/
};
console.log(ex3(startingArray));

/*
4 : Modify `ex4` ...  
  
Use your solution to `ex3` to return a filtered array without NaN, then `reverse` 
the order of the array, then use the `reduce` function to subtract all of the values.
*/

var ex4 = function(arr) {
/******************* Your Solution *******************/
  return ex3(arr)
    .reverse()
    .reduce(function(a,b,idx) {
      return a-b;
    });
/*****************************************************/
};
console.log(ex4(startingArray))

/*
5 : Modify `ex5` ...  
  
Use `sort` to order the `startingArray` such that the numbers are in ascending 
order, and the NaN values are the last three elements of the array. (***HINT:***
 Use an 'or' operator). Be sure not to modify the original array.
*/
var ex5 = function(arr) {
/******************* Your Solution *******************/
  var nArr = arr.slice();
  return nArr.sort(function(a,b){
    if(isNaN(a) || a > b) {
      return 1;
    }
    if (!isNaN(a) || a < b) {
      return -1;
    }
    return 0;
  });
/*****************************************************/
};
console.log(ex5(startingArray));

/*
6 : Modify `ex6` ...  
  
Use array methods to rotate the values of the array input. For example, if the 
spaces parameter was 5, the array would be rotated 5 spaces:  
  
```js
var a = [1,2,3,4,NaN,6,7,8,9,NaN,NaN,12,13,14];

ex6(a,5); // => [6,7,8,9,NaN,NaN,12,13,14,1,2,3,4,NaN];
```
*/

var ex6 = function(arr, spaces) {
/******************* Your Solution *******************/
  var nArr = arr.slice();
  var l = nArr.length;

  for (var i = 0 ; i < spaces ; i++) {
    nArr.push(nArr.shift());
  }
  return nArr;
/*****************************************************/
};
console.log(ex6(startingArray, 5));
