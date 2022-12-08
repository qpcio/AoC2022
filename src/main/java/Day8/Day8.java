package Day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8 {
    private static Forrest forrest;
    private static int size = 99;

    private static void readInput(String pathToInput){
        int[][] inputs = new int[size][size];
        try {
            java.io.File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            int y=0;
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                for (int x=0;x<size;x++){
                    inputs[x][y] = Integer.parseInt(String.valueOf(line.charAt(x)));
                }
                y++;
            }
            forrest = new Forrest(inputs);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        readInput("src/main/java/Day8/inputDay8.txt");
        System.out.println(forrest.countVisible());
        System.out.println(forrest.getLargestScenicScore());
    }

}
