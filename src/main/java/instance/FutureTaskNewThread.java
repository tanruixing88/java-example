package instance;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author tanruixing
 * Created on 2019-05-20
 */
public class FutureTaskNewThread {
    public static void main(String[] args) {
        int sum = 0;
        ArrayList<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MyTask myTask = new MyTask(i);
            FutureTask<Integer> task = new FutureTask(myTask);
            futures.add(task);
            Thread thread = new Thread(task);
            thread.start();
        }

        for (Future<Integer> future : futures) {
            try {
                sum += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("all task work done. sum:" + sum);
    }
}

class MyTask implements Callable<Integer> {

    private  int index = 0;

    public MyTask(int i) {
        this.index = i;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("MyTask exec index:" + this.index);
        return this.index;
    }
}
