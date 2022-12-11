package Day11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Trees {
    private List<Monkey> monkeys = new ArrayList<>();

    public void addMonkey(String[] items, String operation, String divisor, String ifTrue, String ifFalse) {
        this.monkeys.add(new Monkey(items, operation, divisor, ifTrue, ifFalse));
    }

    private void processItem(Monkey monkey) {
        long item = monkey.getFirstItem();
        monkey.deleteFirstItem();
        monkey.increaseInspected();
        item = monkey.newInternalWorryLevel(item);
//        item = item / 3;
        boolean decision = (item % monkey.getDivisor() == 0);
        if (decision) {
            monkeys.get(monkey.getThrowToIfTrue()).addItem(item);
        } else {
            monkeys.get(monkey.getThrowToIfFalse()).addItem(item);
        }
    }

    private void processWorryLevel(Monkey monkey) {
        monkey.increaseInspected();
        monkey.processFirstWorryLevel();
        if (monkey.getFirstWorryLevel().isDivisibleBy(monkey.getDivisor())) {
            monkeys.get(monkey.getThrowToIfTrue()).addWorryLevel(monkey.getFirstWorryLevel());
        } else {
            monkeys.get(monkey.getThrowToIfFalse()).addWorryLevel(monkey.getFirstWorryLevel());
        }
        monkey.deleteFirstWorryLevel();
    }

    private void processAllWorryLevels(Monkey monkey) {
        while (monkey.getNoOfWorryLevels() > 0) {
            processWorryLevel(monkey);
        }
    }

    public void processRoundWL() {
        for (Monkey m : monkeys) {
            processAllWorryLevels(m);
        }
    }

    private void processAllItems(Monkey monkey) {
        while (monkey.getNoOfItems() > 0) {
            processItem(monkey);
        }
    }

    public void processRound() {
        for (Monkey m : monkeys) {
            processAllItems(m);
        }
    }

    public void addMonkey(Monkey monkey) {
        monkeys.add(monkey);
    }

    public long task1() {
        List<Long> inspectedItems = new ArrayList<>();
        for (Monkey m : monkeys) {
            inspectedItems.add(m.getNumberOfInspectedItems());
        }
        Collections.sort(inspectedItems, Collections.reverseOrder());
        return inspectedItems.get(0) * inspectedItems.get(1);
    }

    public long totalInspected(){
        long result = 0;
        for (Monkey m:monkeys){
            result +=m.getNumberOfInspectedItems();
        }
        return result;
    }


}
