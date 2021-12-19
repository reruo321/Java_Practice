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

### Object
**Object** class is the root of the class hierarchy, so it is the superclass of all other classes in Java. toString() and equals() are the examples of Object methods.

### Class
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
| String toString() | Returns wrapper class type data as String. |
| @ @Value() | Returns wrapper class type data as primitive type @ data. |
| @ parse#(String s) | Returns String *s* as primitive type @ data. |
| @ parse#(String s, int r) | Returns String *s* as primitive type @ data as base r. |
| # valueOf(@ i) | Returns primitive type @ data *i* as wrapper class type #. |
| # valueOf(String s) | Returns String *s* as wrapper class type #. |

※ @ = Primitive Type, # = Wrapper Class Type

#### Member Fields
These two fields from wrapper classes are frequently utilized, which show the maximum or minimum value of each wrapper class.

| Member Field | Description |
| :----------: | :---------: |
| static final @ MAX_VALUE | Maximum data value of primitive type @. |
| static final @ MIN_VALUE | Minimum data value of primitive type @. |

#### Character
| Method | Description |
| :----------: | :---------: |
| Character(char value) | Constructor. |
| char charValue() | Casts Character type data to char type. |
| boolean isDefined(char ch) | Returns true if *ch* is a Unicode character. |
| boolean isDigit(char ch) | Returns true if *ch* is a digit. |
| boolean isLetter(char ch) | Returns true if *ch* is a letter. |
| boolean isLetterOrDigit(char ch) | Returns true if *ch* is a letter or a digit. |
| boolean isLowerCase(char ch) | Returns true if *ch* is a lowercase letter. |
| boolean isUpperCase(char ch) | Returns true if *ch* is a uppercase letter. |
| boolean isWhitespace(char ch) | Returns true if *ch* is a whitespace. |
| char toLowerCase(char ch) | Returns *ch* as a lowercase letter. |
| char toUpperCase(char ch) | Returns *ch* as a uppercase letter. |
| Character valueOf(char ch) | Returns *ch* as Character type data. |

#### Integer
| Method | Description |
| :----------: | :---------: |
| String toBinaryString(int i) | Returns *i* to base 2 String. |
| String toOctalString(int i) | Returns *i* to base 8 String. |
| String toString(int i) | Returns *i* to base 10 String. |
| String toString(int i, int r) | Returns *i* to base *r* String. |
| String toHexString(int i) | Returns *i* to base 16 String. |

#### Void
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
| char charAt(int index) | Returns a character at *index*. |
| int compareTo(String ss) | Compares the string of the object to *ss* lexicographically. (by ABC sequence) |
| int compareToIgnoreCase(String str) | Compares the string of the object to *str* lexicographically. Case-insensitive. |
| String concat(String str) | Concatenates the string of the object and *str*. |
| boolean equals(Object obj) | Compares if the String is equal to *obj*. |
| boolean equalsIgnoreCase(String str) | Compares if the String is equal to *str*. Case-insensitive. |
| String format(String fmt, Object... args) | Returns a formatted string, using the format *fmt* and object arguments. |
| int indexOf(int ch) | Finds the index of the first *ch* from the string. |
| int indexOf(String str) | Finds the index of the first *str* from the string. |
| boolean isEmpty() | Returns true if length() is 0. |
| int lastIndexOf(int ch) | Finds the index of the last *ch* from the string. |
| int length() | Returns the length of the string. |
| Strig replace(char oldChar, char newChar) | Replaces *oldChar* in the string to *newChar*. |
| String subString(int beginIndex) | Returns substring from *beginIndex* to end of the string. |
| String subString(int beginIndex, int endIndex) | Returns substring from *beginIndex* to *endIndex* of the string. |
| String toUpperCase() | Returns the uppercase version of the string. |
| String toLowerCase() | Returns the lowercase version of the string. |
| Strign trim() | Returns the string which any leading and trailing whitespace are removed. |

### StringBuffer
A thread-safe, mutable sequence of characters. It is similar to String, but StringBuffer allows to modify the string.

| Method | Description |
| :----------: | :---------: |
| StringBuffer append(String str) | Adds *str* at the end of the string. |
| char charAt(int index) | Returns a character at *index*. |
| StringBuffer delete(int start, int end) | Deletes the string from *start* to *end* index. |
| int indexOf(String str) | Finds the index of the first *str* from the string. |
| StringBuffer insert(int offset, String str) | Inserts *str* at *offset* of the string. |
| int length() | Returns the length of the string. |
| StringBuffer reverse() | Returns the reversed string. |
| int setLength(int newLength) | Sets *newLength* as the length of the string. |
| String subString(int start, int end) | Returns substring from *start* to *end* of the string. |
| String toString() | Returns the string as String type. |

### StringTokenizer
StringTokenizer is used to break a string into tokens by parsing. Should import the package java.util.

