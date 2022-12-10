package Day10;

import java.util.ArrayList;
import java.util.List;

public class Device {
    private List<Register> registry = new ArrayList<>();

   public void noop(){
        Register last = registry.get(registry.size()-1);
        registry.add(new Register(last.getPostCycleValue(),last.getPostCycleValue()));
   }

   public void addx(int value){
       Register last = registry.get(registry.size()-1);
       registry.add(new Register(last.getPostCycleValue(), last.getPostCycleValue()));
       registry.add(new Register(last.getPostCycleValue(), last.getPostCycleValue()+value));
   }

    public Device(Register startingRegister) {
       registry.add(startingRegister);
    }

    public int signalStrength(){
       return 20*registry.get(20).getInCycleValue()+
               60*registry.get(60).getInCycleValue()+
               100*registry.get(100).getInCycleValue()+
               140*registry.get(140).getInCycleValue()+
               180*registry.get(180).getInCycleValue()+
               220*registry.get(220).getInCycleValue();
    }

    private String[] display(){
       String[] disp = new String[240];
       for(int i=0;i<240;i++){
           int spritePos = registry.get(i+1).getInCycleValue();
           int iInCurrentLine = i%40;

           if(iInCurrentLine>=spritePos-1 && iInCurrentLine<=spritePos+1){
               disp[i] = "#";
           }else{
               disp[i]=".";
           }
       }
       return disp;
    }

    public void niceDisp(){
       String disp[] = display();
       for(int i=0;i<6;i++){
           for (int j=0;j<40;j++){
               System.out.print(disp[i*40+j]);
           }
           System.out.println();
       }
    }

}
