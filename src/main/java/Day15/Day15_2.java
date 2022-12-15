package Day15;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day15_2 {
    private static List<Field_t2> fields = new ArrayList<>();

    private static void readInput(String pathToInput){
        try {
            java.io.File input = new File(pathToInput);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                parseLine(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
    public static void parseLine(String s){
        s = s.replace("Sensor at ","")
                .replace(": closest beacon is at ",",")
                .replace(" ","")
                .replace("x=","")
                .replace("y=","");
        String[] params = s.split(",");
        Point sensor = new Point(Integer.parseInt(params[0]),Integer.parseInt(params[1]));
        Point beacon = new Point(Integer.parseInt(params[2]),Integer.parseInt(params[3]));
        fields.add(new Field_t2(sensor,beacon));
    }

    public static void main(String[] args) {
        readInput("src/main/java/Day15/inputDay15.txt");
        for(int y=0;y<=4000000;y++){
            if(y%1000000==0) System.out.println(y);
            for(int x=0;x<=4000000;x++){
                Point p = new Point(x,y);
                if(amITheOne(p)){
                    int theNumber = 4000000*p.x + p.y;
                    System.out.println("The number: "+theNumber);
                }
            }
        }
    }

    private static boolean amITheOne(Point p){
        for(Field_t2 f:fields){
            if(f.isPointinRange(p))return false;
        }
        return true;
    }
}
