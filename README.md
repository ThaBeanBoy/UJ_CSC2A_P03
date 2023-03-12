# UJ CSC2A Practical 2

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

[github repo](https://github.com/ThaBeanBoy/UJ_CSC2A_P02) <br/>
[Assignment](./docs/Assignment.pdf)

## Class Structure

![UML Diagram](./docs/UML.png)

## [ID_Generator](./src/accse/csc2a/Message.java) class

### Purpose
The first class that I worked on was the Message class. it initially had a ```public static void generateID``` method.
It's main purpose was to generate an ID for a message based on it's prefix & message number. When I eventually got to
the Ship class, I realised that the structure of the Ship ID class was similar to the structure of the Message class,

Both forms of ID had :
- prefix
- length of digits the ID could have
- the id number


### Generating the ID
1. Base of the list from the previous section, we could use this to generate an ID, first we needed a ```StringBuilder```,
   this could allow us to easily append new info to the string.
2. Filling up the string. the ID could have any number of digits, yet the amount of digits the ID could have was fixed.
   In order to alleviate this, we had to :
    - calculate the number of digits in the ```ID_no``` - Convert ```ID_no``` into
      a string & save this into ```ID_noString```
    - Get the length of the string. this is how we get the number of digits in the ID number, saved into ```NoOfDigitsInMessageNo```
    - Subtract the number of digits the from the total number of digits that the ID should have, this number was saved in ```filler```.
3. Append the ID number
4. Return the generated ID

```java
public class ID_Generator {
    public static String Generate(String Prefix, int numberOfDigits, int ID_no) throws ID_NO_ERR {
        if(ID_no > numberOfDigits)
            throw new ID_NO_ERR();

        StringBuilder generatedID = new StringBuilder(Prefix);
        String ID_noString = String.valueOf(ID_no);

        int NoOfDigitsInMessageNo = ID_noString.length();
        int filler = numberOfDigits - NoOfDigitsInMessageNo;
        //Generating ID
        generatedID.append("0".repeat(filler));
        generatedID.append(ID_noString);

        return generatedID.toString();
    }
}
```

## Things I've Learned

### Enhanced for loop
I used a regular for loop, but IntelliJ suggested using an enhanced for loop to loop through the messages. This is how it
initially looked:
```java
public class Ship{
    //Rest of Ship class
    
    public void printMessages(){
        // Rest of printMessages()
        
        for (int i=0; i<this.Messages.length(); i++){
            Message currentMessage = this.Messages[i]; 
            //Loop code
        }

        // Rest of printMessages()
    }    
    
    //Rest of Ship class
}
```
This is the enhanced version of the for loop:
```java
public class Ship{
    //Rest of Ship class
    
    public void printMessages(){
        // Rest of printMessages()
        
        for (Message Message : this.Messages){
            //Loop code
        }

        // Rest of printMessages()
    }    
    
    //Rest of Ship class
}
```

### Enhanced Switch Statement

```java
public class Message{
    //Other parts of Message class
    
    public static String getPlanetString(Planet Planet){
        switch(Planet){
            case Mercury:
                return "Mercury";
                break;
            case Venus:
                return "Venus";
                break;
            case Earth : 
                return "Earth";
                break;
            case Mars :
                return "Mars";
                break;
            case Jupiter :
                return "Jupiter";
                break;
            case Saturn :
                return "Saturn";
                break;
            case Uranus :
                return "Uranus";
                break;
            case Neptune :
                return "Neptune";
                break;
            case Pluto :
                return "Pluto";
                break;
            default :
                return"Unknown Planet";
        };
    }
}
```

```java
public class Message{
    //Other parts of Message class
    
    public static String getPlanetString(Planet Planet){
        return switch(Planet){
            case Mercury -> "Mercury";
            case Venus -> "Venus";
            case Earth -> "Earth";
            case Mars -> "Mars";
            case Jupiter -> "Jupiter";
            case Saturn -> "Saturn";
            case Uranus -> "Uranus";
            case Neptune -> "Neptune";
            case Pluto -> "Pluto";
            default -> "Unknown Planet";
        };
    }
}
```

### Using Text Block

The tect block is something that made the following block look neat and concise
```java
public class Main{
    public static void main(String[] args){
        //m1 instantiated
        
        System.out.printf(
                //String
            "ID                 : %s\n" +
            "Language           : %s\n" +
            "Message            : %s\n"+
            "Source Planet      : %s\n" +
            "Destination Planet : %s",

            //passing
            m1.getID(),
            m1.getLanguage(),
            m1.getMessage(),
            Message.getPlanetString(m1.getSourcePlanet()),
            Message.getPlanetString(m1.getDestinationPlanet())
        );
        
        // Rest of code
    }
}
```
and using java text block, it looks like this
```java
public class Main{
    public static void main(String[] args){
        //m1 instantiated
        
        System.out.printf(
            """
                    ID                 : %s
                    Language           : %s
                    Message            : %s
                    Source Planet      : %s
                    Destination Planet : %s""",

            //passing
            m1.getID(),
            m1.getLanguage(),
            m1.getMessage(),
            Message.getPlanetString(m1.getSourcePlanet()),
            Message.getPlanetString(m1.getDestinationPlanet())
        );
        
        // Rest of code
    }
}
```