package Day3;

import Day2.RPSSingleMatch2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {
    static List<Rucksack> rucksacks = new ArrayList<>();

    private static void readInput(String pathToInput) {
        try {
            File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                rucksacks.add(new Rucksack(scanner.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        readInput("src/main/java/Day3/inputday3.txt");
        System.out.println(getRucksacksTotalValue());
        System.out.println(getBadgesTotalValue());
    }

    private static int getRucksacksTotalValue() {
        int result = 0;
        for (Rucksack r : rucksacks) {
            result += r.rucksackValue();
        }
        return result;
    }

    private static int getBadgesTotalValue() {
        int result = 0;
        for (int i = 0; i < rucksacks.size() - 2; i += 3) {
            result += rucksacks.get(i).badgeValue(rucksacks.get(i + 1), rucksacks.get(i + 2));
        }
        return result;
    }


}
