package accse.csc2a.file;

import accse.csc2a.ID_Generator;
import accse.csc2a.Ship;
import accse.csc2a.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Ship is a class that contains Message objects & capable of printing messages, but isn't able to change the properties of the messages
 * @author TG Chipoyera 220150124
 * @version P02
 * @see Message,Ship
 */
public class fileHandler {
    public static Ship[] readFile(String filePath){
        Ship[] Ships = new Ship[0];
        File handle = new File(filePath);

        try(Scanner lines = new Scanner(handle)){
            while(lines.hasNext()){
                String line = lines.nextLine();

                //handling each line of text
                System.out.println(line);

            }

            return  new Ship[0];
        }catch (FileNotFoundException exception){
            //Printing errors
            System.err.println("Problem with file");
            exception.printStackTrace();

            // return default Ships array
            return new Ship[0];
        }
    }
}
