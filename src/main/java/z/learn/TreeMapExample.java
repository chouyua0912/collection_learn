package z.learn;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapExample {

    public void example() {
        example0();
    }

    private void example0() {
        TreeMap<String, String> map = new TreeMap<>();

        map.put("aaa", "aaa");
        map.put("bbb", "bbb");
        map.put("ccc", "ccc");
        map.put("ddd", "ddd");
        System.out.println("example0 lastEntry:" + map.lastEntry().getValue());
        System.out.println("example0 pollLastEntry:" + map.pollLastEntry().getValue());     // 删除最后的元素
        System.out.println("example0 pollFirstEntry:" + map.pollFirstEntry().getValue());
        System.out.println("example0 pollLastEntry:" + map.pollLastEntry().getValue());
        System.out.println("example0 pollLastEntry:" + map.pollLastEntry().getValue());
    }

    void example1() {
        TreeMap<Key, String> map = new TreeMap<>();

        map.put(new Key("aaa"), "aaa");
        map.put(new Key("bbb"), "bbb");
        System.out.println("example1 " + map.pollLastEntry().getValue());     // key必须实现Comparable接口
    }

    void example2() {
        TreeMap<Key, String> map = new TreeMap<>(comparator);

        map.put(new Key("aaa"), "aaa");
        map.put(new Key("bbb"), "bbb");
        System.out.println("example2 " + map.pollLastEntry().getValue());
    }


    class Key {
        private String key;

        Key(String key) {
            this.key = key;
        }

        String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    private Comparator<Key> comparator = Comparator.comparing(Key::getKey);
}
