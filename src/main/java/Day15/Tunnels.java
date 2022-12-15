package Day15;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Tunnels {
    Set<Point> coveredArea = new HashSet<>();

    public int interestingRow;

    public void parseLine(String s){
        s = s.replace("Sensor at ","")
                .replace(": closest beacon is at ",",")
                .replace(" ","")
                .replace("x=","")
                .replace("y=","");
        String[] params = s.split(",");
        Point sensor = new Point(Integer.parseInt(params[0]),Integer.parseInt(params[1]));
        Point beacon = new Point(Integer.parseInt(params[2]),Integer.parseInt(params[3]));
        addCoveredArea(sensor,beacon);
    }

    private void addCoveredArea(Point sensor, Point beacon) {
        int distance = manhattanDistance(sensor, beacon);
        if(this.interestingRow< sensor.y-distance || this.interestingRow> sensor.y+distance)return;
        int howManyToAdd = 2*distance - 2*Math.abs(this.interestingRow-sensor.y) + 1;
        for(int i=0;i<=howManyToAdd/2;i++){
            coveredArea.add(new Point(sensor.x-i,this.interestingRow));
            coveredArea.add(new Point(sensor.x+i,this.interestingRow));
        }
        coveredArea.remove(sensor);
        coveredArea.remove(beacon);
//        for (int i = 0; i <= distance; i++) {
//            for (int j = 0; j <= distance - i; j++) {
//                coveredArea.add(new Point(sensor.x + i, sensor.y + j));
//                coveredArea.add(new Point(sensor.x + i, sensor.y - j));
//                coveredArea.add(new Point(sensor.x - i, sensor.y + j));
//                coveredArea.add(new Point(sensor.x - i, sensor.y - j));
//            }
//        }
//        coveredArea.remove(beacon);
    }

    public int task1(int row) {
        int result = 0;
        for (Point p : coveredArea) {
            if(p.y==row)result++;
        }
        return result;
    }

    public int task1better(){
        return coveredArea.size();
    }

    private int manhattanDistance(Point sensor, Point beacon) {
        return Math.abs(beacon.x - sensor.x) + Math.abs(beacon.y - sensor.y);
    }

    public Tunnels(int interestingRow) {
        this.interestingRow = interestingRow;
    }

    public Point unCovered(){
        for(int i=0;i<4000000;i++){
            Point currentPoint = new Point(i, this.interestingRow);
            if(!coveredArea.contains(currentPoint))return currentPoint;
        }
        return null;
    }

    public boolean hasThatPoint(){
        return unCovered()!=null;
    }
}