| Constructor | Description |
| :----------: | :---------: |
| StringTokenizer(String str) | Constructor for *str* which uses the default delimiter set. (" \t\n\r\f")
| StringTokenizer(String str, String delim) | Constructor for *str* which uses *delim* as delimiters.
| StringTokenizer(String str, String delim, boolean returnDelims) | Constructor for *str* which uses *delim* as delimiters. If the *returnDelims* flag is true, the delimiters are also returned as tokens. Otherwise, they are skipped.

| Method | Description |
| :----------: | :---------: |
| int countTokens() | Returns the number of times that this tokenizer's nextToken method can be called. |
| boolean hasMoreTokens() | Returns true if there is more available token after the current position. |
| String nextToken() | Returns the next parsed string. |

### Random
Import java.util package and use Random class to generate random numbers.

| Method | Description |
| :----------: | :---------: |
| int nextInt() | Returns random integer. |
| int nextInt(int n) | Returns random integer which is 0 <= X < n. |
| long nextLong() | Returns random long integer. |
| float nextFloat() | Returns random float which is 0.0 <= X < 1.0. |
| double nextDouble() | Returns random double which is 0.0 <= X < 1.0. |
| void setSeed(long seed) | Set *seed* as a seed. |

### Math
Math is a public and final class, providing various mathematical functions and constants. Since all fields and methods are static, they can be directly called by the class name, Math.

| Field | Description |
| :----------: | :---------: |
| double E | 2.7182... |
| double PI | 3.14159... |

| Method | Description |
| :----------: | :---------: |
| \<T\> abs(T value) | Returns the absolute value of the T-type *value*. |
| double ceil(double a) | Returns the smallest integer as double type, which is *a* <= X. (Ex: Math.ceil(10.123) = 11.0) |
| double cos(double a) | Returns the cosine value of *a*. |
| double floor(double a) | Returns the biggest integer as double type, which is *a* >= X. (Ex: Math.floor(10.123) = 10.0) |
| double log(double a) | Returns logarithm value of *a*. |
| \<T\> max(T a, T b) | Returns the bigger value between *a* and *b*. |
| \<T\> min(T a, T b) | Returns the smaller value between *a* and *b*. |
| double pow(double a, double b) | Returns the value of *a* to the power of *b*. |
| double random() | Returns the random number which is 0.0 <= X < 1.0. |
| double rint(double a) | Returns the value rounding *a* to the nearest integer as a double. |
| double sin(double a) | Returns the sine value of *a*. |
| double sqrt(double a) | Returns the square root value of *a*. |
| double tan(double a) | Returns the tangent value of *a*. |

## Collection
To more accessible data structures, Java provides **Collection Framework** as a bunch of groups of various interfaces and classes.

Interfaces are largely categorized as Collection and Map. Collection has Set, List, Queue, and other subinterfaces, and Map does mainly maps such as Hashtable and ConcurrentMap.

### Collection
Collection interface is the root in the collection hierarchy.

| Method | Description |
| :----------: | :---------: |
| boolean add(E e) | Adds an element *e*. Returns true if the collection was updated successfully.
| void clear() | Clears all elements. |
| boolean equals(Object o) | Returns true if all elements are equal to those of *o*. |
| boolean isEmpty() | Returns true if the collection is empty. |
| boolean remove(Object o) | Removes an element *o*. Returns true if the collection was updated successfully. |
| int size() | Returns the number of the elements. |
| Object [] toArray() | Returns the elements as an array. |

※ E: The type of elements in this collection

#### Set
Set is an interface that represents the set of not duplicated elements. It has SortedSet as a subinterface for organized set elements.

#### List
List makes a group for elements with sequence.

#### Queue
Queue allows an access for elements at both ends of the group.

#### Map
Map represents a group which consists of its key and mapping information.

### Vector
Vector class is similar to array. While array has fixed size, Vector can increase or decrease its size dynamically as necessary. It is able to utilize all methods that List interface has, since it implemented List. It allows its elements to be duplicated, and to be accessed by their index values.

| Method | Description |
| :----------: | :---------: |
| Vector() | Constructor. |
| Vector(int initialCapacity) | Constructor with the initial size of vector, *initialCapacity*. |
| Vector(int initialCap, int capInc) | Constructor with the initial size of vector, *initialCap*, automatically increasing its size by *capInc*. |
| boolean add(E e) | Adds an element *e* to the Vector. |
| void add(int index, E element) | Adds an element *element* at *index*.
| void addElement(E obj) | Adds an element *obj* to the Vector. |
| void clear() | Clears all elements in the Vector. |
| boolean contains(Object o) | Returns true if the Vector includes the object *o*. |
| E elementAt(int index) | Returns an element at *index*. |
| boolean equals(Object o) | Returns true if the Vector is equal to the object *o*. |
| E firstElement() | Returns the first element of the Vector. |
| E get(int index) | Returns the *index*-th element of the Vector. |
| int indexOf(Object o) | Returns the index of the object *o*. |
| void insertElementAt(E obj, int index) | Inserts the element *obj* at *index*. |
| boolean isEmpty() | Returns true if the Vector is empty. |
| E remove(int index) | Removes the element at *index*. |
| void removeAllElements() | Removes all elements in the Vector. |
| void setElementAt(E obj, int index) | Changes the element at *index* to *obj*. |
| int size() | Returns the size of the Vector. |
| void setSize(int newSize) | Set the size of the Vector to *newSize*. |
| Object [] toArray() | Returns an array having the Vector's elements. |
| String toString() | Casts the elements to String. |

