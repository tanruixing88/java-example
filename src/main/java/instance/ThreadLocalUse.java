package instance;

/**
 * Created by tanruixing on 2019/6/20.
 */
public class ThreadLocalUse {
    private void stringThreadLocal() {
        Thread t = new Thread(){
            ThreadLocal<String> mStringThreadLocal = new ThreadLocal<String>(){
                protected String initialValue() {
                    return Thread.currentThread().getName();
                }
            };

            public void run() {
                super.run();
                System.out.println(mStringThreadLocal.get());
                mStringThreadLocal.set("www.baidu.com");
                System.out.println(mStringThreadLocal.get());
            }
        };

        t.start();
    }
    public static void main(String[] args) {
        ThreadLocalUse threadLocalUse = new ThreadLocalUse();
        threadLocalUse.stringThreadLocal();
    }
}
