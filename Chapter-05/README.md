# Ch. 5 - Class and Object
Java is an Object-Oriented Programming language. It can reuse its codes, and it has good modularity, flexibility, maintenance, cost cutting, and troubleshooting. There are four main characteristics of Object-Oriented Progamming.
1. Abstraction: Outlines general traits of several objects. For example, three objects "dog", "cat", and "pig" are the animals having their ears and legs. They can also sleep, eat, and cry.
2. Encapsulation: Data and operators encapsulated by class units can be either public or private.
3. Inheritance: Subclass (child) can be derived from superclass(parent), getting its features. Details are on Chapter 6.
4. Polymorphism: Multiple forms are allowed for an interface, or a method.

A class is a user-defined data type to give shape to objects, as if it is a frame to produce them.
## Class Definition
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
#### Constructor Definition
    <Access-Modifier> <Class-Name>(<Type-Parameter>){...}
    
    ※ Access-Modifier can be omitted.
A class and its constructor share the same name, and the constructor can have its parameters. Do not add *void* in front of the constructor, although it does not return anything. It can be called via *new* keyword, and it is used to initialize fields(member variables). Overloading the constructors is allowed like other methods, so the class may have several constructors.

A default constructor is the constructor taking no arguments, and it is automatically generated and called unless its class has any other user-defined constructors. It sets fields to their default values. (For example, an int member variable will set to 0, and a String one to null.) However, once a user adds a constructor, no default constructor is provided.

    /* NoDefault.java */
    public class NoDefault{
      int a;
      // NoDefault(){ a = 0; }   // Should be added, or an error will happen.
      NoDefault(int x){
        a = x;
      }
    }
    
    /* NoDefaultError.java */
    public class NoDefaultError {
      public static void main(String [] args){
        NoDefault no = new NoDefault();
      }
    }
When you define some constructors, be careful not to forget to add a constructor that has no parameters, since the default one is not generated in the case.
