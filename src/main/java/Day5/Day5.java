package Day5;

import Day4.CleaningDuty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5 {
    private static Containers containers = new Containers();
    public static void main(String[] args) {

        readInputAndRearrange("src/main/java/Day5/inputDay5.txt");
        System.out.println(containers.getAnswer1());
    }


    private static void readInputAndRearrange(String pathToInput) {

        try {
            File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replace("move ","").replace(" from "," ").replace(" to "," ");
                String[] parameters = line.split(" ");
                containers.moveMultiple9001(Integer.parseInt(parameters[0]),
                        Integer.parseInt(parameters[1]),
                        Integer.parseInt(parameters[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
}
