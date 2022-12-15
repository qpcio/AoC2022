package Day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day15 {
    private static Tunnels tunnels;

    public static void main(String[] args) {
        for(int i=0;i<=4000000;i++){
            System.out.println("processing line "+i);
            tunnels = new Tunnels(i);
            readInput("src/main/java/Day15/inputDay15.txt");
            if(tunnels.hasThatPoint()) System.out.println("line "+i);
        }
//        tunnels = new Tunnels(2000000);
//        readInput("src/main/java/Day15/inputDay15.txt");
//        System.out.println(tunnels.task1better());
    }


    private static void readInput(String pathToInput){
        try {
            java.io.File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                tunnels.parseLine(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
