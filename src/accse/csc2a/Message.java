package accse.csc2a;

import accse.csc2a.ID_Generator;

/**
 * Message class contains the Language the message is in, the message itself, the source planet of the message & the destination planet of the message
 * @author TG Chipoyera 220150124
 * @version P02
 * @see ID_Generator
 */
public class Message{
    private static int Message_No = 0;

    public static enum Planet {
        Mercury,
        Venus,
        Earth,
        Mars,
        Jupiter,
        Saturn,
        Uranus,
        Neptune,
        Pluto
    };

    public String ID;
    private String Language;
    private String Message;
    private Planet SourcePlanet;
    private Planet DestinationPlanet;

    public final static String DEFAULT_LANGUAGE = "Eng";
    public final static String DEFAULT_MESSAGE = "Hello World";
    public final static Planet DEFAULT_SOURCE_PLANET = Planet.Earth;
    public final static Planet DEFAULT_DESTINATION_PLANET = Planet.Mars;

    //CONSTRUCTORS

    /**
     * Creates message object with default properties
     */
    public Message(){
        this.init(
                DEFAULT_LANGUAGE,
                DEFAULT_MESSAGE,
                DEFAULT_SOURCE_PLANET,
                DEFAULT_DESTINATION_PLANET
        );
    }

    /**
     * Creates a Message object with user defined properties
     * @param Language, string - The language the Message is in
     * @param Message, string -  The message itself
     * @param SourcePlanet Planet -  The Planet where the message is coming from
     * @param DestinationPlanet Planet -  The Planet where the message is traveling to
     */
    public Message(String Language, String Message, Planet SourcePlanet, Planet DestinationPlanet){
        this.init(Language, Message, SourcePlanet, DestinationPlanet);
    }

    //PUBLIC METHODS

    /**
     * Returns the ID of the Message
     * @return string
     */
    public final String getID(){ return this.ID; }

    /**
     * Returns the language of the Message
     * @return string
     */
    public final String getLanguage(){ return this.Language; }

    /**
     * Returns the message
     * @return string
     */
    public final String getMessage() { return this.Message; }

    /**
     * Returns the Source Planet of the message
     * @return Planet
     */
    public final Planet getSourcePlanet() {return this.SourcePlanet; }

    /**
     * Returns the Destination Planet of the message
     * @return Planet
     */
    public final Planet getDestinationPlanet() { return this.DestinationPlanet; }


    //UTILITY FUNCTIONS
    private void init(String Language, String Message, Planet SourcePlanet, Planet DestinationPlanet){
        //Setting properties
        this.ID = ID_Generator.Generate("MSG", 6, Message_No);
        Message_No++;

        this.Language = Language;
        this.Message = Message;
        this.SourcePlanet = SourcePlanet;
        this.DestinationPlanet = DestinationPlanet;
    }

    /**
     * Returns the Planet in string form
     * @param Planet The Planet Enum
     * @return string
     */
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