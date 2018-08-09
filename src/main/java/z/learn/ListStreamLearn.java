package z.learn;

import java.util.Arrays;
import java.util.List;

/**
 * 集合类接口 Collection 实现了stream()方法，通过 StreamSupport.stream(spliterator(), false) 创建出stream
 */
public class ListStreamLearn {

    public void example() {
        List<String> strs = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff");
        strs.stream().forEach(s -> System.out.println(s));
        System.out.println("-------------------------");
        strs.parallelStream().forEach(s -> System.out.println(s));
    }
}
