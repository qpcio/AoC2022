package Day11;

public class Test {
    public static boolean[] dzielniki = new boolean[19];
    public static int[] resztaZDzieleniaPrzez = new int[19];
    public static void main(String[] args) {
        for(int i=0;i<dzielniki.length;i++){
            dzielniki[i]=false;
        }
        int liczba = 99;
        for (int i=1;i< resztaZDzieleniaPrzez.length;i++){
            resztaZDzieleniaPrzez[i]=liczba%i;
        }
        for (int i=2;i< resztaZDzieleniaPrzez.length;i++){
            System.out.println(i+" "+resztaZDzieleniaPrzez[i]);
        }

    }

    public static boolean isPrime(int n){
        if(n<2)return false;
        for(int i=2;i*i<2;i++){
                         if(n%i==0)return false;
        }
        return true;
    }
}
