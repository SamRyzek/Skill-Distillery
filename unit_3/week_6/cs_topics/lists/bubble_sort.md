## Bubble Sort
A Bubble Sort starts at the beginning of an array and swaps elements if the first element is greater than the second. From there we move one index and do the same comparison. The sorting is complete when we can iterate over the entire array and not swap any elements.

#### Example
First pass:  
(2 7 1 6 10) --> (2 7 1 6 10)  
(2 7 1 6 10) --> (2 1 7 6 10)  
(2 1 7 6 10) --> (2 1 6 7 10)  
(2 1 6 7 10) --> (2 1 6 7 10)  

Second pass:  
(2 1 6 7 10) --> (1 2 6 7 10)   
(1 2 6 7 10) --> (1 2 6 7 10)  
(1 2 6 7 10) --> (1 2 6 7 10)  
(1 2 6 7 10) --> (1 2 6 7 10)  
