# Ch. 8 - Exception Handling
While running a program, not only there can be logical or system errors, but also some exceptions.
Exception arises in many situations such as division by 0, array of insufficient size, and not available I/O files.
Handling is to predict and prepare these possible exceptions, so that the program can process and exit normally.

## Exception Handling Syntax
For example, to make the main method to handle an IOException, write "*throws* IOException" like this.

    public static void main(String [] args) throws IOException {...}

## Types of Exception

| Exception Type | Description |
| :-: | :-: |
| ArrayIndexOutOfBoundsException | Array has been accessed with an illegal index. |
| ArithmeticException | Divison by 0 has happened. |
| IOException | Exception on Input/Output. |
| NegativeArraySizeException | Array size has been defined as negative. |
| NullPointerException | No object or value has been available as a reference. |
| NoSuchMethodException | Not found method. |

## Class Hierarchy
