package accse.csc2a;

/**
 * Suppose to generate IDs
 * @author TG Chipoyera 220150124
 * @version P02
 */
public class ID_Generator {
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
}
