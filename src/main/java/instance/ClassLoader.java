package instance;

/**
 * Created by tanruixing on 2019/6/19.
 */
public class ClassLoader {

    public static void main (String[] args) {
        System.out.println("Bootstrap ClassLoader");
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("*************************");
        System.out.println("Extension ClassLoader");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("*************************");
        System.out.println("System ClassLoader");
        System.out.println(System.getProperty("java.class.path"));
        System.out.println("*************************");
        System.out.println(Thread.currentThread().getContextClassLoader());

    }
}


