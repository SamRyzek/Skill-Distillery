# Control Flow Lab

1: Write a for loop that takes the the value of `base`, and modifies a variable (`total`) to base to the power of `pow` in the following function:
  
```js
var exponential = function(base, pow) {
  var total;

  /************* Your Code Here **************/

  /*******************************************/

  return total;

}
```
  
2: The Fibonacci sequence is a series fo numbers in which the first two numbers are 0 and 1. Each subsequent number is the sum of the previous two. So, the next Fibonaci number is (0+1)=1. The next is (1+1)=2. Then (1+2)=3...etc etc. The first two are pre-defined as 0 and 1. All subsequent numbers are calculated from there.  
  
Modify the following function with a `while` loop to print the 'nth' Fibonacci number, where the variable `n` is that numbers position. E.g. the 5th Fibonacci number is `3`.  
  
```js
var fibonacci = function(n) {
  var number;
  /************* Your Code Here **************/

  /*******************************************/
  return number;
};
```
  
3: Complete the following 'reduce' function such that it will return the a value equal to the all of the values of the provided array (`arr`) combined through some operation (`op`), where `op` is a string like '+', '-', '*', or '/'.  
  
E.g.  
  
```js
reduce('+', [1,2,3]); // => 6
```
  
If the provided operator (`op`) is not one of those listed above, return the string 'invalid operator' instead.  
  
```js
var reduce = function(op, arr) {
  var total = arr[0];
  /************ Your Code Here *************/

  /*****************************************/
  return total;
};
```
  
4: Complete the following 'isLeapYear' function such that it will return true if the `year` provided is a leap year and `false` if the value is not a leap year.  
  
**Leap Years** :  

In the Gregorian calendar, a normal year consists of 365 days. Because the actual length of a sidereal year (the time required for the Earth to revolve once about the Sun) is actually 365.25635 days, a "leap year" of 366 days is used once every four years to eliminate the error caused by three normal (but short) years. Any year that is evenly divisible by 4 is a leap year: for example, 1988, 1992, and 1996 are leap years.  
  
However, there is still a small error that must be accounted for. To eliminate this error, the Gregorian calendar stipulates that a year that is evenly divisible by 100 (for example, 1900) is a leap year only if it is also evenly divisible by 400.  
  
For this reason, the following years are not leap years:
1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600
This is because they are evenly divisible by 100 but not by 400. 

```js
var isLeapYear = function(year) {
  var leapYear;
  /************ Your Code Here *************/

  /*****************************************/
  return leapYear;
};
```

##### [Prev](../4_ThrowTryCatchFinally.md) | [Next](../../ch5-functions/README.md)
