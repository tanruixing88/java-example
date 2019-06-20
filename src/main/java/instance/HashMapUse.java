package instance;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by tanruixing on 2019/6/18.
 */
public class HashMapUse {
    private HashMap<String, String> constHashMap = new HashMap<String, String>(){{
        put("zhangsan", "student0");
        put("lisi", "student1");
        put("wangwu", "student2");
    }};

    private TreeMap<String, String> constTreeMap = new TreeMap<String, String>(){{
        put("zhangsan", "student0");
        put("lisi", "student1");
        put("wangwu", "student2");
    }};

    public void traverseHashMap() {
        System.out.println("traverseHashMap start ...");
        constHashMap.forEach((k, v)->{
            System.out.println("key:" + k + " value:" + v);
        });
        constTreeMap.forEach((k, v)->{
            System.out.println("key:" + k + " value:" + v);
        });
        System.out.println("traverseHashMap end ...");
    }

    public static void main(String[] args) {
        HashMapUse hashMapUse = new HashMapUse();
        hashMapUse.traverseHashMap();
    }
}
