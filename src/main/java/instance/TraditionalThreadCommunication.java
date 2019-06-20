package instance;

/**
 * @author tanruixing
 * Created on 2019-05-20
 */
public class TraditionalThreadCommunication {
    public synchronized void exec(int i, String fmt) {
        this.notify();
        System.out.println(fmt + " thread exec seq:" + i + " start");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(fmt + " thread exec seq:" + i + " end");
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

        for (int i = 0; i <= 5; i++) {
            traditionalThreadCommunication.exec(i, "main");
        }
    }
}
