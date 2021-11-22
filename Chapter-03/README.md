# Ch. 3 - Basics of Java Language
In this chapter, you can learn the basics of Java language. It resembles the ones from C++.

## Ex. 01 - Data Type Variable
### Data Types
See details on [Java Language Specification](https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-ClassOrInterfaceType), and an official tutorial on [The Java Tutorials](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html).

                                                            ┌ byte  (8-bit, signed)
                       ┌ boolean (1-bit)                    ├ short (16-bit, signed)
    1. Primitive Type -│                 ┌ Integral Type ---├ int   (32-bit, signed)
                       │                 │                  ├ long  (64-bit, signed)
                       └ Numeric Type ---│                  └ char  (16-bit, unsigned, UTF-16)
                                         │
                                         └ Floating Point Type -┬ float  (32-bit, single-precision)
                                                                └ double (64-bit, double-precision)
                       ┌ Class Type
    2. Reference Type -├ Interface
                       └ Array Type
                      
    3. null Type
Let us check the primitive type here, and the others later on Chapter 4 and Chapter 7.
#### Primitive Type
Primitive type is predefined by the language and is named by a reserved keyword. As the Java programming language is statically-typed, all variables must first be declared before they can be used. The field variables will be assigned to a default value by the compiler, depending on their data types. However, local one must be initialized (assign it a value) before use, or it will cause the error. It is good to get into the routine of assigning value to the declared variables to avoid the trouble.
##### Integral Type
1) byte: 8-bit signed two's complement integer. -128 ~ 127. Default value: 0.
2) short: 16-bit signed two's complement integer. -32,768~ 32,767. Default value: 0.
3) int: 32-bit signed two's complement integer. -2^31 ~ 2^31 - 1 (signed) or 0 ~ 2^32 - 1 (unsigned). Default value: 0.
4) long: 64-bit signed two's complement integer. -2^63 ~ 2^63 - 1 (signed) or 0 ~ 2^64 - 1 (unsigned). Default value: 0.
5) char: 16-bit unsigned single 16-bit Unicode character. '\u0000' (0) ~ '\uffff' (65,535). Default value: '\u0000' (or null)
##### Floating Point Type
1) float: single-precision 32-bit IEEE 754 floating point. Default value: 0.0.
2) double: double-precision 64-bit IEEE 754 floating point. Default value: 0.0.
##### boolean
1) boolean: represents 1-bit of information that has only two possible values: true or false. Default value: false.
### Literal
Literal is the stationary data having a fixed value. Because of its primitive nature, computation does not need for the literal to be represented.
#### 1. Integer Literal
An integer literal is the number not containing floating point, and it can be expressed in the decimal, hexadecimal, octal, and binary system. Add '0x', '0', and '0b' for hexadecimal, octal, and binary.

    int decVal = 91;   // 91 in decimal
    int hexaVal = 0xABC;   // 2748 in decimal
    int octalVal = 0144;   // 100 in deciaml
    int binVal = 0b1010110;   // 86 in decimal
If you want to represent a long-type literal instead of int, put the letter 'L' or 'l' behind it. (Using 'l' will be puzzling so 'L' is more recommended.)

    long longVal = 1234L;   // L can be omitted from this line
    System.out.println(1234L);   // Output will be: 1234
#### 2. Floating-Point Literal
A floating-point literal is the real-number literal that has a floating-point. Float-type literal ends with the letter 'F' or 'f', and double-type with 'D' or 'd' or without any letters. If you add 'E' or 'e' to the literal, it turns into an exponential expression for scientific notation.

    float f1 = 888.8F;   // !!! F can't be omitted !!!
    double d1 = 123.4D;   // D can be left out
    double d2 = 123.456;
    float f2 = 1234.5678E2F   // 123456.78
    double d3 = 12345.67891-E3;   // 12.34567891
    
#### 3. Character Literal & String Literal
※ Understanding some explanation of string literal may need knowledge from later chapters, so take it easy.

Character literal in Java can contain ASCII code, and even Unicode (UTF-16) characters. A Java programmer is allowed to use Unicode characters directly, or utilize "Unicode escape ('\u')" if the editor and file system do not permit it. Use single quotes for char literals like below.

    char hangul = '한'; // A direct Unicode character.
    char hangul_u = '\ud55c'; // An indirect Unicode character for the upper Korean character, '한'.
String literal is implemented as instance of the [String class](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html).
Since String is constant and its objects are immutable, they can be shared. (String buffers support mutable strings.) Use double quotes for string literal.

    String korean = "한글"; // A String with direct Unicode characters.
    String korean_u = "\ud55c\uae00"; // A String with indirect Unicode characters, meaning "한글".
    String hello = "Hello, World!";

Java supports not only Unicode escape sequences, but also some special escape sequences for both char and String literals.
I filed this from [Chapter 2](https://github.com/reruo321/Java_Practice/tree/main/Chapter-02).

#### 4. Miscellaneous
1. null Literal: null literal is often used as a marker to unavailable objects. It can be used as a value for any reference type, and it may also be assigned to any variable, except variables of primitive types.
2. Class Literal: Clas literal refers to the object (of type Class) that represents the type itself. It takes its form as "<CLASS_TYPE>.class", and for example, "String.class" is the class literal for the "String" class.

In Java SE 7 and later, to make the programmers easy to read their digits while programming, it allows to put underscore characters between digits in a numerical literal, as many as they want to.

    int underVal = 1_2_3_4_5_6_7_8;   // 12345678
    float pi = 3.14_15F;   // 3.1415
    long hexVal = 0xABCD_EF01;   // 0xABCDFE01
    byte binVal = 0b0100_1101;   // 01001101
    
## Ex. 02 - AssignOp
Operators in Java operate arithmetic on various data types, and they consider precedence (priority) and associativity. (direction of calculation) I will mainly check some new operators peculiar to Java.
### 1. Assignment Operator
Assignment operator saves a value to the declared variable, and it uses the character '='. It operates from right to left.

    int x, y;
    x = y = 10;   // y = 10, then x = y.
    x = 1;   // x = 1, y = 10.
## Ex. 03 - Increment
### 2. Increment & Decrement Operator
