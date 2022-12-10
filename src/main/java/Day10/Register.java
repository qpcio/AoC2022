package Day10;

public class Register {
    private int inCycleValue;
    private int postCycleValue;

    public int getInCycleValue() {
        return inCycleValue;
    }

    public void setInCycleValue(int inCycleValue) {
        this.inCycleValue = inCycleValue;
    }

    public int getPostCycleValue() {
        return postCycleValue;
    }

    public void setPostCycleValue(int postCycleValue) {
        this.postCycleValue = postCycleValue;
    }

    public Register(int inCycleValue, int postCycleValue) {
        this.inCycleValue = inCycleValue;
        this.postCycleValue = postCycleValue;
    }
}
