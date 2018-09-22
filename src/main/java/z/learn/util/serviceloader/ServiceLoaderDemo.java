package z.learn.util.serviceloader;

import java.util.ServiceLoader;

/**
 * 类似于Spring工厂,将使用的类通过META-INF里面的配置来指定
 * <p>
 * Java SPI
 * <p>
 * SPI是Service Provider Interfaces的简称，是Java中定义的一个很重要的规范，SPI使得应用之间变得更灵活、程序间更解耦。
 * 一般在应用中会定义一个接口，具体的实现由对应的实现类去完成，即服务提供者（Service Provider）。
 * 模块与模块之间基于接口编程，模块之间不能对实现类进行硬编码、不能在代码里写具体的实现类，否则就违反了“可插拔原则”，如果要替换一种实现，就需要修改代码。
 * 此时，SPI提供了一种服务发现机制，完美解决了这个问题。
 * SPI机制基本思路是通过JDK提供的java.util.ServiceLoader类去主动发现服务，不需要硬编码具体的类。
 * 当服务接口有多个实现类（即服务提供者）时，在jar包的META-INF/services/目录下创建一个以服务接口命名的文件，
 * 文件内容是该服务接口的具体实现类的全类名，一行记录是一个实现类的全类名。当外部程序装配这个模块时，
 * 通过jar包的META-INF/services/目录里的配置文件就可以找到具体的实现类名，从而进行实例化、完成模块的注入。
 */
public class ServiceLoaderDemo {

    public static void main(String[] args) {
        System.out.println("hello world");
        ServiceLoader<Provider> loader = ServiceLoader.load(Provider.class);

        for (Provider provider : loader) {
            provider.doSomething("test");
        }
    }
}
