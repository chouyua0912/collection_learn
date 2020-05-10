package z.learn.lang;

public class AddDemo {

    public static void main(String[] args) {
        int i = 0;
        System.out.println("------start-------");
        System.out.println(i++);            // 0
        System.out.println(i);              // 1
        System.out.println(++i);            // 2
        System.out.println(i);              // 2
        i = i++;                            // 值不会变，会把之前的值赋给自己
        System.out.println(i);              // 2
        i = ++i;
        System.out.println(i);              // 3
        AddDemo demo = new AddDemo();
        demo.test();
    }

    final protected void test() {           // protected 方法也可以是final的
        System.out.println("haha");
    }

    static class AddDemoSon extends AddDemo {
/*        @Override
        public void test() {            // 不允许重写父类的方法

        }*/
    }
}