### Iterator
Use Iterator interface to get collection elements in a sequence. Iterator is defined in Collection, and calling a method iterator() will bring it.

        Vector v = new Vector();   // 1. Find a Collection to use Iterator.
        Iterator it = v.iterator();   // 2. Call iterator() for it, and create a reference.
        it.hasNext();   // 3. Process with Iterator methods.
        it.next();
        
### List
List interface allows duplicate its elements, and it has sequence for data group. It has ArrayList and LinkedList as implementing classes.

#### ArrayList
ArrayList is almost similar to Vector, except that it is unsynchronized.

#### LinkedList
LinkedList is a doubly-linked list implementation. To get its elements, call listIterator() from List to take bidirectional iterator. Then, call hasNext() and next() for forward traversal. For backward traversal, put size() as an argument for listIterator(), and call hasPrevious() and previous().

### Stack
Stack class represents a Last-In-First-Out(LIFO) stack of objects.

| Method | Description |
| :----------: | :---------: |
| Stack() | Constructor. |
| boolean empty() | Returns true if the Stack is empty. |
| E peek() | Examines the top item of the Stack, without removing it. |
| E pop() | Retrieves and removes the top item of the Stack. |
| E push(E item) | Adds *item* at the top of the Stack. |

### Queue
Queue interface is designed to order elements typically in a First-In-First-Out(FIFO) manner.
It can remove its head by calling remove() or poll(). If it is a FIFO Queue, it inserts all new element at the tail of it.

※ There are methods resemble each other, and their only difference is the output if the operations fail. Some of them throw an exception, and others return a special value. (either null or false)

| | Throws exception | Returns special value |
|:-:| :----------: | :---------: |
| **Insert** | add(e) | offer(e) |
| **Remove** | remove() | poll() |
| **Examine** | element() | peek() |

| Method | Description |
| :----------: | :---------: |
| boolean add(E e) | Adds an element *e* to the Queue. |
| E element() | Examines at the head of the Queue. |
| boolean offer(E e) | Adds an element *e* to the Queue. Returns false if fails. |
| E peek() | Examines at the head of the Queue. Returns null if the Queue is empty. |
| E poll() | Retrieves and removes the head of the Queue. Returns null if the Queue is empty. |
| E remove() | Retrieves and removes the head of the Queue. |

### Hashtable
Hashtable class implements Map interface, which maps keys to values, and uses a hash code for the key.

| Method | Description |
| :----------: | :---------: |
| Hashtable() | Constructor. |
| Hashtable(int initialCapacity) | Constructor with *initialCapacity* as initial capacity. |
| V get(Object key) | Returns the value to which the specified *key* is mapped. |
| V put(K key, V value) | Maps the specified *key* to the specified *value* in the Hashtable. |
| V remove(Object key) | Removes the value to which the specified *key* is mapped. |
| int size() | Returns the number of the keys in the Hashtable. |

## Generic & enum
### Generic Programming
Generic programming is embodied by generic types and generic methods, which are similar to template and STL in C++. Generics are easier to reduce possible casting errors in execution than templates of C++, by checking data types while compiling.

Moreover, Generics take just one compiled code, while the templates spout out several codes according to the using data.

#### Generic Collection Class
Most of the collection classes explained above are able to be utilized on generic programming. For example, generic Vector is defined with formal parameter type, \<E\>, like this:
    
        class Vector<E>
        {
            boolean add(E e){ ... }
            E get(int index){ ... }
        }
    
To use generic Vector, declare the reference of parameterized type.
    
        Vector<TYPE> var = new Vector<TYPE>();

Generic List and generic Iterator look like this:
    
        Interface List<E>
        Interface Iterator<E>
    
And you can use them like below:
    
        List<Integer> li = new Vector<Integer>();
        li.add(100);
        li.add(50);
        Iterator<Integer> it = li.iterator();
        while(it.hasNext())
            System.out.print(it.next() + " ");
    
#### Generics and Inheritance
Suppose that a class Rectangle is derived from Shape. This example shows how to use these classes as parameterized types in generic programming.

        Rectangle rc = new Rectangle();
        Shape sh = rc;
        Vector<Rectangle> vrc = new Vector<Rectangle>();
        // Vector<Shape> vsh = new vrc;   // Compile Error!

Generics does not allow the last code where a parameterized superclass type reference tries to refer that of subclass, since only the reference of the equivalent type is okay.
To be free from this restriction, use wild card.

        Vector<Rectangle> vrc = new Vetor<Rectangle>();
        Vector<? extends Shape> vsh = vrc;
        
#### Generic Class Definition
