## Stack vs Heap

Our Java programs save information in two locations the Stack and the Heap.

### Heap
* The heap has application scope, meaning it is accessible anywhere inside your application.  
* The Heap is used by the runtime environment to store references to Objects.  
* Java's Garbage Collection runs on the heap to remove objects that no longer have a pointer. This frees up memory for other objects that will be stored at this location.  
* The heap is divided into the younger generation and the older generation.
* When the heap is full Java will throw a java.lang.OutOfMemoryError error.

### Stack
* The stack is used when executing a thread.
* Stack memory has function scope, meaning it stores the values of a single process and isn't accessible to any other aspects of the application.
* When a method is executed the stack allocates a piece of the stack to store references to objects, as well as primitives.
  * Primitive variables and their values are stored in the stack.
  * Object variables are stored in the stack with a reference to a location in the heap. This is the location where the object is saved.
* Once the method finishes executing that same piece of memory can be used by anther method.  
* When the stack is full Java will throw a java.lang.StackOverFlowError.


#### Example
```java
public static void main(String[] args){
  int i=1; // Line 2
  Object obj = new Object(); // Line 3
  MyClass my = new MyClass(); // Line 4
  my.myMethod(obj); // Line 5
  i=10;
}

public void myMethod(Object param){
  String str = param.toString(); //// Line 7
  System.out.println(str);
}
```
