# Appendix
The documentation shows some useful information on Java.
## Main Arguments
If you want to give some arguments to the main method, follow this.
1. Command Line

compile > javac [Java-File-Name].java
  
run > java [Java-File-Name] [args1] [args2] [args3] ...
    
    (Example)
    javac ArgsExample.java
    java ArgsExample 10 20 Hello
       
2. IDE

Main arguments can be set from IDE configurations.
I would like to explain on Intellij IDEA here, and users of other IDEs such as Eclipse can also follow it in a similar matter.

    1. Run > Edit Configurations > Put arguments into the "Program arguments" field, on Build and run.
    2. Press Alt + Ctrl + F10 > Click '>' > Edit

## Not Working Breakpoints in Intellij IDEA?
I experienced a little dumb troubles for the first time to use debugger in Intellij IDEA.
### Disabled line breakpoint?
You won't be able to toggle a line breakpoint on an empty line.

       (Example)
       void moveX(int a)  // OK.
       {                  // OK.
                          // You can't put a line breakpoint here, because it's an empty line.
          x += a;         // OK.
       }                  // OK.
### Skipped breakpoints?
1. If you "run" the program, instead of "debugging" it, breakpoints do not work. F9 is for the debugging, and F10 for the running.
2. Try to clear caches by File > Invalidate Caches
