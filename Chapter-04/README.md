# Ch. 4 - Control Flow Statement & Array

## Control Flow Statement
Statement(문) is a syntactic unit of an imperative programming language (programming paradigm using statements to change a program's state) that expresses some action to be carried out.

    ;   // null statement (or empty statement)
    int a = 10;   // simple statement
    return 0;   // simple statement
    if (a == 10) return 0;   // compound statement
    
Control flow is the order of imperative program to execute or evaluate its statements, instructions, or function calls. Conditional statement handles the flow with its evaluation, true or false, for the condition.
If-then-else, Case and Switch, and Loops are the examples for the conditional statements.

### If-then-else
Most known high-level programming languages like C/C++ and Java have if-then-else statements as one of the key elements of structed programming.
#### If-then
    /* Example 1 */
    int a = 11;
    if(a % 2 != 0){   // If 'a' is an odd number, run "{...}". True.
        System.out.println("Odd input!");
        a++;
    }
    System.out.println(a + " is even.");

    /* Example 2 */
    int b = 11;
    if(b % 2 != 0)   // If 'b' is an odd number, run "b++;". True.
        b++;         
    System.out.println(b + " is even.");

Example 1 makes an odd variable 'a' to run statements in the nested block. (Nested block: parenthesized statements by curly brackets {}.)

If you want just one simple statement being only accessed by true evaluation, you can write it right after if-condition without any brackets. In the second example, if a variable 'b' is odd, the condition is true so it triggers "b++;" and then "System.out.println(b);". However, even 'b' will result in a false evaluation, and "b++;" will not work either, but will instead run "System.out.println(b);".

If you want multiple conditions for one if-then, use logical operators to control them.

    int age = 14;
    if(age >= 7 && age < 18)
        System.out.println("Oh, no! You can't play Call of Duty yet. Play Minecraft instead.")

In the example, if a boy's age is 7 <= age < 18, it prevents him from playing the game Call of Duty (18+), and suggests him to play Minecraft(7+).

#### If-then-else
    int a = 10;
    if(a < 0)
        System.out.println("Negative");   // false
    else
        System.out.println("Positive");   // true
If-then-else runs the statements in the "else" nested block if the condition is not true. The example will print "Positive" since the variable 'a' is not under 0.

    int weight = 50;
    
    if(weight < 45)
        System.out.println("Thin!");
    else if(weight >= 45 && weight < 55)
        System.out.println("Normal Weight!");
    else if(weight >= 55 && weight < 65)
        System.out.println("OverWeight!");
    else
        System.out.println("Fat!");
        
The If-then-else example with a "Else if" tries to check each condition from the top to the bottom, until it finds a true evaluation. "Else if" is supported in C/C++ and Java, and it can be added as many as the programmer wants.

The example finds the BMI (on obesity) of the woman by her weight. Because it is 45 <= weight < 55, the program prints that she has normal weight.

### Case and Switch
Case and Switch statement may make some control flows simpler than If-then-else.
    
    char c = 'p';
    
    if(c == 'd')
        System.out.println("d - Called a dog. Woof Woof!");
    else if(c == 'c')
        System.out.println("c - Called a cat. Meow!");
    else if(c == 'p')
        System.out.println("p - Called a pig. Oink!");
    else if(c == 'h')
        System.out.println("h - Called a horse. Neigh!");
    else
        System.out.println("Unknown Command...");
        
This is the same as

    char c = 'p';

    switch(c){
    case 'd':
        System.out.println("d - Called a dog. Woof Woof!");
        break;
    case 'c':
        System.out.println("c - Called a cat. Meow!");
        break;
    case 'p':
        System.out.println("p - Called a pig. Oink!");
        break;
    case 'h':
        System.out.println("h - Called a horse. Neigh!");
        break;
    default:
        System.out.println("Unknown Command...");
        break;
    }
### Loop
Loop in computer science is a control flow statement specialized in repeating code execution. It iterates codes in a simple statement or a nested block, while checking the condition.
#### For Loop
    /* Syntax */
    /*
    for(<Initialization>; <Condition>; <Advancement>){
        ...;
    }
    */
    
    /* Example 1 */
    for(int i=1; i<=5; i++){
        System.out.println(i);   // Repeat this for i=1, i=2, i=3, i=4, i=5.
    }

    /* Example 2 */
    int intArr[] = {1, 22, 333, 4444, 55555};
    System.out.println("What are in the array?");
    for(int x : intArr){
        System.out.print(x + " ");   // Repeat this for each array element.
    }
    
#### While Loop
    /* Syntax */
    /*
    while(<Condition/Expression>){
        ...;
    }
    */
    
    /* Example 1 */
    int i = 1;
    while(i<=5){
        System.out.println(i);   // Repeat this for i=1, i=2, i=3, i=4, i=5.
        i++;
    }

    /* Example 2 */
    int i = 1;
    while(true){
        System.out.println(i);   // Repeat this for i=1, i=2, i=3, etc... Infinite loop
        i++;
    }
    
#### Do While Loop
    /* Syntax */
    /*
    do {
        ...;
    } while(<Condition/Expression>);
    */
    
    /* Example */
    int i = 1;
    do {
        System.out.println(i);   // Repeat this for i=1, i=2, i=3, i=4, i=5.
        i++;
    } while (i <= 5);
### Other Statements
1. break Statement: Gets out of the nested block. Used in Case and Switch, For Loop, While Loop, and Do While Loop.
2. continue Statement: Ignores the statements after it, and goes to check the condition or advancement orf the loop.

## Method
If main method becomes very big, it is hard to figure out the program's structure, or manage it.
"Divide and Conquer" approach cuts the main method into small methods, and embodies the program with them step by step.

It seems like a "function" in other languages, but there's a little difference between them. The method is a procedure associated with a message and an **object**, but function is independent of any object. Nevertheless, both terminologies are often used, being mixed with each other. For example, in C++, there's a "member function" that fits the description of the "method", but it is usually called "function" anyway.
### Syntax
    /* Syntax */
    /*
    <1. Access Modifier> <2. Reserved Word> <3. Return Type> <4. Method Name>(<5. Type Parameter>) <6. throws-Exception Class>{
        <7. Statements>
    }
    */

    /* Example */
    public static int sumHello(int a, int b) throws IOException {
        int sum = a + b;
        System.out.print("Say hello, then I'll give you sum of the numbers. ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String hello = br.readLine();
        System.out.println(hello + "\t" + a + " + " + b + " = " + sum);
        return sum;
    }
    
1. Access Modifier: Sets the accessibility of classes, methods, and other members. Examples are public, private, and protected.
2. Reserved Word: Keyword that controls lifetime and visibility. *static* declaration in Java is used for static block, for the static initialization of a class. Unlike C++, Java does not support static local variables, though.
3. Return Type: Defines the data type of the value returned from the method.
4. Method Name: Name of the method.
5. Type Parameter: Special kind of variable in a subroutine, to refer input data for the subroutine.
6. *throws*-Exception Class: Sets the class for exception handling.
7. Statements: Statements in the method.
### Calling
Java has two types of data: primitive and reference. However, Java is always only call-by-value, whereas C++ is call-by-value, -reference, and -address. This is confusing since it says non-primitive Java types are handled & accessed by *references*. Due to the absence of "pointer" in Java, it is impossible to get direct access to the memory. Instead, "reference variables" like array and class make the process similar to that of the pointer. All object variables in Java are references.

The primitive arguments being passed by value is the actual value of the primitive, and the reference ones are the value of the *reference* to the object, but Java never provides the direct access to the values of object itself on both ways. Therefore, no matter what the data types are, they are always **passed by value** in Java.

### Overloading
Java methods can be overloaded, if their number of parameters or types of parameters are different.

### Recursive Method
Recursive method returns itself so it makes a loop.

## Array
Array packs multiple data with the same type into one object, to manage them easily.
Declare and create a new array, then use it by assigning reference value of array object to array variable. The array object is dynamically allocated on the heap.
### 1D Declaration
Data types for array can be either primitive or reference. The name of array variable is the reference of the array.

    /* Syntax */
    /*
    <TYPE> <Array-Name> [];   // C-style array declaration so might be less preferred
            or
    <TYPE> [] <Array-Name>;   // Java-style
    */
    
    /* Example */
    int arr[];
    
    int [] arr;
    
In the example, several int data are able to use an array variable 'arr', to refer allocated memory for the array structure.
### Creation
The array should be memory allocated before using. Add a *new* keyword to allocate the memory, and to assign allocated reference to the declared array variable.

    /* Syntax */
    // <Array-Name> = new <TYPE>[<Array-Size>];
  
    /* Example */
    arr = new int[10];
    
    /* Declaration + Creation Example */
    int [] arr = new int[10];   // 'arr' variable can refer allocated memory for 10 int-type data.

※ Example 09 needs to set arguments for the main method. Follow [this guide](https://github.com/reruo321/Java_Practice/tree/main/Appendix#main-arguments) to do it without code statements.

### Multidimensional Array
Adding additional '[ ]' extends the dimension of the array. It is usually used up to 3D.

    /* 2D Array Syntax */
    // <TYPE> [][] <Array-Name> = new <TYPE>[<Row-Size>][<Column-Size>];
  
    /* 2D Array Example */
    int [][] arr = new int[3][4];
    
### Initialization
An array initialization declares the array, allocates the memory to the size of the literal, and initializes array values literally.

    /* Syntax 1 */
    // <TYPE>[] <Array-Name> = {<literal_1>, <literal_2>, ... <literal_n>};
    /* Syntax 2 */
    // <TYPE> [] <Array-Name>;
    // <Array-Name> = new <TYPE>[]{<literal_1>, <literal_2>, ... <literal_n>};
    
    /* Example 1 */
    int [] arr1 = {1, 22, 333, 4444, 55555};
    /* Example 2 */
    int [] arr2;
    arr2 = new int[]{1, 22, 333, 4444, 55555};

### Parameter Passing
I referred to this [https://www.baeldung.com/java-pass-by-value-or-pass-by-reference](good explanation).

As all arguments in Java are pass-by-value, during method invocation, a copy of each argument is created in stack memory and passed to the method.

Primitive variables are directly stored in stack memory, and the values of primitive arguments are copied inside stack memory as formal arguments. They accumulate their own space in space memory. The formal arguments have their lifespan while the method is running, and after that, they are taken away from the stack and discarded.

On the other hand, for all objects that are non-primitive, they are dynamically stored in heap memory. The reference variables in stack memory refer to the objects in the heap. The reference variables are **copied** when the objects are passed as arguments, and the new ones referring the same location of the object as their originals, are passed to the method. Therefore, if a new object is assigned for an argument inside the method, the reference refers the new object, not the original, so any changes on the new does not affect the original object.

Let us check the Example 15. Likewise for an object, array, if an array 'arr' is passed as an argument of a method 'foo', foo(arr) makes a change to the elements of 'arr', but not to 'arr' variable itself. A method 'bar' does not alter anything for 'arr', since it tries to touch a copied reference 'y', but not 'arr'.
