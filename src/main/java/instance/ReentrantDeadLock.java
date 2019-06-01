package instance;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tanruixing on 2019/6/1.
 */
public class ReentrantDeadLock {

    public static void main(String[] args) throws InterruptedException{
        final ReentrantLock l1 = new ReentrantLock();
        final ReentrantLock l2 = new ReentrantLock();
         Thread t1 = new Thread() {
            public void run() {
                try {
                    System.out.println("t1 run start");
                    l1.lockInterruptibly();
                    System.out.println("t1 run step 1");
                    Thread.sleep(1000);
                    System.out.println("t1 run step 2");
                    l2.lockInterruptibly();
                    System.out.println("t1 run end");
                } catch (InterruptedException e) {
                    System.out.println("t1 interrupted");
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                try {
                    System.out.println("t2 run start");
                    l2.lockInterruptibly();
                    System.out.println("t2 run step 1");
                    Thread.sleep(1000);
                    System.out.println("t2 run step 2");
                    l1.lockInterruptibly();
                    System.out.println("t2 run end");
                } catch (InterruptedException e) {
                    System.out.println("t2 interrupted");
                }
            }
        };

        t1.start();
        t2.start();
        Thread.sleep(20000);
        t1.interrupt();
        t2.interrupt();
        t1.join();
        t2.join();
    }

}
