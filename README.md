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

All the reasoning stated in the [section above](#Ship's-new-Constructors-&-Method) was also applied to the Message class.
But this might require an extensive explanation.

#### StringToPlanet method

This method is meant to recognise a string & convert it into a ```Planet``` enumeration. In the switch case, the input
string is converted into lower case ```Planet.toLowerCase()``` to make sure that it can return a Planet without having to
worry about any upper case characters.

This method is mainly used in the constructors, 2 of the constructor methods accept planets as a string, which need to
be converted into the appropriate data type.

It was also made public to make it accessible in other classes & files in the event it is needed elsewhere. 

#### Exceptions

The ```StringToPlanet``` throws an ```InvalidPlanetString``` exception. This fell under the default case in the switch
statement

```java
public class Message{
    public Message(String ID, String Language, String Message, Planet SourcePlanet, Planet DestinationPlanet){
        this.init(ID, Language, Message, SourcePlanet, DestinationPlanet);
    }

    public Message(String Language, String Message, String SourcePlanet, String DestinationPlanet) throws InvalidPlanetString {
        try{
            this.init(Language, Message, SourcePlanet, DestinationPlanet);
        }catch(InvalidPlanetString exception){
            throw new InvalidPlanetString();
        }
    }

    public Message(String ID, String Language, String Message, String SourcePlanet, String DestinationPlanet) throws InvalidPlanetString{
        try{
            this.init(ID, Language, Message, SourcePlanet, DestinationPlanet);
        }catch(InvalidPlanetString exception){
            throw new InvalidPlanetString();
        }
    }

    private void init(String Language, String Message, String SourcePlanet, String DestinationPlanet) throws InvalidPlanetString{
        try{
            this.ID = ID_Generator.Generate("MSG", 6, Message_No);
            Message_No++;

            this.Language = Language;
            this.Message = Message;
            this.SourcePlanet = StringToPlanet(SourcePlanet);
            this.DestinationPlanet = StringToPlanet(DestinationPlanet);
        }catch(InvalidPlanetString exception){
            throw new InvalidPlanetString();
        }
    }

    private void init(String ID, String Language, String Message, Planet SourcePlanet, Planet DestinationPlanet){
        this.ID = ID;

        this.Language = Language;
        this.Message = Message;
        this.SourcePlanet = SourcePlanet;
        this.DestinationPlanet = DestinationPlanet;
    }

    private void init(String ID, String Language, String Message, String SourcePlanet, String DestinationPlanet) throws InvalidPlanetString{
        try{
            this.ID = ID;

            this.Language = Language;
            this.Message = Message;
            this.SourcePlanet = StringToPlanet(SourcePlanet);
            this.DestinationPlanet = StringToPlanet(DestinationPlanet);
        }catch(InvalidPlanetString exception){
            throw new InvalidPlanetString();
        }
    }

    public static Planet StringToPlanet(String Planet) throws InvalidPlanetString{
        return switch(Planet.toLowerCase()){
            case "mercury" -> Mercury;
            case "venus" -> Venus;
            case "earth" -> Earth;
            case "mars" -> Mars;
            case "jupiter" -> Jupiter;
            case "saturn" -> Saturn;
            case "uranus" -> Uranus;
            case "neptune" -> Neptune;
            case "pluto" -> Pluto;
            default -> throw new InvalidPlanetString();
        };
    }

    public static class InvalidPlanetString extends Exception{}
}
```

### Appending Array function , Generics & p03_utils

I asked the lecturer if we could use ```ArrayList``` for this practical, unfortunately he said they were not allowed, & we
manually had to increase the size of the array. During the practical, I noticed that I had to deal with 2 arrays, a ```Ship[]```
& ```Message[]``` arrays. I realised that not only would I create a function for appending to an array, but I'd have to create
2 seperate functions that used the same logic. This is where generics are involved.