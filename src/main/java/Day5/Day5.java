package Day5;

import Day4.CleaningDuty;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5 {
    private static Containers containers = new Containers();
    private static ContainersStr containersStr = new ContainersStr();
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        readInputAndRearrange("src/main/java/Day5/inputDay5.txt");
        System.out.println(containers.getAnswer1());
        System.out.println(System.currentTimeMillis()-time);


        time = System.currentTimeMillis();
        readInputAndRearrangeStr("src/main/java/Day5/inputDay5.txt");
        System.out.println(containersStr.getAnswer1());
        System.out.println(System.currentTimeMillis()-time);
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

    private static void readInputAndRearrangeStr(String pathToInput){
        try {
            File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replace("move ","").replace(" from "," ").replace(" to "," ");
                String[] parameters = line.split(" ");
                containersStr.moveMultiple9001(Integer.parseInt(parameters[0]),
                        Integer.parseInt(parameters[1]),
                        Integer.parseInt(parameters[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
