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
After the object creation, we can access member variables and call methods of the object by adding punctuation mark, '.'.

        /* Syntax */
        <Reference-Variable>.<Method-Name>();
        <Reference-Variable>.<Member-Variable-Name>;
        
        /* Example */
        Dog myDog = new Dog();   // Object Creation
        myDog.bark();   // Call "bark()" method where myDog is referring
        myDog.color = "white";   // Access a member variable "color" where myDog is referring
        
