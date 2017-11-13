## Big O notation
Big O notation describes a worst case scenario for estimating the time or space required for an algorithm to execute. The time and space required for an algorithm are correlated to the size of the data you are working upon.

There are external factors to how fast an operation can run, like how fast the processor is, and what other processes the computer is running. Therefore, it is impossible to predict exactly how long a single process will take.

Additional big O rules to memorize are:
* Drop all constant
* Drop all least significant elements

### Time complexity

#### O(1)
Executes with constant time, regardless of the size of a data set. Conditionals and statements execute with O(1).

```java
if(i > 0){return true};
else{return false};
```

Other examples:
* Accessing an array index
* Inserting nodes into a stack or queue

#### O(N)
Executes in an amount of time directly related to the length of the data set. This operation will show linear growth directional proportional to the datas length. Loops execute with complexity of O(N), where N is the number of times the loop will execute.

```java
for(int i =0; i < array.length; i++){
  if(array[i] == 5) return true;
}
return false;
```

In this case we have to assume the element containing a 5 could be the last element in the index (N).

Other examples:
* Traversing an array
* Comparing strings

#### O(N^2)
Executes with complexity equal to the square of the length of the data. This can also be referred to a quadratic. Nested loops both need to execute N times to iterate over the entire data set. Therefore the time complexity would be N^2.


```java
for(int i =0; i < n; i++){
  for(int j =0; j < n; j++){
    array[i][j]= i+j;
  }
}
```
If `n = 3` in the above example the loops iterations would be:
```
00,01,02
10,11,12
20,21,22
```
The loops executed 9 times or 3^2 = 9;

Other examples:
* Bubble sort

#### O(2^N)
Represents exponential growth of an algorithm. The algorithm doubles with each cycle. We implemented Fibonacci in such a way that it would have this complexity.

```java
public int fib(int n){
  if (n == 0) return 0;
  else if (n == 1) return 1;
  else return fib(n-1) + fib(n-2);
}
```
For each test we are returning a potential two sub operations.

#### O(log(N))

Binary search is an example of an algorithm with this complexity. With each iteration we are halving the data set. Any action that will have O(log(N)) time complexity can be though of as being able to search through a small subset of a dataset rather than needing to look through every element.

#### Popular data sets

| Structure  | Get | Add | Delete | Contains |
| ---------- | ----------- | ----------- | -------- | -------- |
| HashMap | O(1) | O(1) |  O(1) |  O(1) |
| ArrayList | O(1) | O(1) | O(N) | O(N)  |
| LinkedList | O(N) |  O(1) | O(1)  | O(N)  |
| HashSet | O(1) | O(1) | O(1) | O(1) |
| TreeSet | O(log n) | O(log n) | O(log n) | O(log n)|


#### Comparison

<img src="https://www.cpp.edu/~ftang/courses/CS240/lectures/img/alg-tab.jpg">


#### Resources

[Big O Cheat Sheet](http://bigocheatsheet.com/)  
[Big O Table](https://www.cpp.edu/~ftang/courses/CS240/lectures/img/alg-tab.jpg)  
