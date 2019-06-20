package instance;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by tanruixing on 2019/6/19.
 */
public class InitObj implements Cloneable,Serializable {
    private int id = 1;
    public InitObj() {

    }

    public InitObj(Integer id) {
        this.id = id;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "InitObj id = " + id;
    }

    public static void main(String[] args) {
        System.out.println("init obj by keyword new");
        InitObj initObj1 = new InitObj(123);
        System.out.println(initObj1);
        System.out.println("****************************");
        System.out.println("");

        System.out.println("init obj by newInstance method of class");
        try {
            InitObj initObj2 = InitObj.class.newInstance();
            System.out.println(initObj2);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("****************************");
        System.out.println("");

        System.out.println("init obj by newInstance method of constructor");
        try {
            Constructor<InitObj> initObjConstructor = InitObj.class.getConstructor(Integer.class);
            try {
                InitObj initObj3 = initObjConstructor.newInstance(5);
                System.out.println(initObj3);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("****************************");
        System.out.println("");

        System.out.println("init obj by clone");
        try {
            InitObj initObj4 = (InitObj) initObj1.clone();
            System.out.println(initObj4);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("****************************");
        System.out.println("");

        System.out.println("init obj by serializable");
        try {
            //write obj
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("init a obj bin"));
            outputStream.writeObject(initObj1);
            outputStream.close();

            //read obj
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("init a obj bin"));
            try {
                InitObj initObj5 = (InitObj)inputStream.readObject();
                System.out.println(initObj5);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");
        System.out.println("****************************");
    }
}
