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
![APPclass](https://user-images.githubusercontent.com/48712088/145826923-f2dbf297-a4cc-49a1-a062-69fb59508cff.png)

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
A class may have one or more relationships with other classes. Connect them, and write small digits to show the number of each class for the relationship. For example, 1..4 means the class may have 1~4 objects, and * means many objects.
##### Aggregation
![APPhasa](https://user-images.githubusercontent.com/48712088/145827039-eae9d069-1055-445f-bb02-7635e0daa1b9.png)

If an object is an aggregation (group) of other objects, it is called "Aggregation", or "HAS-A" relationship. Example for this is the situation that a Rectangle object has a Point object as its field.
##### Association
![APPassociation](https://user-images.githubusercontent.com/48712088/145829394-2d9496db-2c53-4e59-adb6-4f1c8d4f6b73.png)

Meanwhile, there is also a relationship to describe an activity between two objects. It is an "Association", and binary relationships on Car-Driver or Doctor-Patient can be the examples for this. Draw an open arrow to show the direction, or just a line without the arrow.

##### Inheritance
![APPinheritance](https://user-images.githubusercontent.com/48712088/145827073-6153874c-40eb-47f9-ba3a-1511dce30092.png)

Inheritance, generalization, or "IS-A" represents a relationship between superclass and subclass. Name of an abstract class is written in italics.

##### Composition
![APPcomposition](https://user-images.githubusercontent.com/48712088/145827175-7df1ade1-95b5-4b35-bdec-8e77f9512670.png)

Composition means a special type of aggregation where parts are destroyed when the whole is destroyed.

##### Dependency
![APPdependency](https://user-images.githubusercontent.com/48712088/145827394-6607611b-d7b4-4feb-9381-6fd65f98f251.png)

Dependency shows a relationship that one's definition may cause changes to the other.

##### Realization
![APPrealization](https://user-images.githubusercontent.com/48712088/145827681-f5df3e4e-132c-41c4-a697-392e2b7aa387.png)

Realization is an abstraction relationship between a specification and an implementation.
