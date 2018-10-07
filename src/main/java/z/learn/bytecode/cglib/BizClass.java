package z.learn.bytecode.cglib;

public class BizClass {

    public void sayHello(String msg) {
        System.out.println("Biz do say: " + msg);
    }

    public void sayNothing(int num) {
        System.out.println("say noting but num=" + num);
    }

    public void echo(String msg) {
        System.out.println("Echo: " + msg);
    }
}
