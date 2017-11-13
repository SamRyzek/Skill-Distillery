### ArrayList
* A traditional array in Java has a fixed length.  
* ArrayLists are programmed to be automatically resizable.  
  * As we add items to the ArrayList it will grow in size. This resizing happens when the array fills its capacity, at this point it will double in size.  
* Different languages resize by different factors, Java in particular refactors with a factor of two. Meaning it doubles when the array runs out of space.

* We can determine how many times an ArrayList has doubled by working backwards:  
If we have an array of length 33 (using integer math)  
1: 33/2 = 16  
2: 16/2 = 8  
3: 8/2 = 4  
4: 4/2 = 2  
5: 2/2 = 1  

### Linked List
A linked list is a set of nodes that have pointers to the next node in the chain. A doubly linked list has pointers to both the next and previous nodes in the chain.

![LinkedList](linked_lists.png)

* We can navigate to the next (or previous if its doubly linked) node by using the reference we have attached to each node.  
* There is no way to access a particular index of the collection. In order to get to the 3rd node we would have to access the next property of the 1st and 2nd nodes respectively.  

Implementation:
```Java
public class Node<T>{
  T data;
  Node<T> next;

  public Node(T data, Node next){
    this.data = data;
    this.next = next;
  }
}
```

A linked list node is fairly easy to implement a representation of. In this case each node in the list has the data it houses as well as a reference to the next node in the list.

* Reassigning the head  
  * reassign the pointer for the head to the current heads next variable.
* Add to the front of the list  
  * reassign the pointer for the head to the new node you have created.
* Add to the back of the list  
  * Iterate until the current nodes next value is null and assign the new node to the next property.
* Deleting a node  
  * Find the node you want to remove. Assign the previous nodes next value to the current nodes next value.


### [Bubble Sort](bubble_sort.md)
