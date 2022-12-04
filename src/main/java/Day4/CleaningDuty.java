package Day4;

import java.util.ArrayList;
import java.util.List;

public class CleaningDuty {
    List<Integer> elf1assignment = new ArrayList<>();
    List<Integer> elf2assignment = new ArrayList<>();

    public CleaningDuty(String input) {
        String[] elvesDuties = input.split(",");
        String[] elf1duties = elvesDuties[0].split("-");
        for (int i = Integer.parseInt(elf1duties[0]); i <= Integer.parseInt(elf1duties[1]); i++) {
            elf1assignment.add(i);
        }
        String[] elf2duties = elvesDuties[1].split("-");
        for (int i = Integer.parseInt(elf2duties[0]); i <= Integer.parseInt(elf2duties[1]); i++) {
            elf2assignment.add(i);
        }
    }

    public boolean isThereInclusion() {
        if (elf1assignment.get(0) <= elf2assignment.get(0) &&
                elf1assignment.get(elf1assignment.size() - 1) >= elf2assignment.get(elf2assignment.size() - 1)) {
            return true;
        } else if (elf2assignment.get(0) <= elf1assignment.get(0) &&
                elf2assignment.get(elf2assignment.size() - 1) >= elf1assignment.get(elf1assignment.size() - 1)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isThereOverlap() {
        if(isThereInclusion()){
            return true;
        }
        else if (elf1assignment.get(0) >= elf2assignment.get(0)
                && elf1assignment.get(0) <= elf2assignment.get(elf2assignment.size() - 1)) {
            return true;
        } else if (elf1assignment.get(elf1assignment.size() - 1) >= elf2assignment.get(0)
                && elf1assignment.get(elf1assignment.size() - 1) <= elf2assignment.get(elf2assignment.size() - 1)) {
            return true;
        } else {
            return false;
        }

    }

}
