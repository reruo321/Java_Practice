# Ch. 8 - Exception Handling
While running a program, not only there can be logical or system errors, but also some exceptions.
Exception arises in many situations such as division by 0, array of insufficient size, and not available I/O files.
Handling is to predict and prepare these possible exceptions, so that the program can process and exit normally.
Java **DOES** specify exception handler in advance, and it is more powerful than those of other languages.

## Introduction
### Syntax
For example, to make the main method to handle an IOException, write "*throws* IOException" like this.

    public static void main(String [] args) throws IOException {...}

### Types of Exception

| Exception Type | Description |
| :-: | :-: |
| ArrayIndexOutOfBoundsException | Array has been accessed with an illegal index. |
| ArithmeticException | Divison by 0 has happened. |
| IOException | Exception on Input/Output. |
| NegativeArraySizeException | Array size has been defined as negative. |
| NullPointerException | No object or value has been available as a reference. |
| NoSuchMethodException | Not found method. |

## Class Hierarchy
![08Exceptions](https://user-images.githubusercontent.com/48712088/147331592-214bccbd-7009-4d25-993a-a1e74caf6ee7.png)

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

### Checked Exception
A check exception represents problems that can be recovered during the program execution, which are usually not a programmer's fault. (Ex: bad file read, bad network connection) It does not force the program to exit, but instead notifies the problems to the users to take further actions. Handling of checked exception must be declared on the method with *throws* clause.

### Unchecked Exception
Unchecked exception is divided into **Error** and **RuntimeException**, and it reflects some errors inside the program's logic. Java does not verify it at compile-time.

#### Error
The program usually cannot recover when Errors occured. It is often better to exit the program than wish the program to have a fallback on them.

#### RuntimeException
This usually happens by the fault of the programmer, so it must be resolved at his developing time.

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
        
## throws & throw
### throws
Add *throws* to the method to declare what exception it should throw. It is not mandatory for unchecked exceptions, but it MUST be explicitly declared if the exceptions are checked ones.

A method passes the exception handling to other methods which call it. The exception is handled like below steps.

        public void thirdMethod(){
            ...     // 1. Suppose that thirdMethod made Exception.
        }
        public void secondMethod() throws Exception {
            ...
            thirdMethod();   // 2. thirdMethod throws the Exception to secondMethod.
            ...
        }
        public void firstMethod(){
            try {
                ...
                secondMethod();   // 3. firstMethod catches the Exception from secondMethod.
                ...
            }
            catch(Exception e) {
                ...   // 4. Here is the Exception handled.
            }
        }
        
### throw
A user can throw the exception on purpose, making its instance using *throw* keyword. Usually it is used with custom exceptions.

        throw new <Exception-Constructor>;

## User Defined Exception Class
User defined exception class, or custom exception class is written like this syntax.

        class <User-Defined-Exception-Name> extends Exception {
            public <User-Defined-Exception-Name>(String s){
                super(s);   // String s is the message for the exception.
             }
            ...
        }
