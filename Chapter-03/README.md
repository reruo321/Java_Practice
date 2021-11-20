# Ch. 3 - Basics of JAVA Language
In this chapter, you can learn the basics of JAVA language. It is pretty much the same as C++.

## Ex. 01 - Data Type Variable
### Data Types
See details on [JAVA Language Specification](https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-ClassOrInterfaceType).

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
Let us check the primitive type here, and then others on Chapter 4 and Chapter 7.
#### Primitive Type
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
#### 1. Integer Literal
