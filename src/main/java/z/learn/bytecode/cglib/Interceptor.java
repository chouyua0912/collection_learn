package z.learn.bytecode.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Interceptor implements MethodInterceptor {

    private Interceptor() {
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("entered.. interceptor");
        Object obj = methodProxy.invokeSuper(o, objects);
        return obj;
    }

    private static Map<Class<?>, Object> proxyCache = new HashMap<>();

    public static <T> T newInstance(Class<T> clazz) {
        Object obj;
        if (null == (obj = proxyCache.get(clazz))) {
            synchronized (proxyCache) {
                if (null == (obj = proxyCache.get(clazz))) {
                    Interceptor interceptor = new Interceptor();
                    Enhancer enhancer = new Enhancer();
                    enhancer.setSuperclass(clazz);
                    enhancer.setCallback(interceptor);
                    enhancer.setCallbackFilter(new CallFilter());
                    obj = enhancer.create();
                    proxyCache.put(clazz, obj);
                }
            }
        }
        return clazz.cast(obj);
    }
}
