package instance;

/**
 * Created by w540 on 2019/6/18.
 */
public class FuncArgs {
    private int i = 2;

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public static void change(FuncArgs funcArgs) {
        funcArgs.setI(6);
    }

    public static void main(String[] args) {
        FuncArgs funcArgs = new FuncArgs();
        System.out.println("before change value:" + funcArgs.getI());
        change(funcArgs);
        System.out.println("after change value:" + funcArgs.getI());
    }
}
