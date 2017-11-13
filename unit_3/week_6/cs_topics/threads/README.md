## Threads
Modern computers allow for multiple processes running at the same time. Threading is the practice of getting multiple processes to run at the same time.

When running an application Javas virtual machine creates a single thread, the main thread, for the main() method to execute on. This thread, and all threads in a Java program are controlled by the java.lang.Thread class.

If we want to manually implement threads in Java, we can:
* Implement the Runnable interface (java.lang.Runnable)
* Extend the Thread class (java.lang.Thread)

### java.lang.Thread
If we want out class to run on multiple thread we can use Java's Thread class. First we need to extend the Thread class in our own class. Second you need to override the run method. The code inside of the run method is what will be executed when you start the thread.

The thread class also allows you to give each thread a unique name. When you instantiate a class that extends thread you can call the `.setName()` method on that object. In side of your implementation class you can call ``this.getName()`` to access the name you assigned that thread.

```java
public class PrintNumbers extends Thread{
  public int start = 0;
  public int inc =1;

  public PrintNumbers(int start, int inc){
    this.start = start;
    this.inc = inc;
  }

  public void print(){
    int i,j;
    for(i=start, j=0; j < 20; j++, i += increment){
      System.out.println(this.getName() + " " + i);
    }
  }

  @Override
  public void run(){
    print();
  }
}
```

Once your class has properly extended Thread and overrided the run() method you can create a test class. Once you instantiate your thread objects you can initiate their process by sending a start message `start()`. The virtual machine will then call the `run()` method. When the run methods code has executed, the thread will be terminated.

```java
public static void main(String[] args){
  PrintNumbers p1 = new PrintNumbers(1,2);
  p1.setName("odds");
  PrintNumbers p2 = new PrintNumbers(2,2);
  p2.setName("evens");

  p1.start();
  p2.start();

}
```

### java.lang.Runnable
A second method of implementing thread functionality is extending the Runnable interface.

The first two steps to implementing the runnable interface are identical to those with the Thread class. After that there are a few other simple steps to properly associate your class with a Thread.  
1: Implement the runnable class  
2: Override the run() method  
3: Create a thread field  
4: Initialize a new thread  
5: Start the thread  

```java
public class PrintNumbers implements Runnable{  //1
  private int start = 0;
  private int inc =1;
  private Thread thread = null;                 //3

  public PrintNumbers(int start, int inc){
    this.start = start;
    this.inc = inc;
    thread = new Thread(this);                  //4
  }

  public void print(){
    int i,j;
    for(i=start, j=0; j < 20; j++, i += increment){
      System.out.println(i);
    }
  }

  public void run(){                            //2
    print();
  }

  public void startThread(){
    thread.start();                             //5
  }
}
```

### Race conditions
Race conditions occur when two threads are accessing and manipulating the same data. If a thread gets suspended in the middle of modification, another thread can enter and modify the same data. When the original thread runs again, it may be accessing out of date data.

To avoid race conditions we can use synchronized methods. It implements a lock and key system so one thread can access an object at a time.
