package Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day7 {
    static FileSystem fileSystem = new FileSystem();

    public static void main(String[] args) {
       readInput("src/main/java/Day7/inputDay7.txt");
//        readInput("src/main/java/Day7/testInput.txt");
        fileSystem.root.calculateSize();
        System.out.println(fileSystem.getSizeSmallerThan(100000));

        //part 2
        long totalMemory = 70000000;
        long freeSpace = totalMemory - fileSystem.root.size;
        long neededMemory = 30000000;
        long haveToDeleteAtLeast = neededMemory - freeSpace;
//        System.out.println(haveToDeleteAtLeast);
        System.out.println(fileSystem.root.sizeOfSmallestThatIsAtLeas(haveToDeleteAtLeast,
                fileSystem.root.size));
    }

    private static void readInput(String pathToInput){
        try {
            java.io.File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                fileSystem.processLine(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }


}



