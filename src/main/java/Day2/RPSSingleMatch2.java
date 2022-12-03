package Day2;

public class RPSSingleMatch2 {
    String opponent;
    String you;
    String yourShape;

    //X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win
    public int matchpoint() {
        if (you.equals("X")) return 0;
        else if (you.equals("Y")) return 3;
        else return 6;
    }

    private void setYourShape(){
        if(opponent.equals("A")){
            if(you.equals("X"))yourShape="Z";
            else if (you.equals("Y")) {
                yourShape="X";
            }else yourShape="Y";
        } else if (opponent.equals("B")) {
            if(you.equals("X"))yourShape="X";
            else if (you.equals("Y")) {
                yourShape="Y";
            }else yourShape="Z";
        }else{ //opponent equals C - scissors
            if(you.equals("X"))yourShape = "Y";
            else if (you.equals("Y")) {
                yourShape = "Z";
            }
            else yourShape = "X";
        }
    }



    public int shapePoints() {
        if (yourShape.equals("X")) {
            return 1;
        } else if (yourShape.equals("Y")) {
            return 2;
        } else {
            return 3;
        }
    }

    public int totalScore() {
        return matchpoint() + shapePoints();
    }

    public RPSSingleMatch2(String opponent, String you) {
        this.opponent = opponent;
        this.you = you;
        this.setYourShape();
    }

    @Override
    public String toString() {
        return "RPSSingleMatch2{" +
                "opponent='" + opponent + '\'' +
                ", you='" + you + '\'' +
                ", yourShape='" + yourShape + '\'' +
                '}';
    }
}
