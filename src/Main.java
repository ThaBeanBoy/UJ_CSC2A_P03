import accse.csc2a.file.fileHandler;

import accse.csc2a.Ship;
public class Main {
    public static void main(String[] args) {
        Ship[] Ships = fileHandler.readFile("data/normal.txt");

//        for(Ship Ship : Ships)
//            System.out.println(Ship.getName());
        Ships[1].printMessages();;
    }
}