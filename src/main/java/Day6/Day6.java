package Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Day6 {

    private static String buffer;

    public static void main(String[] args) {
        readInput("src/main/java/Day6/inputDay6.txt");
        Receiver receiver = new Receiver(buffer);
        System.out.println(receiver.startOfData(4));
        System.out.println(receiver.startOfData(14));
    }

    private static void readInput(String pathToInput){
        try {
            File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
               buffer = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
