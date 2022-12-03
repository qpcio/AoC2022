package Day2;

public class RPSSingleMatch {
    String opponent;
    String you;

    public int matchpoint() {
        if ((opponent.equals("A") && you.equals("Y")) ||
                (opponent.equals("B") && you.equals("Z")) ||
                (opponent.equals("C") && you.equals("X"))) {
            return 6;
        } else if ((opponent.equals("A") && you.equals("X")) ||
                (opponent.equals("B") && you.equals("Y")) ||
                (opponent.equals("C") && you.equals("Z"))) {
            return 3;
        } else {
            return 0;
        }
    }

    public int shapePoints() {
        if (you.equals("X")) {
            return 1;
        } else if (you.equals("Y")) {
            return 2;
        } else {
            return 3;
        }
    }

    public int totalScore(){
        return matchpoint()+shapePoints();
    }

    public RPSSingleMatch(String opponent, String you) {
        this.opponent = opponent;
        this.you = you;
    }

    @Override
    public String toString() {
        return "RPSSingleMatch{" +
                "opponent='" + opponent + '\'' +
                ", you='" + you + '\'' +
                '}';
    }
}
