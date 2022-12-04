package Day4;

import Day3.Rucksack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {
    private static List<CleaningDuty> allDuties = new ArrayList<>();

    public static void main(String[] args) {
        readInput("src/main/java/Day4/inputDay4.txt");
        System.out.println(countInclusions());
        System.out.println(countOverlaps());
    }

    private static void readInput(String pathToInput) {
        try {
            File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                allDuties.add(new CleaningDuty(scanner.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static int countInclusions() {
        int result = 0;
        for (CleaningDuty cd : allDuties) {
              if(cd.isThereInclusion())result++;
        }
        return result;
    }

    private static int countOverlaps(){
        int result = 0;
        for (CleaningDuty cd:allDuties){
            if(cd.isThereOverlap())result++;
        }
        return result;
    }

}
