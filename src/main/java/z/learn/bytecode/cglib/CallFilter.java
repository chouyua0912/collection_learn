package z.learn.bytecode.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class CallFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if (method.getName().contains("echo")) {
            return 1;
        }
        return 0;
    }
}
