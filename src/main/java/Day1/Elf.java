package Day1;

import java.util.ArrayList;
import java.util.List;

public class Elf {
    private List<Integer> foods = new ArrayList<>();

    public void addFood(int cal){
        foods.add(cal);
    }

    public int totalCalorieCount(){
        int result = 0;
        for (int i:foods
             ) {
            result+=i;
        }
        return result;
    }
}
