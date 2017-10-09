# Basic Arrays Lab
### 1 : Create an array literal in a variable named 'testArray'  
  
The array should contain the values :

* 0-10

* `'apple'`, `'banana'` and `'coconut'`

* `undefined`

* `NaN`

### 2 : Write a function expression named 'countElements' ...  
  
The function will take a single argument (an array), and should return the 
length of the array

### 3 : Write a function expression named 'countType' ...  
  
The function will take two arguments:  

* the first argument is an array

* the second argument is the string representation of a type (e.g. 'number')
  
The function should return the number of that type of value contained within the 
array

### 4 : Write a function expression named 'countTypeWithFunction' ...  
  
The previous function useful, but obviously flawed. We are simply testing for 
type, however it is unlikely that we would want to include `NaN` in that count. 
Unfortunately for us, `NaN`'s type is 'number'. To circumvent this, we will pass 
a new function ('countTypeWithFunction') a function which uses some specific 
logic to determine if a number should be counted.  
  
'countTypeWithFunction' will accept two arguments:  
  
* the first argument should be an array

* the second argument is a function
  
The function will evaluate a single element of the array and determine if it 
should be included (return true), or not (return false).  
  
Write three function expressions to pass to your 'countTypeWithFunction' function :  
  
* isRealNumber

* isString

* isUndefined
  
Each takes one argument (the current value), and returns true or false depending 
on if the value is of the desired type.

### 5 : Create a function expression named 'concurrentModification' ...  
  
'concurrentModification' takes two arguments:  

* the first argument is an array

* the second argument is a function
  
Your objective is to remove all of the real numbers from the array. There is a 
method (`splice`) which will help you remove items from a JavaScript array. `splice` 
does a great many things, but you can remove a single value by passing the index 
of that value and the number 1 to `splice` as arguments (`array.splice(i,1);`).  
  
Unlike Java, JavaScript will not throw any sort of 'ConcurrentModificationException', 
if you modify an array as you iterate over it...but there are other consequences...
this exercise should familiarize you with those.  
  
Once you have removed all of the numbers from the array, return the resulting 
array.
