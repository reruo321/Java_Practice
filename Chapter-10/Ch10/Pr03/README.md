# Simple Calculator

The problem requires to make a calculator using Swing.

## Program Explanation
![10Calculator](https://user-images.githubusercontent.com/48712088/149622049-a3973576-6581-4ea0-9d57-2be17b1a4cc9.png)

This is the Swing calculator whose UI resembles the program from old Windows, but miscellaneous controls try to imitate those of Windows 10.

### UI
![10CalculatorUI](https://user-images.githubusercontent.com/48712088/149622100-129da028-33f3-4185-a1b6-323b07d4d6de.png)

#### JButtons
There are four JButton arrays to group a lot of JButtons by their functions and positions: b_func, b_mem, b_num, and b_arith. Additionally an unclickable JButton *blank* to show the status of the memory also exists, which is not an element of any arrays but grouped by the same panel with b_mem buttons.

* b_func: Three long function buttons. Backspace, CE, C.
* b_mem: Four memory buttons on the left side of the program. MC, MR, MS, M+.
* b_num: Ten number buttons indicating digits 0~9.
* b_arith: Ten arithmetic buttons. +/-, ., +, -, \*, /, =, 1/x, %, sqrt.

#### JPanels
* p_func: Groups b_func buttons.
* p_mem: Groups b_mem buttons and a blank.
* p_main: Array of JPanels to group b_num and b_arith buttons on the main part of the program. Each panel element takes a row of buttons.
* p_M: Contains p_func, and all of elements of p_main.

### Functionality
#### Field
A JTextField field shows many values: the current entry, (interim) calculation results, read memory value, and so on.

#### Entry
Entry is a number input on the field that is handled by a Boolean variable, *isEntry*. If the field is an entry, user's digits, a dot, and backspace inputs will continue to edit the current field. However, if *isEntry* is false, clicking a digit or a dot button allows the user to express his new input value on the field without taking out the numbers one by one; it automatically clears the field once, and put the digit or "0." on it. Moreover, no entry will block the backspace working, to prevent to modify the calculation results. All arithmetic buttons would disable the entry, but clicking the digits, CE, or C would make the Boolean true again.

#### Buttons
- Backspace: Erases the last digit of the field. Backspace on just one digit will make it 0. Only works when the field number is entry.
- CE: Clears the entry, or calculation result if the field is not an entry. The later may leave previous addend(+), subtrahend(-), factor(\*), or divisor(/) value.
- C: Initialize all calculation values and flags except memory.
- blank: If the memory has stored a value, it gets a "M" mark. It is the only unclickable button.
- MC: Clears the memory.
- MR: Reads the value from the memory.
- MS: Stores the field value to the memory. There is only one space for the memory, unlike that of Windows 10 Calculator supporting multiple memory storages.
- M+: Adds the field value to the memory.
- 0~9: Writes a digit on the field. If the field was an entry, it updates the number with adding the digit. Otherwise, the field writes the new number. Any cases will make the field an entry.
- +/-: Negate. Makes the field positive/negative.
- .: Put a dot to express a decimal point.
- +: Addition.
- -: Subtraction.
- \*: Multiplication.
- /: Division.
- =: Equation.
- 1/x: Rational function 1/x.
- %: Percentage. If the input is "200 + 20 %", it means 200 + 200 * 20% = 200 + 40 = 240.
- sqrt: Square Root. Since BigDecimal.sqrt() is not in Java SE 8, it gets the result by casting the input value to double type to use Math.sqrt().

### Mechanism of Arithmetic Operations
When you take a look at the arithmetic operations in the Windows 10 Calculator closely, you may notice that there's a little mechanism differences among these three operator groups: {+, -, \*, /}, {1/x, %, sqrt}, and {=}.

1. +, -, \*, /: These operators take the field value in sequence, while calculating the previous ones even the formula is not finished yet by = operator. Taking the input "1 + 5 - 2 +", and you will notice "1 + 5" becomes "6" displayed on the field when you press "-". In the same way, after the second "+", "6 - 2" is concluded as "4" to be the next augend.
2. 1/x, %, sqrt: This group updates the current field, instead of progressing the calculation. Suppose that the input is "3 + 5 sqrt - 2". Since "sqrt" only affects "5", the first formula would be "3 + √5". After pressing a "-", it will be calculated.
3. =: It ends the equation. The funny thing is, it also checks the last value and operator to duplicate the last operation with multiple "=" clicking. If the user presses "1 + 3 + 5 = = =", the last operation will be "+5", so the equation can be interpreted as "1 + 3 + 5 + 5 + 5 =" = "19". However, if the input was "1 + 3 + 5 + = =", "1 + 3 + 5 +" should be repeated so the result would be "9 + 9 + 9 =" = "27".

In the program, a byte variable *status* acts as 4 flags to control the operation orders.

CE should also pay attention to these rules to correctly clear the non-entry values. In "2 \* 7 = CE 3 =", the last operation is "\*7", so it becomes "3 **\* 7** =" = "21". By the way, if the input was "2 \* 7 \* = CE 3 =", the program remembers "2 \* 7 \*", and after CE, "**14 \*** 3 =" = "42". Did you notice not only the remaining operand values after CE but the position of them were also different?

### Number
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
    
the results have a bit of errors. Therefore to get exact real numbers, BigDecimal is more recommended than binary floats. (Especially important on bank business with many big transactions.) It is immutable, arbitrary-precision signed decimal number consists of an arbitrary precision integer *unscaled value* and a 32-bit integer *scale*. Scale is the number of the digits to the right of the decimal point of BigDecimal.

So to speak, the real number 12.345 will have unscaled_value=12345 and scale=3. In the same way, 3.00000 will have unscaled_value=30000 and scale=5.

    BigDecimal big = new BigDecimal("12.345");
    System.out.println("Unscaled Value: " + big.unscaledValue() + ", Scale: " + big.scale()); 

BigDecimal will give the numbers as much precision as possible, so double represented as a String is preferable to double itself as a parameter. (It will say "Unpredictable 'new BigDecimal()' call" warning to double type parameter, and the constructor will lose the precision benefit.)

All numbers for calculation in the program are **BigDecimal**, and the displayed one on the text field has maximum 16 as scale. It uses MathContext.DECIMAL128 for MathContext in division, and square root is calculated indirectly from double type values. (BigDecimal.sqrt() is available since Java SE 9.)
