package Day9;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Knot {
    private Point currentPosition = new Point(0, 0);
    private Set<Point> whereIveBeen = new HashSet<>();

    public Knot() {
        whereIveBeen.add(currentPosition);
    }

    public void move(int dx, int dy) {
        currentPosition = new Point(currentPosition.x + dx, currentPosition.y + dy);
        whereIveBeen.add(currentPosition);
    }

    public int howMannyIveVisited() {
        return whereIveBeen.size();
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public void follow(Knot head) {
        Point headPosition = head.getCurrentPosition();
        if (headPosition.distance(currentPosition) < 1.5) return;

        int dx = headPosition.x - currentPosition.x;
        int dy = headPosition.y - currentPosition.y;
        int movex = 0, movey = 0;
        if (dy == 2) {
            movey = 1;
            movex = dx;
        }
        if (dy == -2) {
            movey = -1;
            movex = dx;
        }
        if (dx == 2) {
            movex = 1;
            movey = dy;
        }
        if (dx == -2) {
            movex = -1;
            movey = dy;
        }
        if (dx == 2 && dy == 2) {
            movex = 1;
            movey = 1;
        }
        if (dx == 2 && dy == -2) {
            movex = 1;
            movey = -1;
        }
        if (dx == -2 && dy == 2) {
            movex = -1;
            movey = 1;
        }
        if (dx == -2 && dy == -2) {
            movex = -1;
            movey = -1;
        }
        this.move(movex, movey);

    }

}
