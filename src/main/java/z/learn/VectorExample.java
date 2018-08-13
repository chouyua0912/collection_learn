package z.learn;

import java.util.Vector;

public class VectorExample {


    public void example() {
        Vector<String> vector = new Vector<>();
        init(vector);
        System.out.println(vector.elementAt(10));        // 超过范围会抛出异常
    }

    public void example1() {
        Vector<String> vector = new Vector<>();
        init(vector);
        System.out.println(vector.elementAt(5));
    }

    public void example2() {
        Vector<String> vector = new Vector<>();
        init(vector);
        vector.remove("bbb");
        System.out.println(vector.elementAt(1));
    }

    void init(Vector<String> vector) {
        vector.add("aaa");
        vector.add("bbb");
        vector.add("ccc");
        vector.add("ddd");
        vector.add("eee");
        vector.add("fff");
        vector.add("ggg");
        vector.add("hhh");
        vector.add("iii");
    }
}
