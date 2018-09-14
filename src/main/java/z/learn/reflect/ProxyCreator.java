package z.learn.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyCreator implements InvocationHandler {
    private Object target;

    ProxyCreator(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxied......");
        return method.invoke(target, args);
    }
}
