# Ch. 6 - Inheritance
Inheritance is one of the main characteristics of OOP, which enhances the reusability and extendability of the language. It allows a derived class to get its unique features, and to inherit attributes and behaviors (methods) from its base class at the same time. The classes with inheritance build a hierarchy.

## Syntax
    (For a Subclass)
    <Access-Modifier> class <Class-Name> extends <SuperClass-Name>
    {
      ...
    }
A class is defined as a subclass when the keyword *extends* gets stuck on it. Write the name of the subclass in front of the *extends*, and of the superclass behind it.

Subclass inherits the fields and methods of the superclass, but not its constructor. Therefore, 




1. Single Inheritance: The basic form of inheritance; a class extends another one class.
2. Multiple Inheritance: A class extending more than one base class, which should manage the dependency of its multiple classes. Most of the new object-oriented languages like Java and C# do not provide multiple inheritance, whereas C++ does.
3. Multilevel Inheritance: A class extending another one class is a parent of the other class.
4. Hierarchical Inheritance: A class having many children.
5. Hybrid Inheritance: Single + Multiple inheritance. Since multiple inheritance is not supported directly in Java, the hybrid can be done through interfaces only.

--- Under Construction ---
