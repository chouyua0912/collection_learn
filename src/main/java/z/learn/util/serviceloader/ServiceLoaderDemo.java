package z.learn.util.serviceloader;

import java.util.ServiceLoader;

public class ServiceLoaderDemo {

    public static void main(String[] args) {
        System.out.println("hello world");
        ServiceLoader<Provider> loader = ServiceLoader.load(Provider.class);

        for (Provider provider : loader) {
            provider.doSomething("test");
        }
    }
}
