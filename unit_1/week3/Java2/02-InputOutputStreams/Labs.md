## Labs

1. Create a class named `Order` which contains a customer id and name. Provide an appropriate constructor.

  * Write the contents of an `Order` object to the file *order.txt* in a readable text format.
  
  * Write the contents of the same object to the file *order.dat* in a binary format.
  
  * Write the same object to the file *order.ser* as a serialized object. Make sure your `Order` class implements `Serializable`.
  
(Solution: Order.java)


2. Create a class named `Search` that searches through the file *employee.txt* for the pattern "manager" and prints out any lines that match the pattern. (Hint: You can search through a string for a substring using the `indexOf()` method in the `String` class.) 
  
(Solution: Search.java)


3. Modify the search program to obtain the pattern followed by the filename from the command line, such as:

```bash
java Search manager employee.txt
```

Try searching through your source code file, *Search.java*, for a pattern such as "= new" or "Reader."

(Solution: Search2.java)

<hr>

[Prev](OverviewofStreams.md) | [Up](../README.md)

