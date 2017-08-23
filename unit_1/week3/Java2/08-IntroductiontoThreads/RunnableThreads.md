## Runnable Threads

* The VM maintains a queue of all currently-runnable threads.

  * As time slices are allocated to a thread, its `run()` method will proceed until:

    * The thread is blocked.

    * The thread voluntarily gives up its time slice.

    * The VM ends the time slice.

    * The thread dies.

  * If the thread is still runnable, it is placed back in the queue and given additional time slices as they are available.

* The VM resumes the thread's `run()` method where it left off, as each time slice is awarded to a thread.

<hr>

The _Thread Scheduler_ keeps a queue of all threads in your application. When an actively-running thread either gives up its time, or its time slice is over, it is placed at the end of the thread queue. The first thread in the queue is then made the currently-running thread.

If a thread is in a blocked state, the VM will not try to run that thread until it is unblocked.

The thread queue is actually a priority queue, so a thread with a high priority will not be placed at the end of the queue, but will be placed based on its priority. Thread priorities can be set by calling `setPriority(int newPriority)` on a `Thread`. Static finals exist to determine the max, min, and normal priorities for threads.

[Prev](NonThreadedApplications.md) | [Up](../README.md) | [Next](CoordinatingThreads.md)

