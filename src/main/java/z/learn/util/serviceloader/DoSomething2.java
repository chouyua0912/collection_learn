package z.learn.util.serviceloader;

import java.util.Date;

public class DoSomething2 implements Provider {

    @Override
    public void doSomething(String msg) {
        System.out.println("[" + new Date() + "] : " + msg);
    }
}
