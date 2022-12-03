package Day3;

public class Rucksack {
    String comparement1;
    String comparement2;
    String fullLine;

    private char sameElement() {
        for (char a : comparement1.toCharArray()) {
            for (char b : comparement2.toCharArray()) {
                if (a == b) return a;
            }
        }
        return 0;
    }

    public int value(char c) {
        int asciiValue = c;
        if (asciiValue < 96) { //65 -> 27
            return asciiValue - 38;
        } else {  // 97 -> 1
            return asciiValue - 96;
        }
    }

    public int rucksackValue() {
        return value(sameElement());
    }

    public Rucksack(String fullLine){
        this.fullLine=fullLine;
        this.comparement1 = this.fullLine.substring(0,this.fullLine.length()/2);
        this.comparement2 = this.fullLine.substring(this.fullLine.length()/2);
    }

    private char getBadge(Rucksack r2, Rucksack r3) {
        for (char c1 : this.fullLine.toCharArray()) {
            for (char c2 : r2.fullLine.toCharArray()) {
                for (char c3 : r3.fullLine.toCharArray()){
                    if(c1==c2 && c1 == c3)return c1;
                }
            }
        }
        return 0;
    }

    public int badgeValue(Rucksack r2,Rucksack r3){
        return value(getBadge(r2,r3));
    }


}
