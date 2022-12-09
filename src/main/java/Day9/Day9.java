package Day9;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day9 {

    private static Line line = new Line();
    public static void main(String[] args) {
        readInput("src/main/java/Day9/inputDay9.txt");
        System.out.println(line.getTail().howMannyIveVisited());
    }

    private static void readInput(String pathToInput){
        try {
            java.io.File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String inputline[] = scanner.nextLine().split(" ");
                line.processInput(inputline[0],inputline[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

}
