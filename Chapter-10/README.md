# Ch. 10 - Java GUI Program

## AWT
AWT(Abstract Window Toolkit) is a package of components for programming GUI programs in Java.
It provides various things as default, including components such as menu, button, list, checkbox, and text area, and also containers for them like window and panel.
There are classes to edit the font or color of components, or to process events for them.

![10AWT](https://user-images.githubusercontent.com/48712088/148050268-f9c150aa-53b5-419f-a005-4bc15682baeb.png)
This example shows some components from AWT.

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
* Model: Encapsulates the state of button components, such as ON/OFF state of them and the contents on them.
* View: Shows the ON/OFF forms of buttons, and text of them.
* Controller: Take inputs from user actions (ex: clicking the button) and send messages to model and view to update themselves.

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
GridBagLayout is able to make a flexible arrangement whose components can have different size, and be freely aligned horizontally or vertically. Detailed alignment options are in GridBagConstraints class.
#### anchor
It determines the direction where the component smaller than its display area to be set. Default value is CENTER, and there are many options such as NORTH, NORTHEAST, NORTHWEST, EAST, etc.... However, it may be unmeaningful when the field *fill* is BOTH.
#### fill
It decides the size of the component, if its size is bigger than its display area. Default is NONE, which maintains its size. Meanwhile, HORIZONTAL makes its width the same as the area, VERTICAL adjusts its height, and BOTH fills the area with the component.
#### gridwidth, gridheight
They set the number of grids of row or column in the display area, and 1 is set as default value. Use REMAINDER to specify that the component's display area will be the last cell in the row/column, or RELATIVE to be the next to the last one in its row/column.
#### gridx, gridy
They set the position of the cell containing the leading edge of the component's display area. The cell on the top-left grid is gridx=0 and gridy=0. The default value RELATIVE makes the components to be added in sequence in the container's direction.
#### insets
insets determines the minimum distance between the component and the edges of its display area as external padding.
#### ipadx, ipady
ipadx and ipady are the internal paddings of the component which are added to the minimum size of the component.
#### weightx, weighty
These specify how to distribute extra horizontal/vertical space. Default value for them is 0, and it gathers the components to center.

### CardLayout
CardLayout is a layout manager that treats each component in the container as a card. It acts like a stack of cards showing only one card at a time.

* add(): Adds a component. It is from java.awt.Component.
* show(): Flips to the component. The second parameter gets the String name of the component.
* first(), last(), previous(), next(): Flips the first/last/previous/next card.

## Event Handling
A Significant change in state, such as user actions like typing a keyboard or clicking a mouse, is called **event**. Event-driven programming makes the program to do proper reaction to events. Java supports this, and it represents all user actions into Event class. Component class has methods to handle the events, which can be overridden with new contents by user's customization.

**processEvent()** is the most important method among the event-handling methods, which is automatically called when the event arises. It may be convenient to handle all events with it, but it is better to declare individual event handlers than overgrowing just one method.

### Types of Events
Java provides classes according to the types of events.
#### AWT Events
The official documentation for java.awt.event is [here](https://docs.oracle.com/javase/8/docs/api/java/awt/event/package-summary.html).
#### Swing Events
While Swing components can fire AWT events, they also use special events for Swing. See [here](https://docs.oracle.com/javase/8/docs/api/javax/swing/event/package-summary.html) for details.

### Frequently Used Events
#### 1. ActionEvent
When a button is pushed, an item from menu or list is selected, or enter key is pushed on a text field, ActionEvent arises.
#### 2. ItemEvent
ItemEvent pops up if you check/uncheck a radiobutton, a checkbox, a menu item, or a list item.
#### 3. WindowEvent
If a window size is changed, a window is opened or closed, activated, or becomed an icon, WindowEvent happens.
#### 4. MouseEvent
MouseEvent is emitted when a mouse button is clicked or a mouse is moved.
#### 5. KeyEvent
You can call KeyEvent by getting your hands on/off a key.
#### 6. InputEvent
InputEvent is an abstract class derived from Component. It has KeyEvent and MouseEvent as its children, and it provides several constants for them.

### Listener
To check whether the event is or not, and to handle each event, Java provides **Listener** interface. A event handler can implement it to satisfy user needs, and has the name with ~Listener, instead of ~Event.

1. Select the type of the event, and write a class for handling this, implementing Listener.
2. Add the listener to the component making the event. For example, try button.addActionListener(this); for ActionListener.
3. Write the event handler.

### Adapter
Since Listener is an interface, a user might be annoyed with some methods he does not even need to implement at all. To solve this, Java also has an abstract class, **Adapter**. It is very convenient to override a few methods, but it has a demerit for handling various events, because multiple inheritance is not allowed for Java classes. Moreover, not all Listeners have their Adapter versions. For these reasons, you would patronize Listener.

## Swing Components
### JLabel
JLabel component shows a String on graphic screen. Swing label can also express an image.
### JButton
JButton is the most common among GUI components, which makes actions by being clicked.
### JCheckBox
JCheckBox toggles the selections by clicking the mouse.
### JRadioButton
It can toggle the selections like checkbox, but only one button is checked at a time if it is used with ButtonGroup.

### Menu
#### JMenu
JMenu contains some parts such as menu bar and items.
#### JPopupMenu
It is hidden in usual, but pops up when right-clicking the mouse.

### Text Components
#### JTextField
A TextField gets just a line input by the screen.
#### JTextArea
It can get many line inputs by the screen.

### JList
JList shows a list of items, and lets a user to choose one or more of them.
### JComboBox
It is the component that combines a button or editable field and a drop-down list. A user can select a value from the list. If JComboBox is editable, he can type the value freely.
### JSpinner
JSpinner is similar to JComboBox, but it allows users to select a wanted value with his mouse and keyboard, instead of using drop-down list. Typing is also okay.
### JScrollPane
This provides scrollable view of a lightweight component. It manages a viewport and optional horizontal & vertical bars.
### JTable
JTable enables a user to output data and edit them on the 2D table, with rows and columns.

Do not forget to attach created JTable to JScrollPane, or it might not be displayed properly!
### JTabbedPane
A JTabbedPane can change the component group, when its tabs with specific titles or icons are clicked.

### Border
Most of Swing components are easy to add or change their border. Use setBorder() method derived from JComponent to determine the shape of it. If you need additional one, you can implement interface Border by yourself.

### LookAndFeel
Using UIManager class, you can implement an appropriate LookAndFeel, which represents literally look and feel. (Skin in short!)

Use methods in UIManager to get objects, and set your custom LookAndFeel with setLookAndFeel().

        static String getCrossPlatformLookAndFeelClassName()   // Java LookAndFeel
        static String getSystemLookAndFeelClassName()   // Native System LookAndFeel
        
These examples can be an argument for setLookAndFeel().
        
        "com.sum.java.swing.plaf.motif.MotifLookAndFeel"   // Motif LookAndFeel
        "javax.swing.plaf.metal.MetalLookAndFeel"   // Java LookAndFeel
        "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"   // Windows OS LookAndFeel
        
Call updateComponentTreeUI() from SwingUtilities class, and you can apply your LookAndFeel to UI.
