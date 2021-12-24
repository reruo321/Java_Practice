# Ch. 8 - Exception Handling
While running a program, not only there can be logical or system errors, but also some exceptions.
Exception arises in many situations such as division by 0, array of insufficient size, and not available I/O files.
Handling is to predict and prepare these possible exceptions, so that the program can process and exit normally.
Java **DOES** specify exception handler in advance, and it is more powerful than those of other languages.

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
![08Exceptions](https://user-images.githubusercontent.com/48712088/147271236-075e809d-202f-4838-b411-f604102daf5e.png)
※ Check [here](https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html) for more classes in the hierarchy.

Throwable is the root of the hierarchy, and it has Error and Exception as its children. Exception is able to be handled by the program codes, while Error is hard to be done so.

The table below shows methods for the Throwable class.

| Constructor | Description |
| :-: | :-: |
| Throwable() | Creates an instance. |
| Throwable(String message) | Creates an instance with the String *message*. |
| Throwable(String message, Throwable cause) | Creates an instance with the String *message* and the variable *cause*. |
| Throwable(String message, Throwable cause) | Creates an instance with the variable *cause*. |

| Method | Description |
| :-: | :-: |
| Throwable getCause() | Returns the cause of the Throwable, or null for the nonexistent or unknown cause. |
| String getLocalizedMessage() | Returns the message of Throwable in localized language. |
| String getMessage() | Returns the full message of Throwable. |
| Throwable initCause(Throwable cause) | Initialize thes cause of Throwable as *cause*. |
| void printStackTrace() | Prints Throwable and its backtrace to the standard error stream. |
| void printStackTrace(PrintStream s) | Prints Throwable and its backtrace to the specified print stream *s*. |
| void printStackTrace(PrintWriter s) | Prints Throwable and its backtrace to the specified print writer *s*. |
| String toString() | Returns the simple description of the Throwable. |

## try & catch
Enclose statements possible to throw exceptions with *try* block, and write *catch* block right after it.
Next, write handling statements in the *catch* block. *catch* block can be multiple, and the arising exception while running the program decides which *catch* to be processed. If an IOException happens, among many catch blocks, the block for IOException is executed.

This is the syntax for the try-catch.

        try {
        ...   // Try to catch exceptions here.
        }
        catch(Exception1 e) {
        ...   // Process Exception1 here.
        }
        catch(Exception2 e) {
        ...   // Process Exception2 here.
        }

Since the program runs only the first matching catch block when it has caught an exception, set the *catch* for the super Exception at the bottom, or a programmer cannot handle exceptions in detail.

## finally
If the statements should be executed, not caring if the catch block is run, enclose them with *finally* block. It comes next to the catch block.

        try {
        ...   // Try to catch exceptions here.
        }
        catch(Exception1 e) {
        ...   // Process Exception1 here.
        }
        finally {
        ...   // Process statements anyway here.
        }
        
## throw & throws
Add *throws* to the method to declare what exception it should throw. It is not mandatory for unchecked exceptions, but MUST be explicitly declared for checked ones.