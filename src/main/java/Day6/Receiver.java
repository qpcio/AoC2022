package Day6;

import java.util.ArrayList;
import java.util.List;

public class Receiver {
    private String buffer;

    public Receiver(String buffer) {
        this.buffer = buffer;
    }

    public int startOfData(int noOfDifferentCharsNeeded){
        for(int i=0;i<buffer.length()-4;i++){
            List<Character> characters = new ArrayList<>();
            characters.add(buffer.charAt(i));
            for(int j=1;j<noOfDifferentCharsNeeded;j++) {
                char currentChar = buffer.charAt(i + j);
                if (characters.contains(currentChar)) {
                    break;
                } else if (j != noOfDifferentCharsNeeded - 1) {
                    characters.add(buffer.charAt(i + j));
                } else {
                    return i + noOfDifferentCharsNeeded;
                }
            }

        }
        return 0;
    }
}
