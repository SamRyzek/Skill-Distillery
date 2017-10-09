# Numbers
* In JavaScript there are no 'types' of numbers, however, decimal points do add precision to a degree. 'Integer' (non-decimal) values are accurate up to 15 digits, while decimals are accurate up to 17 digits.

* Floating point arithmetic can be inaccurate:

```javascript
var x = 0.1 + 0.2; // Inaccurate...0.30000000000000004

var y = 0.1;
var z = 0.2;
y + z; // Accurate...0.3
```

* `NaN` (not-a-number) is a number. `NaN` results from operations in which the result is non-numerical, like trying to divide a number by a string.

```javascript
var x = 5/"Banana"; // NaN
```

### Hands On
1. In the Chrome developers console, practice declaring and initializing variables.

2. Declare a variable 'num'.
  * Assign num the value of `4/0`. Type the variable name ('num') into the console and press 'return'. What is the value of 'num'?
  * What is `num - 5`?
  * What is `num - num`?
3. `NaN` is a valid number in JavaScript, but what happens when you subtract a number from it? (`NaN -4`)


##### [Prev](2_Declarations.md) | [Next](4_Strings.md)
