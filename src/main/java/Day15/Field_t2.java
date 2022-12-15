package Day15;

import java.awt.*;

public class Field_t2 {
    Point sensor;
    Point beacon;

    int manhattanDistance;

    public Field_t2(Point sensor, Point beacon) {
        this.sensor = sensor;
        this.beacon = beacon;
        this.manhattanDistance = manhattanDistance(sensor,beacon);
    }

    public boolean isPointinRange(Point p){
        if(manhattanDistance(this.sensor,p)<=this.manhattanDistance)return true;
        else return false;
    }

    private int manhattanDistance(Point sensor, Point beacon) {
        return Math.abs(beacon.x - sensor.x) + Math.abs(beacon.y - sensor.y);
    }
}
