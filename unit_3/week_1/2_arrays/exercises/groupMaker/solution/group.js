/*
1 : Create an array literal named 'classArray' ...  
  
The array should contain the first name of each member of your class 
including yourself.
*/

/*******************Your Solution******************/
var classArray = [
  'Matt',
  'Geoff',
  'Chaz',
  'Yvette',
  'Josh',
  'Josh Zink',
  'Robert',
  'Nik'
];
/**************************************************/

/*
2 : evaluate the following 'shuffle' function ...  
  
Read through the function, and determine what it is doing (annotate each line 
with comments). After you understand what the function is doing (and how), 
return the shuffled array from it.
*/

/*******************Your Solution******************/
var shuffle = function (arr) {
  var randomNum, valueAtIdx;
  /*
    * assign idx the length of the array
    * while idx is not 0
    * decrement idx
  */
  for (var idx = arr.length; idx !== 0; idx--) {
    /*
      * generate a random number from the 
        value of idx (remaining indices)
      * the Math.floor() gauruntees that the value
        will be less than the current value of idx
    */
    randomNum = Math.floor(Math.random() * idx);
    /*
      extract the last value in the array
      that has not yet been evaluated
    */
    valueAtIdx = arr[idx - 1];
    /*
      assign the value at a random index (of the 
      remaining values) to the last index that has
      yet to be assigned a value
    */
    arr[idx - 1] = arr[randomNum];
    /*
      assign the value that was at the index you 
      just reassigned to some lower index (e.g) an
      index that has not been evaluated yet
    */
    arr[randomNum] = valueAtIdx;
  }
  return arr;
};
/**************************************************/

/*
3 : Create a function named 'makeGroupsOfNumFromArray' ...  
  
'makeGroupsOfNumFromArray' accepts two arguments :  

* the first argument is a whole number indicating the size of each group

* the second argument is an array of items to be grouped (in this case your 
classmates).  
  
The function should shuffle the input array, and return an array of arrays, each 
containing a number of names indicated by 'num'.  
  
***HINT:*** Use the `slice` and `push` methods we discussed.
*/

/*******************Your Solution******************/
var makeGroupsOfNumFromArray = function(num, arr) {
  arr = shuffle(arr);
  var l = arr.length;
  var groups = [];
  for(var i = 0 ; i < l ; i+=num) {
    groups.push(arr.slice(i, num + i));
  }
  return groups;
};
/**************************************************/


console.log(makeGroupsOfNumFromArray(3, classArray))