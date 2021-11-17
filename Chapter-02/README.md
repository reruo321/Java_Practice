# Ch. 2 - Java Program Structure
Let us check the Java Platform Standard Edition 8 API Specification documentation in this chapter, to adapt ourselves to Java.

## Ex. 01 - Hello
The example shows the basic printing outputs, especially using escape sequences.

### Class
    public final class System
       └ public static final PrintStream out  // field
          └ void print(T TYPE)
          └ void println(T TYPE)
A Java Field is a variable inside a class, (a.k.a. static variable, or member variable)
and System has **out** as one of its fields, which is the "standard" output stream.

Since class PrintStream has **print()** and **println()** as its methods, you can call them like this:

    System.out.print("Print an Argument");
    System.out.println("Print an Argument with a Line Termination");

Various types of data can be put in them, and they also support string concatenation operator (+) and string conversion. [See more information here.](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)

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
The file gets the inputs from a user, and saves them to several variables.
### Class
    public final class Scanner
    Scanner(InputStream source)  // Constructor
       └ String next()
       └ String nextLine()
       └ T next*T*()  // int nextInt(), byte nextByte(), double nextDouble(), etc...

    public final class System
       └ public static final InputStream in  // field
One of the constructors for class Scanner has InputStream as its parameter, so putting the "standard" input stream **System.in** is okay.

    Scanner scan = new Scanner(System.in);
    String name = scan.next();
Methods for this Scanner with their names "next~" will take user's inputs as their data types.

## Ex. 03 - BufferedReader
It takes a line and a character as inputs.
### Class
    public abstract class Reader
       └ public class BufferedReader
         BufferedReader(Reader in)  // constructor

    public abstract class Reader
       └ public class InputStreamReader
            └ int read()
            └ String readLine()

    public final class System
       └ public static final InputStream in  // field
          └ abstract int read(byte[] b)
BufferedReader reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines. The BufferedReader uses its default size if there is no second parameter, and it is large enough for most purposes.

An InputStreamReader is a bridge from byte streams to character streams, and it gets top efficiency when being wrapped by a BufferedReader.

System.in.read() reads some number of bytes from the input stream, and it stores them into the buffer array.

    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    String address = rd.readLine();
    
    int sex = System.in.read();

As System.in.read() reads the input as byte type, cast it from byte to char if you want a character form.

    int sex = System.in.read();  // If the input is 'F', int sex = 70. 70 implies 'F' in ASCII code.
    System.out.println((char)sex);  // By type casting, the output will be converted from 70 to 'F'.

Beware that BufferedReader.readLine() and System.in.read() should throw java.io.IOException when they catch an exception. Add "throws IOException" to your method.

    public static void main(String [] args) throws IOException {...}

## Ex. 04 - JOptionPane
