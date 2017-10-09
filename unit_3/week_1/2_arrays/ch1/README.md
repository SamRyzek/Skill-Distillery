### Array Basics

* To create a new array literal with no stating values, we simply use `[]`
```javascript
var nums = [];
```

* If I instead wanted to create an array with values I can simply list the values separated by a comma.
```javascript
var nums = [1,2,3,4];
var names = ["Andrew", "Kris"];
```

* Once an array has been created you can check how many elements are stored inside of it with the `.length` property.
```javascript
var nums = [1,2,3,4];
nums.length     //4
```

* To access a specific element in an array we can use subscript notation just like we did in Java.
```javascript
var nums = [1,2,3,4];
nums[2]         //3
```

### Adding to an Array `push(value)`
  * Add an item to the end of an Array and return the resulting length of the Array

```javascript
var arr = [1,2,3];
arr.push('kiwi'); // 4

arr; // [1,2,3,'kiwi']
```

### Hands On:
* Assign an empty array to a variable named `classmates`.  

* Use `push()` to add the names of your classmates to the array.


### Removing from an array `pop()`
  * Remove and return the last item in an Array

```javascript
var arr = [1,2,3,4];
arr.pop(); // 4

arr; // [1,2,3]
```

### Hands On:
* Use `pop()` to store the last name from your `classmates` array into a variable named `last`.  

* Use `console.log` to print out `last`, use another `console.log` to print out the `classmates` array.

#### Continue to [Basic Array Lab](./basicArrays)
