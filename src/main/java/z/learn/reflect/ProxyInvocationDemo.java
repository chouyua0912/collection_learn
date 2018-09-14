package z.learn.reflect;

import java.lang.reflect.Proxy;

/**
 * demo
 * 为什么不能是传入接口??
 */
public class ProxyInvocationDemo {

    public static void main(String[] args) {
        PrinterWithDate p = new PrinterWithDate();
        ProxyCreator creator = new ProxyCreator(p);
        // Printer proxyP = (Printer) Proxy.newProxyInstance(ProxyInvocationDemo.class.getClassLoader(), Printer.class.getInterfaces(), creator);
        // Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to z.learn.reflect.Printer
        //	at z.learn.reflect.ProxyInvocationDemo.main(ProxyInvocationDemo.java:13)
        Printer proxyP = (Printer) Proxy.newProxyInstance(ProxyInvocationDemo.class.getClassLoader(), p.getClass().getInterfaces(), creator);
        proxyP.print("what?");
    }
}
