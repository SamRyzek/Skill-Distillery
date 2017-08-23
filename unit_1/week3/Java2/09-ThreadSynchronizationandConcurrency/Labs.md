## Labs

1. Compile and run Race.java. Do you see a race condition? If not, increase the size of the loop until you see a race condition. What is causing the race condition? (Hint: Look in %JAVA_HOME%\src.zip for the source code to ArrayList.java.)
(Solution: Race.java, racecondition.txt)

1. Use the `synchronized` keyword to modify Race.java so that the race condition no longer exists.
(Solution: SyncRace.java)

1. Replace `ArrayList` with a different collection that will prevent the race condition.
(Solution: CollectionRace.java)

1. Modify your code again to implement `Callable` rather than `Runnable`. Have your `call()` method return the `String` "Done."
(Solution: CallableRace.java)

<hr>

[Prev](RaceConditions.md) | [Up](../README.md)

