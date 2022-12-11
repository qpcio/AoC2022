package Day11;

import java.util.ArrayList;
import java.util.List;

public class Monkey {
    private List<Long> items = new ArrayList<>();
    private List<WorryLevel> worryLevels= new ArrayList<>();
    private String operation;
    private int divisor;
    private int throwToIfTrue;
    private int throwToIfFalse;

    private long numberOfInspectedItems = 0;

    public long getNumberOfInspectedItems() {
        return numberOfInspectedItems;
    }

    public int getDivisor(){
        return divisor;
    }

    public int getThrowToIfTrue() {
        return throwToIfTrue;
    }
    public void addItem(long item){
        this.items.add(item);
    }
    public int getThrowToIfFalse() {
        return throwToIfFalse;
    }

    public long getFirstItem() {
        return items.get(0);
    }

    public void deleteFirstItem() {
        items.remove(0);
    }

    public WorryLevel getFirstWorryLevel(){
        return worryLevels.get(0);
    }

    public void deleteFirstWorryLevel(){
        worryLevels.remove(0);
    }

    public void increaseInspected() {
        this.numberOfInspectedItems++;
    }

    public long newInternalWorryLevel(long item) {

        long secondElement;
        String[] operations = this.operation.split(" ");
        if (operations[2].equals("old")) {
            secondElement = item;
        } else {
            secondElement = Integer.parseInt(operations[2]);
        }
        if (operations[1].equals("+")) {
            return item+secondElement;
        }else{
            return  item*secondElement;
        }
    }

    public void processFirstWorryLevel(){
        String[] operations = this.operation.split(" ");
        int secondElement=0;
        if (operations[2].equals("old")) {
            this.worryLevels.get(0).power();
        }else {
            secondElement = Integer.parseInt(operations[2]);
            if(operations[1].equals("+")){
                this.worryLevels.get(0).add(secondElement);
            }else {
                this.worryLevels.get(0).multiply(secondElement);
            }
        }


    }


    public int getNoOfItems(){
        return this.items.size();
    }


    public int getNoOfWorryLevels(){
        return this.worryLevels.size();
    }

    public Monkey(String[] items, String operation, String divisor, String ifTrue, String ifFalse) {
        for (String s : items) {
            this.items.add(Long.parseLong(s));
            this.worryLevels.add(new WorryLevel(Integer.parseInt(s)));
        }
        this.operation = operation;
        this.divisor = Integer.parseInt(divisor);
        this.throwToIfTrue = Integer.parseInt(ifTrue);
        this.throwToIfFalse = Integer.parseInt(ifFalse);
    }

    public void addWorryLevel(WorryLevel wl){
        worryLevels.add(wl);
    }
}
