package Day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day12 {
    static int sizeX = 8;
    static int sizeY = 5;
    static char[][] field = new char[sizeX][sizeY];


    public static void main(String[] args) {
        readInput("src/main/java/Day12/testInput.txt");
        System.out.println("Done!");
    }


    private static void readInput(String pathToInput) {
        try {
            java.io.File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            int y = 0;
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                for (int x = 0; x < sizeX; x++) {
                    field[x][y] = line.charAt(x);
                }
                y++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
