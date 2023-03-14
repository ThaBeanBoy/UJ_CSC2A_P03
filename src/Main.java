import accse.csc2a.file.fileHandler;

import java.util.Scanner;

import accse.csc2a.Ship;
public class Main {
    private static Scanner input =  new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("""
                Which file would you like to load?
                1. normal.txt
                2 large.txt
                3 corrupt.txt
                
                Option: """);
        int option = input.nextInt();

        System.out.println("\n\n PRINTING COLLECTED SHIPS \n\n");
        Ship[] Ships;
        switch(option){
            case 1 -> {
                Ships = fileHandler.readFile("data/normal.txt");
                for(Ship Ship : Ships)
                    Ship.printMessages();

            }
            case 2 -> {
                Ships = fileHandler.readFile("data/large.txt");
                for(Ship Ship : Ships)
                    Ship.printMessages();
            }
            case 3 -> {
                Ships = fileHandler.readFile("data/corrupt.txt");
                for(Ship Ship : Ships)
                    Ship.printMessages();
            }

            default -> {
                System.out.println("Invalid option");
                System.exit(0);
            }
        }
    }
}