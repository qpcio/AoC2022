package Day1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1A {
    private static List<Elf> elves = new ArrayList<>();


    private static void readInput(String pathToInput) {
        try {
            File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            Elf elf = new Elf();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("")) {
                    elves.add(elf);
                    elf = new Elf();
                } else {
                    elf.addFood(Integer.parseInt(line));
                }
            }
            elves.add(elf);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int getLargest() {
        int result = 0;
        for (Elf e : elves) {
            if (e.totalCalorieCount() > result) result = e.totalCalorieCount();
        }
        return result;
    }


    public static int getLargetThree() {
        List<Integer> calories = new ArrayList<>();
        for (Elf e : elves) {
            calories.add(e.totalCalorieCount());
        }
        Collections.sort(calories,Collections.reverseOrder());
        int res = calories.get(0)+calories.get(1)+calories.get(2);
        return res;

    }

    public static void main(String[] args) {
        readInput("src/main/java/Day1/input.txt");
        System.out.println(getLargest());
        System.out.println(getLargetThree());
    }

}
