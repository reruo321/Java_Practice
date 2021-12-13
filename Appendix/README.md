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
If the option Run > Toggle Breakpoint > Method Breakpoint is opened but not for the line, check this out. You won't be able to toggle the line breakpoint on an empty line.

       (Example)
       void moveX(int a)  // OK.
       {                  // OK.
                          // You can't put a line breakpoint here, because it's an empty line.
          x += a;         // OK.
       }                  // OK.
### Skipped breakpoints?
1. If you "run" the program, instead of "debugging" it, breakpoints do not work. F9 is for the debugging, and F10 for the running.
### Other possible solutions?
1. Try to clear caches by File > Invalidate Caches.
2. Try to update the IDE to the latest version.

## UML
UML(Unified Modeling Language) is used to express relations between objects by diagrams. It can also draw Class Diagram, and it should be drawn with their directionality and multiplicity.

### Class Diagram
Class notation consists of three parts. Write them with their return types.
1. Class Name
2. Class Attribute: Member Variable (Field)
3. Class Operation: Method
#### Visibility
Visibility allows to constrain the usage of an element in namespaces, and it is marked by an access modifier. Add this in front of member variables, or statements.
* public: +
* protected: #
* package: ~
* private: -

Note: You can use ~ (package) for *default* in Java.
#### Relation
##### Aggregation
![05uml](https://user-images.githubusercontent.com/48712088/145814180-024a6d73-d696-4764-92bb-10ff4ca73f1f.png)

If an object is an aggregation (group) of other objects, it is called "Aggregation", or "HAS-A" relationship. Example for this is the situation that a Rectangle object has a Point object as its field.
##### Association
Meanwhile, there is also a relationship to describe an activity between two objects. It is an "Association", and binary relationships on Car-Driver or Doctor-Patient can be the examples for this.
