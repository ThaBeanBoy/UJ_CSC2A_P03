package accse.csc2a.file;

import accse.csc2a.Ship;
import accse.csc2a.Message;
import accse.csc2a.p03_utils;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ship is a class that contains Message objects & capable of printing messages, but isn't able to change the properties of the messages
 * @author TG Chipoyera 220150124
 * @version P02
 * @see Message,Ship
 */
public class fileHandler {
    public static Pattern ShipID_Pattern = Pattern.compile("SH\\d{4}");
    public static Pattern MessageID_Pattern = Pattern.compile("MSG\\d{6}");

    public static Ship[] readFile(String filePath){
        File handle = new File(filePath);

        try(Scanner lines = new Scanner(handle)){
            Ship[] Ships = new Ship[0];
            Message[] Messages = new Message[0];

            System.out.println("has next ? " + lines.hasNext());
            while(lines.hasNext()){
                String line = lines.nextLine();
                String[] words = line.split(" ");
                String[] ErrorLogs = new String[0];

                Matcher ShipMatcher = ShipID_Pattern.matcher(words[0]);
                Matcher MessageMatcher = MessageID_Pattern.matcher(words[0]);

                if(ShipMatcher.matches()) {
                    String ShipID = words[0];
                    StringBuilder ShipName = new StringBuilder(words[1]);
                    for(int i=2; i<words.length; i++)
                        ShipName.append(String.format(" %s", words[i]));

                    // Create Ship from previous & appending it
                    Ship previousShip = new Ship(ShipID, ShipName.toString(), Messages);
                    Ships = p03_utils.appendArray(Ships, previousShip);

                    // continuing to the next iteration
                    continue;
                }
                else if (MessageMatcher.matches()) {
                    final String MessageID = words[0],
                                 Language = words[1],
                                 Message = words[2],
                                 SourcePlanet = words[3],
                                 DestinationPlanet = words[4];

                    try {
                        // Creating a Message instance
                        Message MessageInLine = new Message(
                                MessageID,
                                Language,
                                Message,
                                SourcePlanet,
                                DestinationPlanet
                                );

                        if(Ships.length > 0)
                            Ships[Ships.length - 1].addMessage(MessageInLine);
                        else
                            ErrorLogs = p03_utils.appendArray(ErrorLogs, """
                                    There is no ship for this message, 
                                               there might've been an error with the first ship's details""");

                    }catch (Message.InvalidPlanetString exception){
                        ErrorLogs = p03_utils.appendArray(ErrorLogs, "Invalid Planet String");
                    }

                }else{
                    ErrorLogs = p03_utils.appendArray(ErrorLogs, "Invalid Line, Neither a Ship nor a Message");
                }

                //displaying errors if there are any errors to be displayed
                if(ErrorLogs.length > 0){
                    //Printing Errors in the line
                    System.out.println(String.format("""
                            ==================
                            |ERROR LOGS FOR -> %s
                            ------------------""", line));
                    for(String ErrMsg : ErrorLogs)
                        System.out.println(String.format("|ERR LOG : %s", ErrMsg));

                    System.out.println("==================\n\n");
                }
            }

            return Ships;
        }catch (FileNotFoundException exception){
            //Printing errors
            System.err.println("Problem with file");
            exception.printStackTrace();

            // return default Ships array
            return null;
        }
    }
}
