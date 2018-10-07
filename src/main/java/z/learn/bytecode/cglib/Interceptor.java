package z.learn.bytecode.cglib;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * MethodInterceptor继承自callback
 * Noop把不需要代理的方法过滤掉
 */
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
                    Callback[] callbacks = {interceptor, NoOp.INSTANCE};
                    Enhancer enhancer = new Enhancer();
                    enhancer.setSuperclass(clazz);
                    enhancer.setCallbacks(callbacks);       // 同时设置多个Callback，可以通过classFilter来筛选
                    enhancer.setCallbackFilter(new CallFilter());
                    obj = enhancer.create();
                    proxyCache.put(clazz, obj);
                }
            }
        }
        return clazz.cast(obj);
    }
}
