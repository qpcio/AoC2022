package Day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day11 {
    private static Trees trees = new Trees();

    private static void readInput(String pathToInput){
        try {
            java.io.File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            String items="",operation="",divisor="",ifTrue="",ifFalse="";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.contains("Monkey")){}
                if(line.contains("Starting"))items=line;
                if(line.contains("Operation"))operation=line;
                if(line.contains("Test"))divisor=line;
                if(line.contains("If true"))ifTrue=line;
                if(line.contains("If false")){
                    ifFalse=line;
                    items=items.replace("  Starting items: ","")
                            .replace(" ","");
                    operation = operation.replace("  Operation: new = ","");
                    divisor = divisor.replace("  Test: divisible by ","");
                    ifTrue = ifTrue.replace("    If true: throw to monkey ","");
                    ifFalse = ifFalse.replace("    If false: throw to monkey ","");
                    trees.addMonkey(new Monkey(items.split(","),operation,divisor,ifTrue,ifFalse));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }




    public static void main(String[] args) {
        readInput("src/main/java/Day11/inputDay11.txt");
        System.out.println(trees.totalInspected());
        for(int i=0;i<10000;i++){
            trees.processRoundWL();
        }
        System.out.println(trees.task1());
    }

}
