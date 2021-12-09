# Ch. 6 - Inheritance
Inheritance is one of the main characteristics of OOP, which enhances the reusability and extendability of the language. It allows a derived class to get its unique features, and to inherit attributes and behaviors (methods) from its base class at the same time. The classes with inheritance build a hierarchy.

## Types of Inheritance
1. Single Inheritance: The basic form of inheritance; a class extends another one class.
2. Multiple Inheritance: A class extending more than one base class, which should manage the dependency of its multiple classes. Most of the new object-oriented languages like Java and C# do not provide multiple inheritance, whereas C++ does.
3. Multilevel Inheritance: A class extending another one class is a parent of the other class.
4. Hierarchical Inheritance: A class having many children.
5. Hybrid Inheritance: Single + Multiple inheritance. Since multiple inheritance is not supported directly in Java, the hybrid can be done through interfaces only.

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

## Access Modifier
There are 4 kinds of access modifiers in Java: public, default, protected, and private. They can be attatched to a class, a member variable, a method, and an interface, and they limit the accessibility of things. If a programmer makes no mention of the modifier, it becomes *default*.

The access modifiers allow the range of the access like this:
1. private: Same Class
2. default: Same Class or Same Package
3. protected: Same Class or Same Package or SubClass (from different package)
4. public: All

Summary: private < default < protected < public

## Overriding
A subclass inherits the methods from its super. If a programmer adds the same method with different contents to the sub, *overriding* happens, which has polymorphism.

- Methods with *private*, *static*, *final* keywords cannot be overrided.
- If the super's method does not throw an exception, overriding one can throw an unchecked exception (unchecked exception: children of RuntimeException), but not checked ones.
- If the super's method declares an exception, overriding one can declare the same, subclass, or no exception, **but not** its parent.

--- Under Construction ---
