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

### 3. Anonymous Inner Class
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

## Well-Known Classes
J2SDK in Java provides a lot of classes, and here are descriptions for some import classes.
These are almost in package "java.lang" or "java.util".

### Object Class
**Object** class is the root of the class hierarchy, so it is the superclass of all other classes in Java. toString() and equals() are the examples of Object methods.

### Class Class
Instances of the class Class represent classes and interfaces in a running Java application. Class objects are automatically constructed by JVM, and they cannot be extended since it is a final. They contain the metadata (name, constructor, field, method) of other classes and interfaces.

### Wrapper Class
Each primitive data type has its wrapper class.
| Primitive Data Type | Wrapper Class |
| :-----------------: | :-----------: |
| boolean | Boolean|
| byte | Byte |
| char | Character |
| short | Short |
| int | Integer |
| long | Long |
| float | Float |
| double | Double |
| void | Void |

#### Instance Creation
Call a constructor of wrapper class via *new* keyword, with primitive data type variables or constants as its arguments.

        new <WrapperClass-Name>(<Primitive-DataType-Value>);
        new <WrapperClass-Name>(<String-Type-Value>);
        
        (Example)
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");
        
        String s = "123";
        Integer i = new Integer(s);
        
#### Utility Methods
Here are some often used utility methods for common wrapper classes.

| Method | Description |
| :----: | :---------: |
| String toString() | Returns wrapper class type data to String. |
| @ @Value() | Returns wrapper class type data to primitive type @ data. |
| @ parse#(String s) | Returns String s to primitive type @ data. |
| @ parse#(String s, int r) | Returns String s to primitive type @ data as base r. |
| # valueOf(@ i) | Returns primitive type @ data i to wrapper class type #. |
| # valueOf(String s) | Returns String s to wrapper class type #. |

(@ = Primitive Type, # = Wrapper Class Type)

#### Member Fields
These two fields from wrapper classes are frequently utilized, which show the maximum or minimum value of each wrapper class.

| Member Field | Description |
| :----------: | :---------: |
| static final @ MAX_VALUE | Maximum data value of primitive type @. |
| static final @ MIN_VALUE | Minimum data value of primitive type @. |

#### Character Class
| Method | Description |
| :----------: | :---------: |
| Character(char value) | Constructor. |
| char charValue() | Casts Character type data to char type. |
| boolean isDefined(char ch) | Returns true if ch is a Unicode character. |
| boolean isDigit(char ch) | Returns true if ch is a digit. |
| boolean isLetter(char ch) | Returns true if ch is a letter. |
| boolean isLetterOrDigit(char ch) | Returns true if ch is a letter or a digit. |
| boolean isLowerCase(char ch) | Returns true if ch is a lowercase letter. |
| boolean isUpperCase(char ch) | Returns true if ch is a uppercase letter. |
| boolean isWhitespace(char ch) | Returns true if ch is a whitespace. |
| char toLowerCase(char ch) | Returns ch to a lowercase letter. |
| char toUpperCase(char ch) | Returns ch to a uppercase letter. |
| Character valueOf(char ch) | Returns ch to Character type data. |

#### Integer Class
| Method | Description |
| :----------: | :---------: |
| String toBinaryString(int i) | Returns i to base 2 String. |
| String toOctalString(int i) | Returns i to base 8 String. |
| String toString(int i) | Returns i to base 10 String. |
| String toString(int i, int r) | Returns i to base r String. |
| String toHexString(int i) | Returns i to base 16 String. |

#### Void Class
Void is a wrapper class for void type, which cannot create an object.

#### Auto-Boxing
An automatical cast from a primitive type to a wrapper class type is called "auto-boxing", and "auto-unboxing" vice versa.

        int a = 10;
        Integer b = new Integer(3);
        a = a * b;   // auto-unboxing of b;
        b = a;   // auto-boxing of a;
        
### String
String class has a character sequence as a value, and it is able to create an instance, call a method, and process various strings.

| Method | Description |
| :----------: | :---------: |
| char charAt(int index) | Returns a character at index. |
| int compareTo(String ss) | Compares the string of the object to ss lexicographically. (by ABC sequence) |
| int compareToIgnoreCase(String str) | Compares the string of the object to str lexicographically. Case-insensitive. |
| String concat(String str) | Concatenates the string of the object and str. |
| boolean equals(Object obj) | Compares if the String is equal to obj. |
| boolean equalsIgnoreCase(String str) | Compares if the String is equal to obj. Case-insensitive. |
| String format(String fmt, Object... args) | Returns a formatted string, using the format and object arguments. |
| int indexOf(int ch) | Finds the index of the first ch from the string. |
| int indexOf(String str) | Finds the index of the first str from the string. |
| boolean isEmpty() | Returns true if length() is 0. |
| int lastIndexOf(int ch) | Finds the index of the last ch from the string. |
| int length() | Returns the length of the string. |
| Strig replace(char oldChar, char newChar) | Replaces oldChar in the string to newChar. |
| String subString(int beginIndex) | Returns substring from beginIndex to end of the string. |
| String subString(int beginIndex, int endIndex) | Returns substring from beginIndex to endIndex of the string. |
| String toUpperCase() | Returns the uppercase version of the string. |
| String toLowerCase() | Returns the lowercase version of the string. |
| Strign trim() | Returns the string which any leading and trailing whitespace are removed. |

### StringBuffer
A thread-safe, mutable sequence of characters. It is similar to String, but StringBuffer allows to modify the string.
