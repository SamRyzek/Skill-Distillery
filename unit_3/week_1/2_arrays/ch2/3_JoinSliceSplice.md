### `split`, `join`, `slice`, `splice`

### `String.split(seperator)`
  * `split(seperator)` is a string method which divides a string into an array based on some delimeter.
  
```js
var sentence = "sally sells sea shells by the sea shore";
var wordArray = sentence.split(" ");

wordArray; // ["sally", "sells", "sea", "shells", "by", "the", "sea", "shore"]
```  
  
### Hands On:
* Create a variable `data` which stores a String of comma seperated words as values.  
  
* Use `split()` on `data` and assign the resulting array to a variable `dataArray`

### `join(seperator)`
  * Returns a concatatenated string of all of the values in an Array (defaults to commas);
  
```javascript
var arr = [1,true,'hello','mango'];

var joined = arr.join();
joined; // '1,true,hello,mango'

var spaced = arr.join(' ');
spaced; // '1 true hello mango'

var and = arr.join(' and ');
and; // '1 and true and hello and mango'
```  
  
### Hands On:
* Use `join()` on the `dataArray` to concatenate all of the values with `//` and store the string back into the `data` variable. 
  
### `slice(startIndex, endIndex)`
  * Returns a slice (subarray) of the array from the index specified at the first argument up to (but not including) the number provided at the index specified by the second argument. If no second argument is provided, it will create a subarray from the start index to the end of the array. **NOTE** `splice` is non-destructive, it merely returns a subarray, it does not alter the original.
  
```javascript
var arr = ['zero','one','two','three'];

var sub = arr.slice(2);
sub; // [ 'two', 'three' ]

var sub2 = arr.slice(0,2);
sub2; // [ 'zero', 'one' ] => Note the non-inclusivity

arr; // [ 'zero', 'one', 'two', 'three' ] => Non-destructive
```
  
### Hands On:
* Create a new variable named `initialData`, use `splice()` on `dataArray` to store only the first two data points into `initialData`
  

### `splice(delStartIndex, delEndIndex, itemToInsert, ...)`
  * Destructively deletes, inserts, or both inserts and deletes from an Array, modifying the original array in the process.
  * The first argument specifies the index to begin the deletion/insertion.
  * The second argument indicates how many indices to remove after the starting point (note, providing a `0` will lead to no deletions).
  * All subsequent arguments provided will be inserted into the array at the index specified by the first argument.
  * `splice` returns an array of deleted items.
  
```javascript
var ogArray = ['apple', 'banana', 'coconut'];

ogArray.splice(1); // [ 'banana', 'coconut' ] => returns deleted elements

ogArray; // [ 'apple' ] => destructive update of original

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

var removeTheMiddleArray = ['Reese', 'Malcom', 'Dewey'];

removeTheMiddleArray.splice(1,1); // [ 'Malcom' ]

removeTheMiddleArray; // [ 'Reese', 'Dewey' ]

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

// There should be a 4 where it says 'kiwi'
var incorrectArray = [1,2,3,'kiwi',5,6,7];

incorrectArray.splice(3,1,4); // [ 'kiwi' ] => remove 'kiwi'

incorrectArray; // [ 1, 2, 3, 4, 5, 6, 7 ] => 4 has been inserted

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

// Add several items
var missingData = ['death', 'taxes'];

missingData.splice(1,0,'bananas','jobs','school','friends'); // [] => nothing deleted

missingData; // [ 'death', 'bananas', 'jobs', 'school', 'friends', 'taxes' ]

```
  
### Hands On:
* Use `splice()` on initial data to insert `"First Data Point"` at the 0th index.  
  
* Use `splice()` on initial data again to insert `"Second Data Point"` at the 2nd index.
  
* Use `splice on initial data again to delete everything after the first data point (1st index).
  

#### Continue to [4 - `reverse`, `sort`](4_ReverseSort.md)
