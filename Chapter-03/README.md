# Ch. 3 - Basics of Java Language
In this chapter, you can learn the basics of JAVA language. It resembles the ones from C++.

## Ex. 01 - Data Type Variable
### Data Types
See details on [Java Language Specification](https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-ClassOrInterfaceType).

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
※ Understanding explanation of string literal may need knowledge from later chapters. Check it later if you feel this hard.

Character literal in Java can contain ASCII code, and even Unicode (UTF-16) characters. A Java programmer is allowed to use Unicode characters directly, or utilize "Unicode escape ('\u')" if the editor and file system do not permit it. Use single quotes for char literals like below.

    char hangul = '한'; // A direct Unicode character.
    char hangul_u = '\ud55c'; // An indirect Unicode character for the upper Korean character, '한'.
String literal is implemented as instance of the [String class](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html).
Since String is constant and its objects are immutable, they can be shared. (String buffers support mutable strings.) Use double quotes for string literal.

    String korean = "한글"; // A String with direct Unicode characters.
    String korean_u = "\ud55c\uae00"; // A String with indirect Unicode characters.
    String hello = "Hello, World!";

