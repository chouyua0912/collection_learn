package z.learn.lang.string;

/**
 * https://blog.csdn.net/qq_34490018/article/details/82110578
 */
public class StringIntern {

    public static void main(String[] args) {
        String s = "123";
        String s1 = new String("1") + "23";     // new 表示在堆里创一个对象，+号会被转化成StringBuilder.append
        String s2 = s1.intern();
        System.out.println(s == s1);
        System.out.println(s == s2);
        System.out.println(s1 == s2);
        System.out.println(s.equals(s1));
    }
}
