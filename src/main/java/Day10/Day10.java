package Day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day10 {
    private static Device device = new Device(new Register(1,1));

    private static void readInput(String pathToInput){
        try {
            java.io.File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.equals("noop")){
                    device.noop();
                }else {
                    String[] params = line.split(" ");
                    device.addx(Integer.parseInt(params[1]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        readInput("src/main/java/Day10/inputDay10.txt");
        System.out.println(device.signalStrength());
        device.niceDisp();
    }


}
