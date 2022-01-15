# Simple Calculator

The problem requires to make a calculator using Swing.

## Program Explanation
![10Calculator](https://user-images.githubusercontent.com/48712088/149622049-a3973576-6581-4ea0-9d57-2be17b1a4cc9.png)

This is the Swing calculator whose UI resembles the program from old Windows, but miscellaneous controls try to imitate those of Windows 10.

### UI
![10CalculatorUI](https://user-images.githubusercontent.com/48712088/149622100-129da028-33f3-4185-a1b6-323b07d4d6de.png)

#### JButtons
There are four JButton arrays to group a lot of JButtons by their functions and positions: b_func, b_mem, b_num, and b_arith. Additionally an unclickable JButton *blank* to show the status of the memory exists, which is not an element of any arrays but grouped by the same panel with b_mem buttons.

* b_func: Three long function buttons. Backspace, CE, C.
* b_mem: Four memory buttons on the left side of the program. MC, MR, MS, M+.
* b_num: Ten number buttons indicating digits 0~9.
* b_arith: Ten arithmetic buttons. +/-, ., +, -, \*, /, =, 1/x, %, sqrt.

#### JPanels
* p_func: Groups b_func buttons.
* p_mem: Groups b_mem buttons and a blank.
* p_main: Array of JPanels to group b_num and b_arith buttons on the main part of the program. Each element takes a row of buttons.
* p_M: Contains p_func, and all of elements of p_main.

### Functionality
#### Field
A JTextField field shows the input, (interim) calculation result, memory read, and so on.

#### Entry
Entry is a number input on the field that is handled by a Boolean variable, *isEntry*. If the field is an entry, user's digits and backspace inputs will continue to edit the current field. However, if *isEntry* is false, clicking a digit or a dot button will clear the field once and write the digit or "0." on it. Moreover, no entry will block the backspace. All arithmetic buttons disable the entry to prevent the user to modify the value of calculation results showing on the field. Clicking the digits, CE, or C would make the Boolean true again.

#### Buttons
- Backspace: Erases the last digit of the field. Backspace on just one digit will make it 0. Only works when the field number is entry.
- CE: Erases the entry, or calculation result if the field is not an entry. The later may leave previous addend(+), subtrahend(-), factor(\*), or divisor(/) value.
- C: Initialize all calculation values except memory.
- blank: If the memory stores a value, it draws "M". It is the only unclickable button.
- MC: Clears the memory.
- MR: Reads a value in the memory.
- MS: Stores a value to the memory. There is only one space for the memory, unlike that of Windows 10 Calculator supporting multiple memory values.
- M+: Adds the field value to the memory.
- 0~9: Writes a digit on the field. If the field was an entry, it updates the number with adding the digit. Otherwise, the field writes the new number. Any cases will make the field an entry.
- +/-: Negate. Makes the field positive/negative.
- .: Put a dot to express a decimal point.
- +: Addition.
- -: Subtraction.
- \*: Multiplication.
- /: Division.
- =: Equation.
- 1/x: 1/x.
- %: Percentage. If the input is "200 + 20 %", it means 200 + 200 * 20% = 200 + 40 = 240.
- sqrt: Square Root.

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

