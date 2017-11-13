## Binary Search Algorithm

The binary search algorithm is used to search through a given array to find the position of a target value within the sorted array. We start by finding the middle element of the array and comparing its value to the target value. If the value is greater than the middle element we then grab the latter half of the array. Similarly if the value is less than the middle element we grab the former half of the array. This process continues until a match is found or there are no more elements to compare against.

### Implementation

Lets implement a solution to this algorithm that compares any sorted array with a target value. If the value is found within the array, return true, otherwise return false.
* We will only need one class lets call it BinarySearch.
* This class will take a single argument, a sorted array, and have a single method `contains(int target)`.
