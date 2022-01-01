# Ch. 10 - Java GUI Program

## AWT
AWT(Abstract Window Toolkit) is a package of components for programming GUI programs in Java.
It provides various things as default, including components such as menu, button, list, checkbox, and text area, and also containers for them like window and panel.
There are classes to edit the font or color of components, or to process events for them.

## Swing
Swing is a widget toolkit to provide more enhanced GUI embodiment than AWT. It has Swing components most of which are similar to those of AWT.

1. Swing does not require allocation of native resources in the OS's windowing toolkit unlike AWT, but instead Java renders graphics directly.
2. Swing has more complicated and various graphic components like table and tree.
3. Swing provides Look and Feel function; by using it a user can modify program's entire UI.
4. Swing components are platform-independent and lightweight, without using Native methods.

## Swing Package
### Component
The abstract superclass of the nonmenu-related AWT components.
### Container
A generic AWT container that can contain other AWT components.
### JComponent
The base class for all Swing components except top-level containers JFrame, JWindow, JDialog, JApplet.
### JFrame
An extended version of java.awt.Frame that adds support for the JFC/Swing component architecture. It can contain other components.
### JPanel
Generic lightweight container.
#### ※ JFrame vs JPanel
| | JFrame | JPanel |
|:-:| :----: | :----: |
| **Title Bar** | O | X |
| **Parent** | java.awt.Frame | javax.swing.JComponent |
| **Function** | Window | Components Group |
| **Weight** | Heavy | Light |

Summary: JFrame is typically used as a window that can contain one or more JPanel.

### Other Classes
They represent various GUI components.

## MVC
Swing has a **MVC(Model-View-Controller)** pattern.
![10MVC](https://user-images.githubusercontent.com/48712088/147849770-58b3baa0-2684-4502-9f7f-7f77492cd8c8.png)

### Example
1. Model: Encapsulates the state of button components, such as ON/OFF state of them and the contents on them.
2. View: Shows the ON/OFF forms of buttons, and text of them.
3. Controller: Take inputs from user actions (ex: clicking the button) and send messages to model and view to update themselves.

## Layout Manager
It is a class that determines the size and position of components.

    /* Example */
    BorderLayout bl = new BorderLayout();   // 1. Create a layout manager.
    setLayout(bl);   // 2. Set the layout manager. The parameter is LayoutManager-type object.
    add(new JButton("OK"));   // 3. Add a component.
    
### FlowLayout
FlowLayout is one of the layout managers that places each component in row order. It provides three constants LEFT, RIGHT, CENTER (default) to align the components.

    setLayout(new FlowLayout());
    add(new JButton("Hello"));

### BorderLayout
BorderLayout arranges the components in cardinal directions. (North, South, East, West + Center) Window or Frame uses this as default layout manager. It first places NSEW components then center one, considering their size and margin of the Container window.

    setLayout(new BorderLayout());
    add("North", new JButton("North"));
    
### GridLayout
It sets the components on rows and columns a grid. The layout without any arguments will create a 1x1 grid.

    setLayout(new GridLayout(2,2));
    add(new JButton("Button1"));
    add(new JButton("Button2"));
    add(new JButton("Button3"));
    add(new JButton("Button4"));
    
### BoxLayout
Unlike other java.awt layouts above, BoxLayout is provided by javax.swing package. It stacks the components as if they are the real-life boxes. Set the constant as X_AXIS for horizontal, and Y_AXIS for vertical pile.

    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    add(new JButton("*"));
    add(new JButton("***"));
    add(new JButton("*****));
    
### GridBagLayout
