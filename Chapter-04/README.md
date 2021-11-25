# Ch. 4 - Control Flow Statement & Array

## Control Flow Statement
Statement(문) is a syntactic unit of an imperative programming language (programming paradigm using statements to change a program's state) that expresses some action to be carried out.

    ;   // null statement (or empty statement)
    int a = 10;   // simple statement
    return 0;   // simple statement
    if (a == 10) return 0;   // compound statement
    
Control flow is the order of imperative program to execute or evaluate its statements, instructions, or function calls. Conditional statement handles the flow with its evaluation, true or false, for the condition.
"If-then-else" and "Case and Switch" are the examples for this.

### If-then-else
Most known high-level programming languages like C/C++ and Java have if-then-else statements as one of the key elements of structed programming.
#### If-then
    /* Example 1 */
    int a = 11;
    if(a % 2 != 0){   // If 'a' is an odd number, run "{...}". True.
        System.out.println("Odd input!");
        a--;
    }
    System.out.println(a + " is even.");

    /* Example 2 */
    int b = 11;
    if(b % 2 != 0)   // If 'b' is an odd number, run "b--;". True.
        b--;         
    System.out.println(b + " is even.");

Example 1 makes an odd variable 'a' to run statements in the nested block. (Nested block: parenthesized statements by curly brackets {}.)

If you want just one simple statement being only accessed by true evaluation, you can write it right after "if" without any brackets. In the second example, if a variable 'b' is odd, the condition is true so it triggers "b--;" and then "System.out.println(b);". However, even 'b' will result in a false evaluation, and "b--;" will not work either, but will instead run "System.out.println(b);".

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
