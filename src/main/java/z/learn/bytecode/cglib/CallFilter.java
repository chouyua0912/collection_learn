package z.learn.bytecode.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class CallFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        return 0;
    }
}
