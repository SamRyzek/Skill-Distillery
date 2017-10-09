# Algorithms Lab
### Introduction
The following lab will test your ability to manipulate arrays in a non-trivial way. It will also introduce you to Computer Science and Algorithmic concepts that are presumed knowledge in industry. This lab will likely take longer for you and your pair to complete then there is time alotted. In the extremely likely situation that you do not complete all of these exercises prior to the end of lab time, begin with this lab during afternoon pair time.

### 0 : Use the following array literal to test all of your functions.

```js
var testArray = [
  8,99,76,90,1009,6520,32,102,109,392,324,203,230,
  12,23,546,234,1231,5346,4235234,1230,989,34230,
  123,242,124356,13,2,3,1,5,68,545,34,62,56
 ];
```

### 1 : Write a function named 'linearSearch' ...  
The function will accept two arguments:  

* the first argument is the number you are searching for.

* the second argument is the array you are searching in.

Your goal is to iterate over the provided array, return the index of the sought
number if it is present, or `-1` if it is not.  

##### Background :
In computer science, linear search or sequential search is a method for finding
a target value within a list. It sequentially checks each element of the list
for the target value until a match is found or until all the elements have been
searched. Linear search has a time complexity of `O(n)`, where 'O' is the
potential growth rate in terms of time for the operation to complete and the
value between the parentheses represents the worst case scenario for the
operation's total time. In linear search operations, the worst case would be to
iterate over the entire list provided (of length 'n'), thus we represent the
time complexity for this operation as `O(n)`.

* https://en.wikipedia.org/wiki/Linear_search

* https://en.wikipedia.org/wiki/Big_O_notation

### 2 : Write a function named 'bubbleSort' ...  
The function will accept one argument, an array.  

In bubble sort, we start at the beginning of the array and swap the first two
elements if the first is greater than the second. Then, we go to the next pair,
and so on, continuously making sweeps of the array until it is sorted. In doing
so, the smaller items slowly 'bubble' up to the beginning of the list.  

##### Background :
Bubble sort's time complexity is O(n<sup>2</sup>). This is a result of the worst
case scenario is that every item will have to be iterated over as many times as
there are items in the list. To put it another way:  

<blockquote><i>O(n<sup>2</sup>) represents an algorithm whose performance is directly proportional to the square of the size of the input data set. This is common with algorithms that involve nested iterations over the data set. Deeper nested iterations will result in O(n<sup>3</sup>), O(n<sup>4</sup>) etc.</i></blockquote>

* https://en.wikipedia.org/wiki/Bubble_sort

### 3 : Write a function named 'binarySearch' ...  
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

##### Background :  

Binary search's time complexity is O(<i>log</i> n). This is indicative of the
iterative halving of data sets (i.e. the longer the algorithm runs, the more
efficient it is). Comparing it to linear search, if the array given to each
search method had a length of 1, then the operation would take the same amount
of time, however, if the length of the data set was 100, linear search would
perform 100 operations, where as binary search would perform only 8. Even
doubling the data set would do little in terms of time of the operation, as a
set of even 1,000,000 items would require only 21 operations (worst case) to search.  

* https://en.wikipedia.org/wiki/Binary_search_algorithm

### 4 : Write a function named 'slice' ...  
***NOTE:*** Do not use JavaScript's *Array.slice()* method.  

The function should accept two arguments:  

* the first argument is the index at which to begin

* the second argument is the array to modify

'slice' should return an array comprised of the values of the array provided as
an argument from the provided index to the end of the original array.  

##### Example :
```js
var arr = [0,1,2,3,4,5,6,7,8,9,10];

slice(5, arr); // => [5,6,7,8,9,10];
```
### 5 : Write a function named 'includes' ...  
***NOTE:*** Do not use JavaScript's *Array.includes()* method.  

The function should accept two arguments:

* the first argument should be a value to look for

* the second argument should be an array to look in

If the value is inside of the array, return true, otherwise, return false.

### 6 : Write a function named 'filter' ...  

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
