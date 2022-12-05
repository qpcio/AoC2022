package Day5;

public class ContainersStr {
    private String[] containers = new String[9];





    public ContainersStr() {
        containers[0] = "DBJV";
        containers[1] = "PVBWRDF";
        containers[2] = "RGFLDCWQ";
        containers[3] = "WJPMLNDB";
        containers[4] = "HNBPCSQ";
        containers[5] = "RDBSNG";
        containers[6] = "ZBPMQFSH";
        containers[7] = "WLF";
        containers[8] = "SVFMR";
    }

    private void move1(int from,int to){
        from--;
        to--;
        int lastIndex = containers[from].length()-1;
        char c = containers[from].charAt(lastIndex);
        containers[from] = containers[from].substring(0,lastIndex);
        containers[to] += c;
    }

    public void moveMultiple(int number, int from, int to){
        for(int i=0;i<number;i++){
            move1(from,to);
        }
    }

    public void moveMultiple9001(int number,int from, int to){
        from--;
        to--;
        String moved = containers[from].substring(containers[from].length()-number);
        containers[from] = containers[from].substring(0,containers[from].length()-number);
        containers[to] += moved;
    }

    public String getAnswer1(){
        String result = "";
        for(int i=0;i<containers.length;i++){
            result+=containers[i].charAt(containers[i].length()-1);
        }
        return result;
    }
}
