# UJ CSC2A Practical 3

## Index
- [UJ CSC2A Practical 2](#uj-csc2a-practical-2)
    * [Class Structure](#class-structure)
    * [ID_Generator](#-id-generator---src-accse-csc2a-messagejava--class)
        + [Purpose](#purpose)
        + [Generating the ID](#generating-the-id)
    * [Things I've Learned](#things-i-ve-learned)
        + [Enhanced for loop](#enhanced-for-loop)
        + [Enhanced Switch Statement](#enhanced-switch-statement)
        + [Using Text Block](#using-text-block)

## Additional Information

This practical adds on to the [previous practical (Prac02)](https://github.com/ThaBeanBoy/UJ_CSC2A_P02), you can find the
changes additions to the assignment here - [Assignment](./docs/Assignment.pdf)

## Class Structure

![UML Diagram](./docs/UML.png)

## Changes To the Original Classes

### Ship's new Constructors & Method
I had to add new constructors to the Message & Ship constructors. Consequently, I had to overload the ```intit``` method,
this time, the new init method takes a ID instead of auto generating a new ID. The new constructors are the same, these
new constructors just take a ID instead of auto-generating the ID.

```java
public class Ship {
    public Ship(String ID, String Name) {
        this.init(ID, Name, DEFAULT_MESSAGES);
    }

    public Ship(String ID, String Name, Message[] Messages) {
        this.init(ID, Name, Messages);
    }

    private void init(String ID, String Name, Message[] Messages) {
        // ID isn't auto generated, it's now provided
        this.ID = ID;
        this.Name = Name;
        this.Messages = Messages;
    }
}
```

### Message's new Constructors & Method