package z.learn.bytecode.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibDemo {

    public static void main(String[] args) {
        Interceptor interceptor = new Interceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BizClass.class);
        enhancer.setCallback(interceptor);
        enhancer.setCallbackFilter(new CallFilter());

        BizClass bizClass = (BizClass) enhancer.create();
        bizClass.sayHello("OK.");
    }
}
