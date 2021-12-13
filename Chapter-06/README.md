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

## Overshadow
If a subclass declares a variable sharing the same name with the super's field, it says the variable of the super becomes *overshadow*ed. The original super one is not disappeared, but it takes some special ways to refer it from the subclass.

### How to Refer the Overshadowed Field
1. Assign instances to the superclass-type references. (Ex: **Super** super = new Sub();)
2. Use *super* reference keyword.
3. Cast subclass-type reference to the superclass-type, then refer it. This type of casting is called "implicit casting", or "upcasting". The instance variable follows the class-type of the reference. (Ex: ((Super)sub).field)

## Casting
Casting, or type conversion has two types: implicit (automatic, widening), and explicit (narrowing) casting.

The former automatically converts narrower data type to broader one. For example, converting Ronaldo to a Football player is okay. However, the inverse case, which tries to make a Football player to Ronaldo, is not allowed.

## Keywords
### static
*static* keyword can be glued to a method or a variable. A *static* method is able to be called without making its instance. It also allows several intances to share the memory, so that the *static* member variables can be used as if they are global.

- static method cannot use *this* reference.
- static method cannot be overriden by a normal method.
- Only static variables are allowed in the static method.
- static method can call only other static methods in the same class.

The static method is always resolved at compile time, but overriding is done at runtime. (Compile is faster.) Thus, **the static method is not overriden**, but it would rather overshadow a method with the same name in the derived class.

### final
*final* keyword prevents a class to have any children, a method to be overriden, and a variable to be changed. (The last one is the same as *const* in C/C++.) If the variable refers an instance, it cannot point to other reference, but the instance values of its reference can be changed. *final* and *abstract* cannot be together because they are mutually exclusive concepts.

        final Animal a = new Animal();
        a.setName("Poodle");   // Changing an instance value. Okay.

### Others
#### volatile
*volatile* keyword is one of the ways to control memory order, which only gets along with a variable, but not with a class, a method, or *final* keyword. All volatile variables, also known as "memory variables", are read and written by main memory directly. It may be edited by interrupts.
#### native
*native* can be used on method, and it indicates that the method is implemented in native code using JNI(Java Native Interface).
#### transient
*transient* is used to make a variable not to be serialized.
#### synchronized
*synchronized* marks a variable or a method, to lock an object in multiple threads, to synchronize its access. It ensures that the object is modified by only one thread at a time.

--- Under Construction ---
