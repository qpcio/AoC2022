package Day11;

public class WorryLevel {
    int moduloOf[] = new int[20];

    public boolean isDivisibleBy(int n){
        return moduloOf[n]==0;
    }

    public WorryLevel(int number){
        for(int i=2;i<moduloOf.length;i++){
                moduloOf[i]=number%i;
        }
    }

    public void add(int n){
        for (int i=2;i<moduloOf.length;i++){
            moduloOf[i] = (moduloOf[i]+n)%i;
        }
    }

    public void multiply(int n){
        for (int i=2;i< moduloOf.length;i++){
            moduloOf[i]=(moduloOf[i]*n)%i;
        }
    }

    public void power(){
        for (int i=2;i< moduloOf.length;i++){
            moduloOf[i]=(moduloOf[i]*moduloOf[i])%i;
        }
    }

}
