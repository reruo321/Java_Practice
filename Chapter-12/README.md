# Ch. 12 - Process and Thread
## Process
**Process** means a running program on a computer. Usually program refers to an executable file with a certain set of instructions, stored on memory space.
Meanwhile, process is a processing unit which executes a program on the memory, taking many resources such as memory address, disk, and printer. If one program is executed in several times, its multiple processes are stored in the memory to run. The process run in separate memory spaces, while threads share the memory.

Process has parent process and child process. The parent one is started from a program or a command, but the child one is from its parent. The situation that multiple children seem to be processed simultaneously by one CPU is called **multitasking**. Process is managed by these states.

1. **Create**: Process is being created.
2. **Running**: Process is being run onto the CPU, running instructions.
3. **Ready**: Process is ready for CPU allocation, not using CPU now.
4. **Waiting**: Process is waiting for certain events such as I/O completion or signal receiving.
5. **Terminated**: Process execution is terminated.

The process has changed its state by dispatch, block, and wakeup.

6. **Dispatch**: Process becomes ready → running. The state that the first process on the ready queue occupies a CPU.
7. **Block**: Process cannot carry on without an external change in state or event occurring, so it returns its CPU by itself and becomes waiting state.
8. **Wakeup**: Process becomes waiting → ready when certain event like I/O task termination or signal receiving arises.

## Thread
**Thread** gets the same execution environment with process but takes less resources to create a new one, since it is in the process sharing process's resources (memory, file, ...) with others. To sum up, this is the reason thread is also called "lightweight process". It is effective but might cause a sharing issue.

Java has two ways to create the thread.

1. Extend *Thread* class.
2. Implement *Runnable* interface: When making a thread with the class already extended the other.

### Class Thread
Create a thread with its extending Thread class like this. First, redefine run() method. run() acts in the same way as main() in Java applications.

    class <Class-Name> extends Thread {
      public void run(){...}
      ...
    }
    
    <Class-Name> <Reference-Name> = new <Constructor>();
    <Reference-Name>.start();
    
These are major methods in Thread.

| Method | Description |
|:-:|:-:|
| static Thread currentThread() | Returns the reference of the current running thread. |
| int getPriority() | Returns the priority of the thread. |
| boolean isAlive() | Tells if the thread is alive. |
| void join(long millis, int nanos) | Waits the termination of the thread. |
| void run() | The statements to be run by the thread. |
| void setPriority(int newPriority) | Sets the priority of the thread. |
| static void sleep(long millis, int nanos) | Sleeps the thread. |
| void start() | Starts the thread execution. |
| static void yield() | Yields the current running thread to run another one. |
| void suspend() | (Not recommended) Suspends the thread. |
| void resume() | (Not recommended) Resumes the suspended thread. |

### Interface Runnable
Interface Runnable only provides run() method.

    class <Class-Name> implements Runnable {
      public void run(){...}
      ...
    }
    
    <Class-Name> <Reference-Name-1> = new <Constructor>();
    Thread <Reference-Name-2> = new Thread(<Reference-Name-1>);
    <Reference-Name-2>.start();
    
### Thread State and Life Cycle
The cycle of a thread is called "State Transition" or "Life Cycle".

![12Lifecycle](https://user-images.githubusercontent.com/48712088/149791337-93525bb9-81b0-4e6a-8bab-c76ff03c57b7.png)

1. **New**: The initial state of a new created thread. Created one by Thread constructor gets this state.
2. **Runnable**: Waiting state for being processed by CPU. The new thread goes to it by start(). Besides, the thread can be also Runnable 1) if the thread paused by wait(), sleep(), or suspend() is run by resume() or notify(), 2) if I/O paused the thread is completed, or 3) yield() is called for the running thread.
3. **Running**: The thread is running on a CPU. The runnable thread becomes running when it is executed by Scheduler.
4. **Blocked**: Blocked thread is the thread paused while running, waiting for the next execution. Special condition would make it running state again. 1) If wait(), sleep(), or suspend() is called for a runnable or a running thread, or 2) some tasks like I/O pauses the thread, thread becomes blocked.
5. **Dead**: The thread is completely terminated, so it cannot be executed again.

#### ※ Waiting vs Blocked
If wait() is called on an object, a thread goes to **Waiting** state. Then it may need to wait until other threads call notify() or notifyAll().

Once the thread is notified, it will not be Runnable but **Blocked** if there are other notified threads (using notifyAll()) or the first thread has not finished its work, still being blocked to get its chance. It finally becomes Runnable once others have left and it gets the chance.

## Synchronization and Scheduling
If a multi-threaded program executes multiple threads in parallel, not in sequence, they may cause a problem because of their sharing resources. This happens since different threads are trying to modify the same data concurrently. To solve it, use **synchronized** to lock other threads. It prevents them from modifying the data, until one terminates.

In addition, multiple threads should be executed by CPU in multi-threaded program, but actually only one thread can be done at the moment. Therefore, it should select a thread to execute among waiting ones by **scheduling**.

### Synchronization
To avoid duplicated execution on shared data by multiple threads, Java provides *synchronized* keyword. There are two ways to use it. 1) Declare it on a method declaration.

    public synchronized <Return-Type> <Method-Name> (<Parameters>){...}
    
2) Declare it on a block. This makes more effective threading than the first one, when there are so many contents in the method.

       public class <Class-Name>{
             public <Return-Type> <Method-Name>(<Parameter>){
               synchronized(this){...}
               ...
             }
            ...
        }

If you erase *synchronized* keyword on methods in Example 03 or Example 05, data would be tangled.

![12Ex03](https://user-images.githubusercontent.com/48712088/150128863-79fe7e80-2901-470a-9ca3-0bf1b24c8920.png)
![12Ex05](https://user-images.githubusercontent.com/48712088/150128870-2554e33f-26d8-470d-9022-2cb56a086d2c.png)


### Scheduling
Scheduling in Java is preemptive. It checks priority of runnable threads based on scheduling algorithm. Suppose that there are two threads A and B. If the priority is running A < runnable B, it blocks A and executes B. If the priority is A = B, and if they want to be run concurrently, it rotates their execution in sequence, as much as time can to do.

If a thread creates another thread, the new one derives the priority from its parent. By using Thread.setPriority(), you can change the order of the threads, giving them the priority from 1(lowest) to 10(highest). Default priority for threads is 5(NORM_PRIORITY). Use getPriority() to know the priority of specific thread.

