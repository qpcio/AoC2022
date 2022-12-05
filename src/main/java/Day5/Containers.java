package Day5;

import java.util.ArrayList;
import java.util.List;

public class Containers {
    ArrayList<Character>[] containers = new ArrayList[9];

    public Containers() {
        for (int i = 0; i < containers.length; i++) {
            containers[i] = new ArrayList<>();
        }
        containers[0].add('D');
        containers[0].add('B');
        containers[0].add('J');
        containers[0].add('V');

        containers[1].add('P');
        containers[1].add('V');
        containers[1].add('B');
        containers[1].add('W');
        containers[1].add('R');
        containers[1].add('D');
        containers[1].add('F');

        containers[2].add('R');
        containers[2].add('G');
        containers[2].add('F');
        containers[2].add('L');
        containers[2].add('D');
        containers[2].add('C');
        containers[2].add('W');
        containers[2].add('Q');

        containers[3].add('W');
        containers[3].add('J');
        containers[3].add('P');
        containers[3].add('M');
        containers[3].add('L');
        containers[3].add('N');
        containers[3].add('D');
        containers[3].add('B');

        containers[4].add('H');
        containers[4].add('N');
        containers[4].add('B');
        containers[4].add('P');
        containers[4].add('C');
        containers[4].add('S');
        containers[4].add('Q');

        containers[5].add('R');
        containers[5].add('D');
        containers[5].add('B');
        containers[5].add('S');
        containers[5].add('N');
        containers[5].add('G');

        containers[6].add('Z');
        containers[6].add('B');
        containers[6].add('P');
        containers[6].add('M');
        containers[6].add('Q');
        containers[6].add('F');
        containers[6].add('S');
        containers[6].add('H');

        containers[7].add('W');
        containers[7].add('L');
        containers[7].add('F');

        containers[8].add('S');
        containers[8].add('V');
        containers[8].add('F');
        containers[8].add('M');
        containers[8].add('R');
    }

    private void move1(int from, int to){
        from = from -1;
        to = to -1;
        int lastIndexFrom = containers[from].size()-1;
        char c = containers[from].get(lastIndexFrom);
        containers[from].remove(lastIndexFrom);
        containers[to].add(c);
    }

    public void moveMultiple(int number, int from, int to){
        for(int i=0;i<number;i++){
            move1(from,to);
        }
    }

    public void moveMultiple9001(int number,int from,int to){
        from = from -1;
        to = to -1;
        List<Character> sublist = new ArrayList<>();
        for(int i=number;i>0;i--){
            sublist.add(containers[from].get(containers[from].size()-i));
        }
        for(int i=1;i<=number;i++){
            containers[from].remove(containers[from].size()-1);
        }
        containers[to].addAll(sublist);
    }

    public String getAnswer1(){
        String result = "";
        for(int i=0;i< containers.length;i++){
            result += containers[i].get(containers[i].size()-1);
        }
        return result;
    }


}
