package z.learn;

import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 通过监听信号，触发系统停止动作
 * <p>
 * kill -15 3817 SIGTERM
 */
public class SystemExitExample {

    private static ThreadPoolExecutor executor
            = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));

    public static void main(String[] args) throws InterruptedException {
        SignalHandler handler = signal -> {
            System.out.println("received, " + signal);
            executor.shutdown();
            System.exit(1);
        };
        Signal.handle(new Signal("TERM"), handler);

        executor.execute(() -> System.out.println("executed.."));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("hook called..")));        // 调用exit方法也会调用注册的hook

        Thread.sleep(2 * 60 * 1000);
    }
}
