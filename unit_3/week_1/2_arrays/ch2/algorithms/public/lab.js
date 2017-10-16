/*
0 : Use the following array literal to test all of your functions.
*/

var testArray = [
  8,99,76,90,1009,6520,32,102,109,392,324,203,230,
  12,23,546,234,1231,5346,4235234,1230,989,34230,
  123,242,124356,13,2,3,1,5,68,545,34,62,56
 ];

/*
1 : Write a function named 'linearSearch' ...

The function will accept two arguments:

* the first argument is the number you are searching for.

* the second argument is the array you are searching in.

Your goal is to iterate over the provided array, return the index of the sought
number if it is present, or `-1` if it is not.
*/

/***************** Your Solution *****************/
var linearSearch = function(search, arr) {
  //   try {
  //     arr.forEach(function(val, idx, array) {
  //       if (val === search) {
  //         throw idx;
  //       }
  //     })
  //   } catch (e) {
  //     return e;
  //   }
  // return -1;


  for (var i = 0; i < arr.length; i++) {
    if (arr[i] === search) {
      return i;
    }
  }
  return -1;
}
/*************************************************/
// var test = [1,2,3,45,6,7,8,2,9,90];
// console.log(linearSearch('apple', test));
// console.log(linearSearch(2, test));
/*
2 : Write a function named 'bubbleSort' ...

The function will accept one argument, an array.

In bubble sort, we start at the beginning of the array and swap the first two
elements if the first is greater than the second. Then, we go to the next pair,
and so on, continuously making sweeps of the array until it is sorted. In doing
so, the smaller items slowly 'bubble' up to the beginning of the list.
*/

/***************** Your Solution *****************/
var bubbleSort = function(arr) {
  var copy = arr.slice();
  var changesMade = false;
  do {
    changesMade = false;
    copy.forEach(function(val, idx, array) {
      if (val > array[idx + 1]) {
        var z = array[idx];
        array[idx] = array[idx + 1];
        array[idx + 1] = z;
        changesMade = true;
      }
    })
  } while (changesMade)
  return copy;
}
/*************************************************/

/*
3 : Write a function named 'binarySearch' ...

The function will accept three arguments:

* the first argument is a value to search for.

* the second argument is an array to search in.

* the third argument is a sorting function which will sort an array.

In binary search, we look for an element (x) in a sorted array by first comparing
x to the value at the midpoint of the array (y). If x is less than y, we search
the left half of the array. If x is greater than y, we search the right half. We
repeat this process, searching subsets of the original array until x is found,
or we run out of places to look.

If x is found, return the index at which it is located, otherwise, return -1.

*/
/***************** Your Solution *****************/
var binarySearch = function(search, arr, sort){
  var copy = sort(arr);
  var center = parseInt(arr.length / 2);
  var end = arr.length - 1;
  var start = 0;
  var notFound = true;
  var opCount = 0;
  while (notFound ) {
    if (copy[center] === search) {
      console.log(opCount);
      return center;
    }
    if (start === end) {
      break;
    }

    if (copy[center] > search) {
      end = center - 1;
    }

    if (copy[center] < search) {
      start = center + 1;
    }

    center = parseInt((end + start) / 2);
    opCount++;
  }
  console.log(opCount);
  return -1;
}
/*************************************************/


/*
4 : Write a function named 'slice' ...

***NOTE:*** Do not use JavaScript's *Array.slice()* method.

The function should accept two arguments:

* the first argument is the index of at which to begin

* the second argument is the array to modify

'slice' should return an array comprised of the values of the array provided as
an argument from the provided index to the end of the original array.

##### Example :
var arr = [0,1,2,3,4,5,6,7,8,9,10];
```js
slice(5, arr); // => [5,6,7,8,9,10];
```
*/

/***************** Your Solution *****************/
/*************************************************/

/*
5 : Write a function named 'includes' ...

***NOTE:*** Do not use JavaScript's *Array.includes()* method.

The function should accept two arguments:

* the first argument should be a value to look for

* the second argument should be an array to look in

If the value is inside of the array, return true, otherwise, return false.
*/

/***************** Your Solution *****************/
/*************************************************/

/*
6 : Write a function named 'filter' ...

***NOTE:*** Do not use JavaScript's *Array.filter()* method.

The function should accept two arguments:

* the first argument is a value to check exists

* the second argument is an array

Your 'filter' should return a new array containing a subset of the values in the
array provided as an argument, such that they contain the value provided as the
first argument.

##### Example :

```js
var arr = [1,11,44,23,65,123];

filter(1,arr); // => [1,11,123];
```

*/

/***************** Your Solution *****************/
/*************************************************/
