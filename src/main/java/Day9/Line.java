package Day9;

public class Line {
    private Knot head = new Knot();
    private Knot knot1 = new Knot();
    private Knot knot2 = new Knot();
    private Knot knot3 = new Knot();
    private Knot knot4 = new Knot();
    private Knot knot5 = new Knot();
    private Knot knot6 = new Knot();
    private Knot knot7 = new Knot();
    private Knot knot8 = new Knot();
    private Knot tail = new Knot();

    public void processInput(String direction, String number) {
        int steps = Integer.parseInt(number);
        int dx = 0, dy = 0;
        if (direction.equals("U")) {
            dy = 1;
        } else if (direction.equals("D")) {
            dy = -1;
        } else if (direction.equals("R")) {
            dx = 1;
        } else {
            dx = -1;
        }
        for(int i=0;i<steps;i++){
            head.move(dx,dy);
            knot1.follow(head);
            knot2.follow(knot1);
            knot3.follow(knot2);
            knot4.follow(knot3);
            knot5.follow(knot4);
            knot6.follow(knot5);
            knot7.follow(knot6);
            knot8.follow(knot7);
            tail.follow(knot8);
        }
    }

    public void processInput1(String direction, String number) {
        int steps = Integer.parseInt(number);
        int dx = 0, dy = 0;
        if (direction.equals("U")) {
            dy = 1;
        } else if (direction.equals("D")) {
            dy = -1;
        } else if (direction.equals("R")) {
            dx = 1;
        } else {
            dx = -1;
        }
        for(int i=0;i<steps;i++){
            head.move(dx,dy);

            tail.follow(head);
        }
    }

    public Knot getTail() {
        return tail;
    }
}
