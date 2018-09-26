package z.learn.bytecode.cglib;

public class CglibDemo {

    public static void main(String[] args) {
        BizClass bizClass = Interceptor.newInstance(BizClass.class);
        bizClass.sayHello("OK.");
    }
}
