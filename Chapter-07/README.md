# Ch. 7 - Abstract Class & Interface
## Abstract Class
Abstract class provides general attributes and behaviors without implementation,
and it also provides accessible methods and variables as class contract. It cannot have an instance (substance),
but instead its subclasses can be concrete its concept by overriding methods of their super.
### abstract
To make an abstract class or method, add *abstract* keyword in front of them.
A class automatically becomes abstract if it has any abstract methods, so *abstract* keyword for the class can be omitted.

Abstract methods cause error when they is not implemented. However, an abstract class cannot make any instances.
Therefore, its subclasses should override all of them, and embody their methods.

## Interface
Interface is a special form of the abstract class, and it cannot have normal methods or variables. (Unlike abstract class.)
It contains only description of the methods, so any classes can borrow the interface, even if there are no relationships among the classes.
Java does not support multiple inheritance through class like C++, but it does via interface.

What methods in the interface have is just a method header without a body, so all of them MUST be embodied.
Override all empty methods of the interface with ones in the derived classes.

### Syntax
Interface in Java SE 8 is *abstract*, and its access modifier is always *public*. Moreover, its methods are also public, even if you do not declare the modifiers. They can be "public abstract", "public default", and "public static". You can declare an interface like this:

    <Access-Modifier> interface <Interface-Name> (<extends> <Super-Interface-Name>)
    {...}
    
    ※ "<extends> <Super-Interface-Name>" can be omitted.

You can implement the interface like:

    <Access-Modifier> class <Class-Name> (<extends> <SuperClass-Name>) implements <Interface-Name-1>(, <Interface-Name-2>, ...)
    {...Overriding Methods...}

- Interface is always *public* and *abstract*.
- Interface methods can be ***public abstract***, *public default*, and *public static*. (If omitted, *public abstract* is automatically attached by a compiler.)
- *default* methods inside interface provide the new functions with backward compatibility, without having to refactor the old implementations. They need their bodies to be declared.
- *static* methods inside interface are similar to those of their class versions. They should have their bodies, too.
- Constants can be declared inside interface, and they become *public static final*. (Can omit it.)

※ Note: Since Java 9, you can also add *private* methods and *private static* methods in interface.
- They cannot be abstract, and only available inside interface.
- Private static method can be used inside other static and non-static interface methods
- Private non-static one cannot be used inside private static methods.
- Both of them are not inherited by sub-interfaces or implementations, so that it enhances encapsulation.

### Comparison
|   | Abstract Class | Interface |
|:-:|:--------------:|:---------:|
| **Inheritance** | single | multiple |
| **Method** | abstract + normal | abstract + some normal |
| **Implementation** | make some abstract methods to be implemented | all abstract methods should be implemented |
| **Variable** | normal | final static (constant) |
| **Object Creation** | No | No |
| **Syntax** | extends | implements |

## Inner Class
Inner class is a class inside another class.
### 1. Member Inner Class
        <Access-Modifier> class <OuterClass-Name>
        {
            <Access-Modifier> class <InnerClass-Name>{
                ...
            }
        }
        
        (Example)
        class Outer{
            private int a = 10;
            class Inner{
                void msg(){ System.out.println(a); }
            }
        
        public static void main(String [] args){
                Outer outer = new Outer();
                Outer.Inner inner = new Inner();
                inner.msg();
            }
        }
        
Member inner class is a non-static class used as a variable or a method of the outer class.
Create an instance for outer first, then for inner. This allows you to access methods of the inner class.

### 2. Local Inner Class
        <Access-Modifier> class <OuterClass-Name>
        {
            <Access-Modifier> <Return-Type> <Method-Name>(<Parameters>)
            {
                class <InnerClass-Name>{
                    ...
                }
            }
        }
Local inner class is inside a method block, and accessible scope is restricted as if it is a local variable. It does not have an access modifier or any other keyword, so if it tries to access variables outside, they should be *final*.

### Anonymous Inner Class
        new <Class-To-Make-An-Instance-Name>(<Parameters>)
        {
            ...
        };
        
        (Example)
        abstract class Person{
            abstract void eat();
        }
        
        class TestInner{
            public static void main(String [] args){
                Person p = new Person(){
                    void eat(){ System.out.println("Yum Yum!"); }
                }
                p.eat();
            }
        }
Anonymous inner class has no name, and it is for creating a single object. When the program is compiled, a compiler generates its name and its concrete version automatically.

        (Internal Class Generated by the Compiler)
        import java.io.PrintStream;
        static class TestInner$1 extends Person
        {
            TestInner$1(){}
            void eat()
            {
                System.out.println("Yum Yum!");
            }
        }
### 4. Static Inner Class
Put *static* in front of a class to define a static inner class. Even if there is no instance of outer class, the instance of inner can be created. To allow an access from the inner, outer fields should be also *static*.
