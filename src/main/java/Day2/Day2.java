package Day2;

import Day1.Elf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    private static List<RPSSingleMatch> matches = new ArrayList<>();
    private static List<RPSSingleMatch2> matches2 = new ArrayList<>();

    private static void readInput(String pathToInput){
        try {
            File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] inputs = line.split(" ");
                matches.add(new RPSSingleMatch(inputs[0],inputs[1]));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(matches);
    }

    private static void readInput2(String pathToInput){
        try {
            File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] inputs = line.split(" ");
                matches2.add(new RPSSingleMatch2(inputs[0],inputs[1]));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //System.out.println(matches2);
    }

    private static int totalScore(){
        int result=0;
        for (RPSSingleMatch match:matches) {
            result+=match.totalScore();
        }
        return result;
    }

    private static int totalScore2(){
        int result=0;
        for (RPSSingleMatch2 match:matches2) {
            result+=match.totalScore();
        }
        return result;
    }

    public static void main(String[] args) {
        //readInput("src/main/java/Day2/inputday2.txt");
        //System.out.println(totalScore());
        readInput2("src/main/java/Day2/inputday2.txt");
        System.out.println(totalScore2());
    }
}
