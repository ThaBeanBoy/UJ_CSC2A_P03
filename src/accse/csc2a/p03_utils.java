package accse.csc2a;

import java.util.Arrays;

/**
 * Suppose to generate IDs
 * @author TG Chipoyera 220150124
 * @version P02
 */
public class p03_utils {
    /**
     * Generates the ID
     * @param Prefix The prefix to the ID number e.g 'MSG00000'
     * @param numberOfDigits the number of digits the ID should be
     * @param ID_no the actual ID number
     * @return string
     */
    public static String Generate(String Prefix, int numberOfDigits, int ID_no) {
        StringBuilder generatedID = new StringBuilder(Prefix);
        String ID_noString = String.valueOf(ID_no);

        int NoOfDigitsInMessageNo = ID_noString.length();
        int filler = numberOfDigits - NoOfDigitsInMessageNo;
        //Generating ID
        generatedID.append("0".repeat(filler));
        generatedID.append(ID_noString);

        return generatedID.toString();
    }
    /**
     * Through the use of generics, this function can work with any array.
     *     The reason why I did this is because I didn't want to make 2 seperate functions
     *     for the Ships & Message array, yet both functions would have used the same logic.

     @param arr - the original array, can be an array of any type
     @param newElement -  the new element that needs to be appended at the end of the arr
     */
    public static <T> T[] appendArray(T[] arr, T newElement){
        // Copying array content
        T[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = newElement;
        return newArr;
    }
}
