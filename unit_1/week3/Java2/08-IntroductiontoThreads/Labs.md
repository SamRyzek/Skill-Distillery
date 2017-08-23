## Labs

1. Extend a class from `Thread` called `ReadFile`. The class should have a constructor that takes a filename and an object number (an `int`) as its arguments.
   
  `ReadFile`'s `run()` method should have a loop that reads five lines from the file, sends each line to the screen with this object's number, then calls `yield()`.
   
  Add a `main` method to your class that instantiates three different `ReadFile` objects. Each one should be given a unique object number. Call `start()` on each object.
  (Solution: ReadFile.java)

2. Change your solution to 1. to implement `Runnable` instead of extending `Thread`.
(Solution: ReadFile2.java)

<hr>

[Prev](NonThreadedApplications.md) | [Up](../README.md)

