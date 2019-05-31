package instance;

/**
 * @author tanruixing
 * Created on 2019-05-20
 */
public class TraditionalThreadCommunication {
    private boolean syncFlag = true;

    public synchronized void exec(int i, String fmt) {
        this.notify();
        System.out.println(fmt + " thread exec seq:" + i);
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final TraditionalThreadCommunication traditionalThreadCommunication = new TraditionalThreadCommunication();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <= 5; i++) {
                    traditionalThreadCommunication.exec(i, "sub");
                }
            }
        }).start();

        for (int i = 1; i <= 5; i++) {
            traditionalThreadCommunication.exec(i, "main");
        }
    }
}
