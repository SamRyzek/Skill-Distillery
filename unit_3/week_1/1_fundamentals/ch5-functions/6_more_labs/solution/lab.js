/*
1 : Write a function named 'reverse' ...  
  
This function will take one argument, a string.  
  
Return the submitted string with the characters in reverse order.  
  
***NOTE*** Do not use the 'reverse' method on the String object, write your own.
*/

/************** Your Solution Here ****************/
var reverse = function(str) {
  var reversed = '';

  var l = str.length - 1;
  for (var i = l ; i >= 0 ; i--) {
    reversed += str[i];
  }

  return reversed;
};
/**************************************************/

/*
2 : Write a function named 'palindromeChecker' ...  
  
This function will take one argument, a string.  
  
If the provided string is a palindrome (the same backwards and forwards), return
true, otherwise return false.
*/

/************** Your Solution Here ****************/
var palindromeChecker = function(str) {
  if (reverse(str) === str) {
    return true;
  }
  return false
};
/**************************************************/

/*
3 : Write a function named 'isPrime' ...  
  
This function will take one argument, a whole number.  
  
If the provided number is prime, return true, otherwise, return false.
*/

/************** Your Solution Here ****************/
var isPrime = function(num) {
  var rootNum = Math.floor(Math.sqrt(num));
  for (var i = 2 ; i < rootNum ; i++) {
    if (num % i === 0) {
      return false;
    }
  }
  return true;
}
/**************************************************/

/* 
4 : Write a function named 'computeTax'. 

This function will take one or two arguments.  
  
* The first argument will always be the amount tendered. 

* The second argument, which is optional, could be the tax percentage (as a 
whole number). If no second argument is provided, assume the tax rate is 7.5%.  
  
Once applying the correct amount of tax, return the amount of tax owed.  
*/

/************** Your Solution Here ****************/
var computeTax = function(tender, tax) {
  var rate = 0.075;
  if (tax) {
    rate = tax / 100;
  }
  return tender * rate;
};
/**************************************************/

