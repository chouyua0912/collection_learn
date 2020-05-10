package z.learn.util;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String item : list) {      // foreach 语法糖，会被编译器自动转换成iterator调用
            if ("1".equals(item)) {
                list.remove(item);
            }
        }

        System.out.println(list);
    }
}
