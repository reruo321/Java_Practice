# Ch. 5 - Class and Object
Java is an Object-Oriented Programming language. It can reuse its codes, and it has good modularity, flexibility, maintenance, cost cutting, and troubleshooting. There are four main characteristics of Object-Oriented Progamming.
1. Abstraction: Outlines general traits of several objects. For example, three objects "dog", "cat", and "pig" are the animals having their ears and legs. They can also sleep, eat, and cry.
2. Encapsulation: Data and operators encapsulated by class units can be either public or private.
3. Inheritance: Subclass (child) can be derived from superclass(parent), inheriting its features. Details are on Chapter 6.
4. Polymorphism: Multiple forms are allowed for an interface, or a method.

## Class Definition
A class is a user-defined data type to give shape to objects, as if it is a blueprint to produce them.
### Syntax
    <Access-Modifier> class <Class-Name> extends <Superclass-Name>{
      <Type> <Member-Variable>;
      <Constructor>;
      <Return-Type> <Method-Name>(<Type-Parameter>){...};
    }    
    
    ※ Access-Modifier and Superclass-Name can be omitted.
    
See C05E0XClassName.java files as the examples.
### Constructor
When creating an instance of class in Java, it calls a special method, constructor, to initialize instance variables.
#### Definition
    <Access-Modifier> <Class-Name>(<Type-Parameter>){...}
    
    ※ Access-Modifier can be omitted.
A class and its constructor share the same name, and the constructor can have its parameters. Do not add *void* in front of the constructor, although it does not return anything. It can be called via *new* keyword, and it is used to initialize fields(member variables). Overloading the constructors is allowed like other methods, so the class may have several constructors.

A default constructor is the constructor taking no arguments, and it is automatically generated and called unless its class has any other user-defined constructors. It sets fields to their default values. (For example, an int member variable will set to 0, and a String one to null.) However, once a user adds a constructor, no default constructor is provided anymore.

    /* NoDefault.java */
    public class NoDefault{
      int a;
      // NoDefault(){ a = 0; }   // Should be added, or an error will happen!
      NoDefault(int x){ a = x; }
    }
    
    /* NoDefaultError.java */
    public class NoDefaultError {
      public static void main(String [] args){
        NoDefault no = new NoDefault();   // It cannot find any matching constructor.
      }
    }
When you define some constructors, be careful not to forget to add a constructor with no parameters, since the default one is not generated.

## Object Creation
After defining the class, if we declare a variable of the class type, it creates a reference. By using *new* keyword, we can allocate heap memory to an object(instance), and store attribute values of member variables. Assign it to the reference so that it can refer the object.

When we say A is an *instance* of type B, it means that A is a member of the set of values that is the type B. In other words, an object is an instance of a class. They are treated as almost same even there are a few differences; while the instance refers to reference of an object and is more logical, object is more physical.

        class Dog{   // Class Definition
            ...
        }
        
        /* Example 1 */
        Dog myDog;   // Reference Variable Declaration (Instance Creation)
        myDog = new Dog();   // Memory Allocation & Variable Assignment (Object Creation)
        
        /* Example 2 */
        Dog myDog = new Dog();   // Simplified Object Creation
A reference variable in a method is a local variable on stack memory, so when the method is terminated its memory is retrieved and the variable is discarded. However, an instance allocated on heap memory is automatically collected by a garbage collector, if it is not used any longer.

## Object Usage
After the object creation, we can access member variables and call methods of the object by adding a punctuation mark, '.'.

        /* Syntax */
        <Reference-Variable>.<Method-Name>();
        <Reference-Variable>.<Member-Variable-Name>;
        
        /* Example */
        Dog myDog = new Dog();   // Object Creation
        myDog.bark();   // Call "bark()" method which myDog is referring to
        myDog.color = "white";   // Access a member variable "color" which myDog is referring to
        
## Java Files with Classes
There are two ways to construct .java files with multiple classes, when we write a Java program. It is good to follow these rules, even if [there are some tricks for naming](https://www.geeksforgeeks.org/myth-file-name-class-name-java/), since the file name tells Java Virtual Machine(JVM) that this is an entry point. 
1. All-in-One File: The name of the .java file = The name of the public class containing a main method.
2. One File Per Class: The name of each .java file = The name of the public class.

Usually, each compiled file produces a .class file which is a bytecode. (See the tricks for some exceptions) Moreover, whenever a class is loaded, it gets bytecode per method in the class. The Java bytecode is the bytecode-structed instruction set of the JVM, and it has a similar role to that of an assembler for C/C++. It is not processed by the processor, but by the JVM instead. This intermediate code is the keypoint to enable Java to get platform independence.
        
        Program (Source Code) ---> Compiler ---> Bytecode ---> JVM ---> Machine Code
        
## this
### this
*this* is used to refer an object itself of a class.

        /* Example */
        class Dog{
            String name;
            Dog(String name){ this.name = name; }   // "this.name" denotes its member variable, and "name" a parameter.
        }
The example class has "String name" as its field, and its constructor also has "String name" as its parameter. To clarify the representation of "name" member variable in the class, add *this*.

        return this;
The return statement will return the current object.

### this()
*this()* is the special method for a constructor, which calls another constructor. It is useful when the class is overloading the constructors. It should be called in the first line of the constructor.

        class Dog{
        public Dog(int n){...}   // Callee of the constructor below
        public Dog(String str){ this(Integer.parseInt(str)); ... }   // Calls the constructor. Dog(Integer.parseInt(str))
        }
## Method Parameter
All object variables in Java are references, so member variables in the object of class are allocated on heap memory, and they are referred by reference variable on the stack. Explanation on [Chapter 4](https://github.com/reruo321/Java_Practice/tree/main/Chapter-04#parameter-passing) would be helped to understand this, too. Looking at the main method in Example 03, you will notice that "int score" is a primitive, and "C05E03Person person" is a reference. This difference causes the "CallOne(score, person)" method to make no change in the former, whereas field values from the latter to be updated.
## Scope
The position of declaring a variable decides scope to use the value of it. Let us see Example 04.
C05E04Scope class has "int a" as a member variable. It can be accessed by all methods in the class.

Well, "int a" is initialized again as a local variable by a method oneMethod(), but the latter is unable to access from outside of the method. Because of this, the member variable is not affected by this method at all, since the local variable with the same name is initialized at the first line. When the method is over, the locals "int a" and "int b" are discarded.

Meanwhile, another method, twoMethod() takes 'a' from the member variable, and adds 1 to it. (Field 'a' was automatically initialized as 0 at the beginning.) This change is reflected to the member variable, so it still lasts after the method termination.

Example 05 is a variation of Example 03, and Ch05Ex05Global class has "static C05E03Person person", "static int score", CallOne(), and a main method as its members. The score variable now keeps its value despite the termination of CallOne(), unlike that of Example 03 version. There is no "global" variable in Java, but making use of *static* keyword allows us to utilize the similar concept.
