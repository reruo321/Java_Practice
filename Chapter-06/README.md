# Ch. 6 - Inheritance
Inheritance is one of the main characteristics of OOP, which enhances the reusability and extendability of the language. It allows a derived class to get its unique features, and to inherit attributes and behaviors (methods) from its base class at the same time. The classes with inheritance build a hierarchy.

## Syntax
    (For a Subclass)
    <Access-Modifier> class <Class-Name> extends <SuperClass-Name>
    {
      ...
    }
A class is defined as a subclass when the keyword *extends* gets stuck on it. Write the name of the subclass in front of the *extends*, and of the superclass behind it.

Subclass inherits the fields and methods of the superclass, but not its constructor. Therefore, a programmer may need to write a new constructor for the subclass.

## Constructor
If the superclass has no user-defined constructor itself OR has a user-defined contructor with no parameter, its subclass is able to do so, too. However, if the super has the constructor with any parameters, the subclass constructor **MUST** be defined, and the sub-constructor should call super-constructor.

## Super Reference
### super
        (Syntax)
        super.<Member-Variable>;
        super.<Method-Name>(<Arguments>);
        
        /* Example */
        super.x = a;
        super.setX(int a);
Use *super* to refer superclass from the subclass, calling its fields or methods.

### super()
        (Syntax)
        super(<SuperClass-Constructor-Arguments>);

        /* Example */
        super(a, b);
*super()* is the method to call superclass constructor from the sub-constructor.

## Type of Inheritance
1. Single Inheritance: The basic form of inheritance; a class extends another one class.
2. Multiple Inheritance: A class extending more than one base class, which should manage the dependency of its multiple classes. Most of the new object-oriented languages like Java and C# do not provide multiple inheritance, whereas C++ does.
3. Multilevel Inheritance: A class extending another one class is a parent of the other class.
4. Hierarchical Inheritance: A class having many children.
5. Hybrid Inheritance: Single + Multiple inheritance. Since multiple inheritance is not supported directly in Java, the hybrid can be done through interfaces only.

--- Under Construction ---
