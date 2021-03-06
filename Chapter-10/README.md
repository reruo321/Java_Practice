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

* void setVisible(boolean b): Sets the component to be visible/invisible.
* void setFont(Font f): Sets the font of the component.
* void setForeground(Color c): Sets the foreground color of the component.
* void setBackground(Color c): Sets the background color of the component.
* void setSize(int width, int height): Sets the size of the component.
* void setEnabled(boolean n): Sets the component to be enabled/disabled.
* void setLocation(int x, int y): Sets the location of the component.
* Color getForeground(): Returns the foreground color of the component.
* Dimension getSize(): Returns the size of the component.
* String getName(): Returns the name of the component.
* void paint(Graphics g): Invoked by Swing to draw components. This should not be called by user directly. Instead, if the component shows for the first time, if the component had shadowed by other windows and then appears again, or if the user calls repaint() directly, it is called.
* void repaint(): Requests to draw components again, connecting the process between update() and paint(). While paint() is for the system thread, this is for the application thread.
* void update(Graphics g): Called by the request of repaint(). It erases the current components, and then calls paint().
### Container
A generic AWT container that can contain other AWT components.

* void setLayout(LayoutManager lay): Sets the LayoutManager of the container.
* Component add(Component comp): Adds the component at the end of the container.
* void remove(Component comp): Removes the component from the container.
* Component [] getComponents(): Returns all the components in the container.
### JComponent
The base class for all Swing components except top-level containers JFrame, JWindow, JDialog, JApplet.

* void setBorder(Border b): Sets the border of the component.
* void setPreferredSize(Dimension preSize): Sets the size of the component.
* void setToolTipText(String t): Sets the tooltip for the component.
### JFrame
An extended version of java.awt.Frame that adds support for the JFC/Swing component architecture. It can contain other components.

* JFrame(): Creates a JFrame, with BorderLayout as its default LayoutManager.
* Container getContentPane(): Returns the ContentPane of the frame.
* void setDefaultCloseOperation(int op): Sets the default operation when the frame is closed. The operation constants are: EXIT_ON_CLOSE, DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, DISPOSE_ON_CLOSE.

