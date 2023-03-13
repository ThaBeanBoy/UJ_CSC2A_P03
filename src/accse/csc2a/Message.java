package accse.csc2a;

import static accse.csc2a.Message.Planet.*;

/**
 * Message class contains the Language the message is in, the message itself, the source planet of the message & the destination planet of the message
 * @author TG Chipoyera 220150124
 * @version P02
 * @see p03_utils
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

    // NEW CONSTRUCTORS

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
        this.ID = p03_utils.Generate("MSG", 6, Message_No);
        Message_No++;

        this.Language = Language;
        this.Message = Message;
        this.SourcePlanet = SourcePlanet;
        this.DestinationPlanet = DestinationPlanet;
    }

    private void init(String Language, String Message, String SourcePlanet, String DestinationPlanet) throws InvalidPlanetString{
        try{
            this.ID = p03_utils.Generate("MSG", 6, Message_No);
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

    /**
     * Returns the Planet in string form
     * @param Planet The Planet Enum
     * @return string
     */
    public static String PlanetToString(Planet Planet){
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