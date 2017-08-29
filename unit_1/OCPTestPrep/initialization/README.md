## Initialization

It is important to clearly distinguish between initialization of a class or of an object.  

### Class initialization

Classes or interfaces are initialized upon first access.

  * If there is an inheritance hierarchy, all the super classes' static elements will be resolved first.  

  *  Static initializer blocks and static field declarations are executed in the order in which they appear in the class source code.  

### Instance initialization

Instance initialization occurs when an instance of an object is created.

  * If there is an inheritance hierarchy, all the super classes' non static elements will be resolved as well.  

  * All instance field declarations and instance initializer blocks are executed in the order listed in the class source code.  

  * After all this the constructor is executed.


The explicit definition of instance initialization from the Oracle Java docs is as follows:
> Just before a reference to the newly created object is returned as the result, the indicated constructor is processed to initialize the new object using the following procedure:

>1. Assign the arguments for the constructor to newly created parameter variables for this constructor invocation.

> 2. If this constructor begins with an explicit constructor invocation (§8.8.7.1) of another constructor in the same class (using this), then evaluate the arguments and process that constructor invocation recursively using these same five steps. If that constructor invocation completes abruptly, then this procedure completes abruptly for the same reason; otherwise, continue with step 5.

> 3. This constructor does not begin with an explicit constructor invocation of another constructor in the same class (using this). If this constructor is for a class other than Object, then this constructor will begin with an explicit or implicit invocation of a superclass constructor (using super). Evaluate the arguments and process that superclass constructor invocation recursively using these same five steps. If that constructor invocation completes abruptly, then this procedure completes abruptly for the same reason. Otherwise, continue with step 4.

> 4. Execute the instance initializers and instance variable initializers for this class, assigning the values of instance variable initializers to the corresponding instance variables, in the left-to-right order in which they appear textually in the source code for the class. If execution of any of these initializers results in an exception, then no further initializers are processed and this procedure completes abruptly with that same exception. Otherwise, continue with step 5.

> 5. Execute the rest of the body of this constructor. If that execution completes abruptly, then this procedure completes abruptly for the same reason. Otherwise, this procedure completes normally.

## Resources

http://docs.oracle.com/javase/specs/jls/se7/html/jls-12.html#jls-12.4.2

