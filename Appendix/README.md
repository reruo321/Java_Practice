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
![APPclass](https://user-images.githubusercontent.com/48712088/145821902-f763c251-e4c4-4943-93a3-ea1ff5cc1618.png)

Class notation consists of three parts. Write them with their return types.
1. Class Name
2. Class Attribute: Member Variable (Field)
3. Class Operation: Method
#### Visibility
Visibility allows to constrain the usage of an element in namespaces, and it is marked by an access modifier. Add it in front of the class attributes, or operations.
* public: +
* protected: #
* package: ~
* private: -

Note: You can use ~ (package) for *default* in Java.
#### Relationship
A class may have one or more relationships with other classes. Connect them, and write small digits to show the number of each class for the relationship.
##### Aggregation
![APPhasa](https://user-images.githubusercontent.com/48712088/145821937-deb7f40c-0554-497b-8eb7-443b38670ea2.png)

If an object is an aggregation (group) of other objects, it is called "Aggregation", or "HAS-A" relationship. Example for this is the situation that a Rectangle object has a Point object as its field.
##### Association
![APPassociation](https://user-images.githubusercontent.com/48712088/145821964-6bb8455c-b022-45b8-87b2-eda7138cde79.png)

Meanwhile, there is also a relationship to describe an activity between two objects. It is an "Association", and binary relationships on Car-Driver or Doctor-Patient can be the examples for this. Draw an open arrow to show the direction, or just a line without the arrow.

##### Inheritance
![APPinheritance](https://user-images.githubusercontent.com/48712088/145822035-a4a9c506-c335-436f-a44b-ce322d1d2a25.png)

Inheritance, generalization, or "IS-A" represents a relationship between superclass and subclass. Name of an abstract class is written in italics.
