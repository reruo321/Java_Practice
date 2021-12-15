# Ch. 7 - Abstract Class & Interface
## Abstract Class
Abstract class provides general attributes and behaviors without realization,
and it also provides accessible methods and variables as class contract. It cannot have an instance (substance),
but instead its subclasses can be concrete its concept by overriding methods of their super.
### abstract
To make an abstract class or method, add *abstract* keyword in front of them.
A class automatically becomes abstract if it has any abstract methods, so *abstract* keyword for the class can be omitted.

Abstract methods cause error when they is not realized. However, an abstract class cannot make any instances.
Therefore, its subclasses should override all of them, and embody their methods.

## Interface
Interface is a special form of the abstract class, and it cannot have normal methods or variables. (Unlike abstract class.)
It contains only description of the methods, so any classes can borrow the interface, even if there are no relationships among the classes.
Java does not support multiple inheritance through class like C++, but it does via interface.
What methods in the interface have is just a method header, so all of them MUST be embodied.
