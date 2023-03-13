package accse.csc2a;

import accse.csc2a.Message;
import accse.csc2a.ID_Generator;

/**
 * Ship is a class that contains Message objects & capable of printing messages, but isn't able to change the properties of the messages
 * @author TG Chipoyera 220150124
 * @version P02
 * @see Message,ID_Generator
 */
public class Ship {
    //PROPERTIES
    private static int Ship_No;
    private String ID;
    private String Name;
    private Message[] Messages;

    private static final String DEFAULT_NAME = "The Milky Default";
    private static final Message[] DEFAULT_MESSAGES = {new Message()};

    //CONSTRUCTORS

    /**
     * No args constructor, when Ship object is instantiated without args, it will have Ship default properties
     */
    public Ship(){ this.init(DEFAULT_NAME, DEFAULT_MESSAGES); }

    /**
     * When constructor is called, the object will be instantiated with a name but with default messages
     * @param Name - a string, this will be the name of the ship
     */
    public Ship(String Name){ this.init(Name, DEFAULT_MESSAGES); }

    /**
     * When ship object is instantiated, the ship will have the given name & messages
     * @param Name - a string, this will be the name of the ship
     * @param Messages - array of Message objects, the messages the ship object will contain
     */
    public Ship(String Name, Message[] Messages){ this.init(Name, Messages); }

    // NEW CONSTRUCTORS

    public Ship(String ID, String Name){
        this.init(ID, Name, DEFAULT_MESSAGES);
    }

    public Ship(String ID, String Name, Message[] Messages){
        this.init(ID, Name, Messages);
    }

    //GETTERS

    /**
     * Returns the ID of the Ship
     * @return string
     */
    public final String getID(){ return this.ID; }

    /**
     * Returns the name of the Ship
     * @return string
     */
    public final String getName(){ return this.Name; }

    /**
     * Returns all the messages it contains
     * @return Messages[]
     */
    public final Message[] getMessages(){ return this.Messages; }

    /**
     * Returns the number of messages the ship contains
     * @return integer
     */
    public final int numberOfMessages(){ return this.Messages.length; }

    /**
     * Outputs all the Ship's Messages' detail in the console
     */
    public void printMessages(){
        //Printing Ship Details
        System.out.printf("""
                Ship Name: %s
                Ship ID  : %s
                -------------
                """,
                this.Name,
                this.ID);

        //Printing the ships
        for (Message Message : this.Messages) {
            System.out.printf("""
                            ID                 : %s
                            Language           : %s
                            Message            : %s
                            Source Planet      : %s
                            Destination Planet : %s
                                            
                            """,

                    //passing
                    Message.getID(),
                    Message.getLanguage(),
                    Message.getMessage(),
                    Message.getPlanetString(Message.getSourcePlanet()),
                    Message.getPlanetString(Message.getDestinationPlanet()));
        }
    }

    //UTILITY FUNCTIONS
    private void init(String Name, Message[] Messages){
        this.ID = ID_Generator.Generate("SH", 4, Ship_No);
        Ship_No++;

        this.Name = Name;
        this.Messages = Messages;
    }

    private void init(String ID, String Name, Message[] Messages){
        // ID isn't auto generated, it's now provided
        this.ID = ID;
        this.Name = Name;
        this.Messages = Messages;
    }
}
