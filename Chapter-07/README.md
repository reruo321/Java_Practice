# Ch. 7 - Abstract Class & Interface
## Abstract Class
Abstract class provides general attributes and behaviors without realization,
and also accessible methods and variables as class contract. It cannot have an instance (substance),
but instead its sub classes can be concrete by overriding methods of their super.
### abstract
To make an abstract class or method, add *abstract* keyword in front of them.
A class automatically becomes abstract if it has any abstract methods, so *abstract* keyword for the class can be omitted.

Abstract methods cause error when they is not realized. However, an abstract class cannot make any instances.
Therefore, its subclasses should override all of them, and embody their methods.
