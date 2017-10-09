### `shift`, `unshift`
* All of these methods are responsible for either adding a item to an existing array, or removing and item from an existing array.

### `shift()`
  * Remove the first item in an Array

```javascript
var arr = [1,2,3,4];
arr.shift(); // 1

arr; // [2,3,4]
```  

### Hands On:
* Use `shift()` to store the first name from your `classmates` array into a variable named `first`.  

* Use `console.log` to print out `first`, use another `console.log` to print out the `classmates` array.

### `unshift(value)`
  * Add an item to the beginning of an Array and return the resulting length of the Array

```javascript
var arr = [1,2,3,4];
arr.unshift('kiwi'); // 5

arr; // ['kiwi',1,2,3,4]
```  

### Hands On:
* Use `unshift()` to add the first name of three new people to your `classmates` array.  

* Use `console.log` to print out the `classmates` array.


#### Continue to [3 - `join`, `slice`, `splice`](3_JoinSliceSplice.md)