![10JFrame](https://user-images.githubusercontent.com/48712088/148080604-ea1fa1cf-a599-4797-be31-a5ca7d7ea9b5.png)

#### Root Pane
In general, you don't need to create a JRootPane directly. When you create an JFrame object, you also get it automatically. [(The official tutorial)](https://docs.oracle.com/javase/tutorial/uiswing/components/rootpane.html)

- Glass pane: Hidden by default. If it becomes visible, it detects but blocks all input events from reaching the components in the content pane like a sheet of glass. It is useful when you catch events or paint over an area that already contains one or more components.
- Layered pane: Container with depth enables to overlap on top of the other. There are also certain depths are defined to be used for specific functions: FRAME_CONTENT_LAYER(-30000), DEFAULT_LAYER(0), PALETTE_LAYER(100), MODAL_LAYER(200), POPUP_LAYER(300), DRAG_LAYER(400).
- Content pane: The container of the root pane's visible components, excluding the menu bar.
- Optional menu bar: The home for the root pane's container's menus.

### JPanel
Generic lightweight container.

* JPanel(): Creates a JPanel, with FlowLayout as its default LayoutManager.
* JPanel(LayoutManager lay): Creates a JPanel, with the specified LayoutManager.
#### ??? JFrame vs JPanel
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

This is the full example figure of five layout managers from Example 02.

![10Layout](https://user-images.githubusercontent.com/48712088/148222970-a350b263-b122-4836-a9ce-75ef673e122a.png)

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

Suppose that there are four JButtons b1, b2, b3, and b4 in a GridBagLayout. If our program is like this, (See more on Example 02.)

        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        JButton b1...
        add...
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gb.setConstraints(b3, gc);
        gb.setConstraints(b4, gc);
        
It means that b3 and b4 would be the last cell of each horizontal grid.

#### gridx, gridy
They set the position of the cell containing the leading edge of the component's display area. The cell on the top-left grid is gridx=0 and gridy=0. The default value RELATIVE makes the components to be added in sequence in the container's direction.
#### insets
insets determines the minimum distance between the component and the edges of its display area as external padding.
#### ipadx, ipady
ipadx and ipady are the internal paddings of the component which are added to the minimum size of the component.
#### weightx, weighty
These specify how to distribute extra horizontal/vertical space. Default value for them is 0, and it gathers the components to center.

### CardLayout
![10Card](https://user-images.githubusercontent.com/48712088/148646311-da7bb00f-3d0e-488e-b94d-0d4be59de387.png)

CardLayout is a layout manager that treats each component in the container as a card. It acts like a stack of cards showing only one card at a time.

Create multiple JPanels with their components. It may need a card panel with several cards, (We can use JButtons as card components!) a main panel for holding the cards, and others containing miscellaneous components. (such as some functional JButtons to turn up the cards)
After that, put all of them to the content pane of the frame.

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        ...

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

| Event | Description |
| :-: | :-: |
| ActionEvent | Actions (click, enter, ...) on a component. |
| AdjustmentEvent | Events by Adjustable objects. (ex: Scrollbar) |
| ComponentEvent | When a component is moved, its size or visibility is changed. |
| ContainerEvent | When contents of container has changed by component adding or removing. |
| FocusEvent | If a component gets/loses focus. |
| InputEvent | Input events on component level. |
| ItemEvent | Indicates selection or cancellation on an item. |
| KeyEvent | Key press on a component. |
| MenuDragMouseEvent | Mouse drags on menu items. |
| MenuKeyEvent | Key pressed on menu items. |
| MouseEvent | Mouse action on a component. |
| TextEvent | Text of the text object is edited. |
| WindowEvent | Window status has been changed. |

#### Swing Events
While Swing components can fire AWT events, they also invoke special events for Swing. See [here](https://docs.oracle.com/javase/8/docs/api/javax/swing/event/package-summary.html) for details.

| Event | Description |
| :-: | :-: |
| CaretEvent | Indicates a change on caret of text objects. |
| ChangeEvent | Component statue has been changed. |
| DocumentEvent | Change on documents. |
| HyperlinkEvent | Events on hyperlink. |
| InternalFrameEvent | Adds support for JInternalFrame objects as the event source. |
| ListDataEvent | Events on modifying a list. |
| ListSelectionEvent | Changes on list selection area. |
| MenuEvent | Menu actions like selection or deletion. |
| PopupMenuEvent | Events on pop-up menu. |
| TableColumnModelEvent | Events on table column model changes. |
| TreeSelectionEvent | Events on tree selection changes. |

??? Caret: Insertion-point cursor on text area. It looks like 'I' or '|'.

??? Table Column Model: All the attributes of a column in a JTable. You can see a lot of database tables in this model...

| Animal | Leg | canFly |
| :-: | :-: | :-: |
| Dog | 4 | |
| Cat | 4 | |
| Parrot | 2 | V |
| Bee | 6 | V |

The above is simple form of table column model.

??? Tree Selection: Shows the current state of the selection for the tree component. File explorer to represent directory hierarchy is the example for this.

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
![10JLabel](https://user-images.githubusercontent.com/48712088/148646213-03113973-a332-4f77-b037-f9508afbc4f7.png)

JLabel component shows a String on graphic screen. Swing label can also express an image.
### JButton
![10JButton](https://user-images.githubusercontent.com/48712088/148646193-3bbca6f8-26a6-44c5-b249-526fc2ccf049.png)

JButton is the most common among GUI components, which makes actions by being clicked.
### JCheckBox
![10JCheck](https://user-images.githubusercontent.com/48712088/148646194-ac1ed81f-3b0e-42a0-812d-ca9f289f73d8.png)

JCheckBox toggles the selections by clicking the mouse.
### JRadioButton
![10Radio](https://user-images.githubusercontent.com/48712088/148642766-fa649227-5f43-40d1-9aba-baa46543d369.png)

It can toggle the selections like checkbox, but only one button is checked at a time in the same ButtonGroup.

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);

Group the JRadioButtons, or multiple selections can be checked simultaneously.

### Menu
#### JMenu
![10JMenu](https://user-images.githubusercontent.com/48712088/148643025-8d487fee-b971-4d45-a999-1a9e427387c8.png)

JMenu contains some parts such as menu bar and items.

        menu.add(item1);
        menubar.add(menu);
        this.setJMenuBar(menubar);

 Add items to the menu, menus to the menu bar, and set the menu bar to the frame.

#### JPopupMenu
![10JPopup](https://user-images.githubusercontent.com/48712088/148643032-81c273b3-489f-4936-8d4c-07fdad144c79.png)

It is the menu hidden in usual, but pops up when right-clicking the mouse.

### Text Components
#### JTextField
![10JTField](https://user-images.githubusercontent.com/48712088/148643404-163bf471-edd0-4617-995c-e305183e7d85.png)

A TextField gets just a line input by the screen.
#### JTextArea
![10JTArea](https://user-images.githubusercontent.com/48712088/148643407-176314b3-e6c0-439a-a593-54df62ce5aa4.png)

It can get many line inputs by the screen.

### JList
![10JList](https://user-images.githubusercontent.com/48712088/148643426-91c7c74f-83e2-4030-bbbf-bede1054f3c6.png)

JList shows a list of items, and lets a user to choose one or more of them.
#### Selection Mode
![10Selection](https://user-images.githubusercontent.com/48712088/148643833-613d8b45-dfd7-4a92-befa-b039ca9a8322.png)

There are three types of selection mode for items in the JList, and you can choose one of them.

        JList<Object> list = new JList<>(data);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

### JComboBox
![10JCombo](https://user-images.githubusercontent.com/48712088/148645948-fecfa010-95b2-4775-b61c-31e040de86a8.png)

It is the component that combines a button or editable field and a drop-down list. A user can select a value from the list. If JComboBox is editable, he can type the value freely.
### JSpinner
![10JSpinner](https://user-images.githubusercontent.com/48712088/148645958-6da604c3-255f-4561-97c1-64a1d2503e76.png)

JSpinner is similar to JComboBox, but it allows users to select a wanted value with his mouse and keyboard, instead of using drop-down list. Typing is also okay.
### JScrollPane
![10JScroll](https://user-images.githubusercontent.com/48712088/148645959-2b54d708-a41f-4920-8b5d-45b4a316b88d.png)

This provides scrollable view of a lightweight component. It manages a viewport and optional horizontal & vertical bars.
### JTable
![10Table](https://user-images.githubusercontent.com/48712088/148645968-281bf170-6dcc-4e4c-8a23-100835c90b0e.png)

JTable enables a user to output data and edit them on the 2D table, with rows and columns.

    JScrollPane scroll = new JScrollPane(table);

Do not forget to attach created JTable to JScrollPane, or it might not be displayed properly!
### JTabbedPane
![10JTabbed](https://user-images.githubusercontent.com/48712088/148645981-eeabf958-7c96-48ea-a3e2-0736e905dba3.png)

A JTabbedPane can change the component group, when its tabs with specific titles or icons are clicked.

### Border
![10Border](https://user-images.githubusercontent.com/48712088/148645986-77d93bc1-8dfe-4d33-bc01-f78c08de1280.png)

Most of Swing components are easy to add or change their border. Use setBorder() method derived from JComponent to determine the shape of it. If you need additional one, you can implement interface Border by yourself.

### LookAndFeel
Using UIManager class, you can implement an appropriate LookAndFeel, which represents literally look and feel. (UI, or "skin" in short!)

Use methods in UIManager to get objects, and set your custom LookAndFeel with setLookAndFeel().

        static String getCrossPlatformLookAndFeelClassName()   // Java LookAndFeel
        static String getSystemLookAndFeelClassName()   // Native System LookAndFeel
        
These examples can be an argument for setLookAndFeel().
        
        "com.sum.java.swing.plaf.motif.MotifLookAndFeel"   // Motif LookAndFeel
        "javax.swing.plaf.metal.MetalLookAndFeel"   // Java LookAndFeel
        "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"   // Windows OS LookAndFeel
        
Call updateComponentTreeUI() from SwingUtilities class, and you can apply your LookAndFeel to UI.

### ??? Tips
Make use of JPanels to beautify your GUI alignment!

![10Panel](https://user-images.githubusercontent.com/48712088/148692718-c044232d-cdd3-48fc-a697-c485fd1f1167.png)

The boxes with red, blue, and green borders are JPanels, and especially the blue one contains two sub-panels for ID and password components. I used BorderLayout as main, and each panel gets red-NORTH, blue-CENTER, and green-SOUTH region.
