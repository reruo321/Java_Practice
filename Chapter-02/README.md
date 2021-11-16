# Ch. 2 - Java Program Structure

## Ex. 01 - Hello
The example shows the basic printing outputs, especially using escape sequences.

### Class System

    public static final PrintStream out
**out** is the "standard" output stream.

Class **PrintStream** has print() and println() as its methods, so you can call them like this:

    System.out.print("Print an Argument");
    System.out.println("Print an Argument with Line Termination");

### Escape Sequence
Escape Sequence is a sequence of characters to represent special character or sequence, which is impossible to be appeared directly when used inside of a character or string literal.

    \n : Newline
    \t : Tab
    \b : Backspace
    \r : Carriage Return
    \\ : Inserts a backslash (\)
    \' : Inserts a single quote (')
    \" : Inserts a double quote (")

## Ex. 02 - Scanner
