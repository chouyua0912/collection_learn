package z.learn.util.serviceloader;

public class DoSomething1 implements Provider {

    @Override
    public void doSomething(String msg) {
        System.out.println("[ " + msg + " ]");
    }
}
