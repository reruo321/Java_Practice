# Simple Calculator

The problem requires to make a calculator using Swing.

## Program Explanation
![10Calculator](https://user-images.githubusercontent.com/48712088/149197908-4ec9d294-2554-4cac-9d54-76d5e9768178.png)

This is the calculator whose UI resembles the program from old Windows, but miscellaneous controls try to imitate that of Windows 10.

### Number
All numbers for calculation are **BigDecimal**, and the displayed one on the text field has maximum 16 as scale. Scale is the number of the digits to the right of the decimal point of BigDecimal. For example, the scale of a BigDecimal "12.345" would be 3, and "3.00000" would be 5.

The problem of using float or double is that they make loss of precision while handling very big or very small numbers. For example, if we continuously add double 0.1,

    0.1
    0.2
    0.30000000000000004
    0.4
    0.5
    0.6
    0.7
    0.7999999999999999
    0.8999999999999999
    ...
    
The results have a bit of errors. Therefore to get exact real numbers, BigDecimal is more recommended than binary floats. (Especially important on bank business with many big transactions.) It is immutable, arbitrary-precision signed decimal number consists of an arbitrary precision integer *unscaled value* and a 32-bit integer *scale*.

So to speak, the number 12.345 will have unscaled_value=12345 and scale=3.

    BigDecimal big = new BigDecimal("12.345");
    System.out.println("Unscaled Value: " + big.unscaledValue() + ", Scale: " + big.scale());
    
BigDecimal will give the numbers as much precision as possible, so double represented as a String is preferable to double itself as a parameter. (It will say "Unpredictable 'new BigDecimal()' call" warning to double type parameter, and the constructor will lose the precision benefit.)

