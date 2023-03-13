package accse.csc2a.file;

import accse.csc2a.Ship;
import accse.csc2a.Message;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Arrays;
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
            Ship[] Ships = null;

            // Loop creates Ship objects
            String previousShipLine = lines.nextLine();

            while(lines.hasNext()){
                String line = lines.nextLine();
                String[] words = line.split(" ");

                Matcher ShipMatcher = ShipID_Pattern.matcher(words[0]);
                Matcher MessageMatcher = MessageID_Pattern.matcher(words[0]);

                if(ShipMatcher.matches()) {
                    String[] previousShipLineArr = previousShipLine.split(" ");
                    // Preparing Ship details
                    String ShipID = previousShipLineArr[0];
                    StringBuilder ShipName = new StringBuilder(previousShipLineArr[1]);
                    for(int i=2; i<previousShipLineArr.length; i++)
                        ShipName.append(String.format(" %s", previousShipLineArr[i]));

                    // Create Ship from previous & appending it
                    Ship previousShip = new Ship(ShipID, ShipName.toString());
                    if(Ships == null) {
                        Ships = new Ship[]{previousShip};
                    }else
                        Ships = appendArray(Ships, previousShip);

//                    System.out.printf("Ships length : %d \n", Ships.length);

                    // Save this ship in the previousShipLine
                    previousShipLine = line;

                    // continuing to the next iteration
                    continue;
                }
                else if (MessageMatcher.matches()) {
                    // Creating a Message instance
//                    System.out.println("- Message instance");
                    continue;
                }

                //ERR
                System.out.println("This is where the danger is");
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

    /**
     * Through the use of generics, this function can work with any array.
     *     The reason why I did this is because I didn't want to make 2 seperate functions
     *     for the Ships & Message array, yet both functions would have used the same logic.

    @param arr - the original array, can be an array of any type
    @param newElement -  the new element that needs to be appended at the end of the arr
     */
    private static <T> T[] appendArray(T[] arr, T newElement){
        T[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = newElement;
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }
}
